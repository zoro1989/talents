package com.ccbjb.common.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 利用POI实现对Excel文件的读取。支持03、07、10版本的Excel文件读取。
  
 * @version 1.0
 * @see ExcelReader
 *
 */
public class PoiExcelReader extends ExcelReader {

	/**
	 * 构造方法
	 * @param excelFilePath Excel文件绝对路径
	 * @throws QMException
	 */
	public PoiExcelReader(String excelFilePath) throws Exception {
		super(excelFilePath);
	}

	/**
	 * 构造方法
	 * @param excelFile Excel文件绝对路径
	 * @throws QMException
	 */
	public PoiExcelReader(byte[] excelFile) throws Exception {
		super(excelFile);
	}

	@Override
	public List<String[]> read() throws Exception {
		List<String[]> list = new ArrayList<String[]>();
		try {
			Workbook wb = getWorkbook();
			list.addAll(read(0, wb));
		} catch(Exception e) {
			throw e;
		}
		return list;
	}

	@Override
	public Map<String, List<String[]>> readAllSheets() throws Exception {
		Map<String, List<String[]>> map = new HashMap<String, List<String[]>>();
		try {
			Workbook wb = getWorkbook();
			int sheetsCount = wb.getNumberOfSheets();
			for(int sheetIndex = 0; sheetIndex < sheetsCount; sheetIndex++) {
				Sheet st = wb.getSheetAt(sheetIndex);
				map.put(st.getSheetName(), read(sheetIndex, wb));
			}
		} catch(Exception e) {
			throw e;
		}
		return map;
	}
	
	/**
	 * 根据文件流获取Excel的workbook。
	 * @return
	 * @throws IOException
	 */
	private Workbook getWorkbook() throws IOException {
		InputStream stream = getFileStream(); 
		return isOldVersionExcel ? new HSSFWorkbook(stream) : new XSSFWorkbook(
				stream);
	}
	
	/**
	 * 读取Excel文件指定Sheet并获取该Sheet的数据
	 * @param sheetIndex Excel文件的Sheet，从0开始
	 * @return List<Object[]> List的每一条记录是一行结果，Object[]是一行中的所有列内容
	 * @throws QMException
	 */
	public List<String[]> read(int sheetIndex) throws Exception {
		return read(sheetIndex, null);
	}
	
	/**
	 * 读取Excel文件指定Sheet并获取该Sheet的数据
	 * @param sheetIndex Excel文件的Sheet，从0开始
	 * @param wb workbook,可以为null
	 * @return List<Object[]> List的每一条记录是一行结果，Object[]是一行中的所有列内容
	 * @throws QMException
	 */
	private List<String[]> read(int sheetIndex, Workbook wb) throws Exception {
		List<String[]> list = new ArrayList<String[]>();
		try {
			if(wb == null) {
				wb = getWorkbook();
			}
			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
			Sheet sheet = wb.getSheetAt(sheetIndex);

			//取行数
			int lastRow1 = sheet.getLastRowNum();  //取sheet中的最后一行 的其一方法
			int lastRow2 = sheet.getPhysicalNumberOfRows();  //取sheet中的最后一行 的其二方法
			int lastRow = (lastRow1 > lastRow2 ? lastRow1 : lastRow2);
			
			if(lastRow == 0) {
				return list;
			}
				
			//取列数
			int lastCellNum = sheet.getRow(0).getLastCellNum();
			for (int rowIndex = startRowOfReading; rowIndex <= lastRow; rowIndex++) {
				Row row = sheet.getRow(rowIndex);
				//行可能为空
				if(row == null) {
					continue;
				}
				String[] results = new String[lastCellNum];
				for (int cellIndex = 0; cellIndex < lastCellNum; cellIndex++) {
					Cell cell = row.getCell(cellIndex);
					//单元格可能为空
					if(cell == null) {
						continue;
					}
					results[cellIndex] = getCellValue(evaluator, cell);
				}
				
				//如果该行的所有cell都为null，则不要该行
				boolean foundValidData = false;
				for(String r : results) {
					if(r != null) {
						foundValidData = true;
						break;
					}
				}
				if(foundValidData) {
					list.add(results);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return list;
	}
	
	/**
	 * 获取单元格的值
	 * @param cell 单元格
	 * @return
	 */
	private String getCellValue(FormulaEvaluator evaluator, Cell cell) {
		if(cell == null) {
			return null;
		}
		
		CellValue cellValue = evaluator.evaluate(cell);
		if(cellValue == null) {
			return null;
		}
		
		switch (cellValue.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			String result = cell.getStringCellValue() == null ? "" : cell.getStringCellValue().trim();
			return "".equals(result) ? null : result;
		case Cell.CELL_TYPE_BLANK:
			return null;
		case Cell.CELL_TYPE_BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case Cell.CELL_TYPE_ERROR:
			return String.valueOf(cell.getErrorCellValue());
		case Cell.CELL_TYPE_NUMERIC:
			boolean isDate = DateUtil.isCellDateFormatted(cell);
			if(isDate) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				return format.format(cell.getDateCellValue());
			} else {
				Double d = cell.getNumericCellValue();
				DecimalFormat df = new DecimalFormat("#.#####");
				String value = df.format(d);
				//return handleIntHasPoint(cell.getNumericCellValue());
//	            DecimalFormat df = new DecimalFormat("0");
//	            result = df.format(cell.getNumericCellValue());
//	            if (result.endsWith(".0")) {
//	                result = result.substring(0, result.lastIndexOf("."));
//	            }
	            return value;
			}
		case Cell.CELL_TYPE_FORMULA:
			return cell.getCellFormula();
		default:
			return null;
		}
	}

	/**
	 * 检查指定sheet页面的 表头是否符合规范。（校验Excel文件模板是否正确）
	 * @param sheetIndex 指定Sheet页
	 * @param rowNumber 指定行，从0开始
	 * @param headerNames 表头内容
	 * @return <code>true</code>表示匹配成功，符合规范。否则为<code>false</code>
	 * @throws QMException
	 */
	@Override
	public boolean checkHeader(int sheetIndex, int rowNumber, String[] headerNames)
			throws Exception {
		try {
			Workbook wb = getWorkbook();
			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
			Sheet sheet = wb.getSheetAt(sheetIndex);
			Row row = sheet.getRow(rowNumber);
			int cellNumbers = row.getPhysicalNumberOfCells();
			if(cellNumbers != headerNames.length) {
				return false;
			}
			for(int i = 0; i < cellNumbers; i++) {
				Object value = getCellValue(evaluator, row.getCell(i));
				if(!headerNames[i].equalsIgnoreCase((String)value)) {
					return false;
				}
			}
		} catch(Exception e) {
			throw e;
		}
		return true;
	}
}
