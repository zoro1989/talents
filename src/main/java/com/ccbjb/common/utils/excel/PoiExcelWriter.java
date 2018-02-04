package com.ccbjb.common.utils.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 利用POI向Excel文件写数据的类
 * 
  
 * @version 1.0
 * @since 2013.1.25
 * @see ExcelWriter
 * 
 */
public abstract class PoiExcelWriter extends ExcelWriter {

	/**
	 * 构造方法
	 * 
	 * @param dataList
	 *            输出到Excel文件中的数据。List的每一条是一行，Object[]数组是一列
	 * @param excelFilePath
	 *            要输出的Excel文件路径，不能为空，且路径有效并不能为文件夹.
	 */
	public PoiExcelWriter(List<Object[]> dataList, String excelFilePath) {
		super(dataList, excelFilePath);
	}

	@Override
	public void write() throws IOException {
		if (dataList.size() == 0) {
			return;
		}
		Workbook wb = getWorkbook();
		Sheet sheet = wb.createSheet("Sheet1");
		for (int rowIndex = 0, len = dataList.size(); rowIndex < len; rowIndex++) {
			Row row = sheet.createRow(rowIndex);
			Object[] datas = dataList.get(rowIndex);
			for (int columnIndex = 0; columnIndex < datas.length; columnIndex++) {
				Cell cell = row.createCell(columnIndex);
				cell.setCellValue(datas[columnIndex].toString());
			}
		}
		OutputStream os = new FileOutputStream(excelFilePath);
		wb.write(os);
		os.close();
	}

	/**
	 * 获得Excle的workbook
	 * 
	 * @return Excle的workbook
	 * @throws IOException
	 */
	protected abstract Workbook getWorkbook() throws IOException;
}
