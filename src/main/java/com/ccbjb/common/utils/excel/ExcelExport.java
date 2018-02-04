package com.ccbjb.common.utils.excel;

import org.apache.poi.hssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * excel导出
 * 
 */
public class ExcelExport<T> {
	// 格式化日期
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 
	 * @param sheetname
	 *            Sheet页名称
	 * @param filename
	 *            文件名
	 * @param dataset
	 * @throws IOException
	 */
	public void exportExcel(String sheetname, String filename, Collection<T> dataset, String outfilePath)
			throws IOException {
//		String codedFileName = java.net.URLEncoder.encode(filename, "UTF-8");
//		codedFileName = codedFileName + ".xls";
		File outDir = new File(outfilePath);
		if(!outDir.exists()) {
			outDir.mkdirs();
		}
		File outputFile = new File(outfilePath + filename + ".xls");
		outputFile.createNewFile();
		OutputStream fOut = new FileOutputStream(outputFile);

		try {
			exportExcel(sheetname, dataset, fOut);
		} catch (Exception ex) {

		} finally {
			try {
				fOut.flush();
				fOut.close();
			} catch (IOException e) {

			}
		}
	}

	/**
	 *
	 * @param excelDto
	 *            excel传输dto
	 * @throws IOException
	 */
	public void exportExcelSheets(ExcelVo excelDto)
			throws IOException {
		File outDir = new File(excelDto.getOutfilePath());
		if(!outDir.exists()) {
			outDir.mkdirs();
		}
		File outputFile = new File(excelDto.getOutfilePath() + excelDto.getFilename() + ".xls");
		outputFile.createNewFile();
		OutputStream fOut = new FileOutputStream(outputFile);

		try {
			exportExcelSheets(excelDto.getSheets(), fOut);
		} catch (Exception ex) {

		} finally {
			try {
				fOut.flush();
				fOut.close();
			} catch (IOException e) {

			}
		}
	}
	
//	public void  exportExcelmdc(List<String> title, String filename, ArrayList<List> list)
//			throws IOException {
//		HSSFWorkbook workbookreturn = null;
//		String codedFileName = java.net.URLEncoder.encode(filename, "UTF-8");
//		response.setHeader("content-disposition", "attachment;filename="
//				+ codedFileName + ".xls");
//		OutputStream fOut = response.getOutputStream();
//		try {
//			exportExcelmdc(title, list, fOut);
//		} catch (Exception ex) {
//
//		} finally {
//			try {
//				fOut.flush();
//				fOut.close();
//			} catch (IOException e) {
//
//			}
//		}
//
//	}

	/**
	 *
	 * @param sheets
	 *            sheet页 多个
	 * @param out
	 *            输出流
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void exportExcelSheets(List<ExcelSheetDto> sheets, OutputStream out) {
		// 声明一个工作薄
		try {
			HSSFWorkbook workbook = new HSSFWorkbook();
			for (ExcelSheetDto sheetDto: sheets) {
				// 首先检查数据看是否是正确的
				Iterator<T> its = sheetDto.getDataset().iterator();
//				if (sheetDto.getDataset() == null || !its.hasNext() || sheetDto.getSheetname() == null
//						|| out == null) {
//					throw new Exception("传入的数据不对！");
//				}
				if (sheetDto.getDataset() == null || sheetDto.getSheetname() == null
						|| out == null) {
					throw new Exception("传入的数据不对！");
				}

				// 生成一个表格
				HSSFSheet sheet = workbook.createSheet(sheetDto.getSheetname());
				// 设置表格默认列宽度为15个字节
				sheet.setDefaultColumnWidth(15);
				// 标题样式
				HSSFCellStyle style = workbook.createCellStyle();
				HSSFCellStyle bodystyle = workbook.createCellStyle();
				// 设置标题样式
				style = ExcelStyle.setHeadStyle(workbook, style);
				// 设置表格样式
				bodystyle = ExcelStyle.setbodyStyle(workbook, bodystyle);

				if(!its.hasNext()) {
					continue;
				}
				// 取得实际泛型类
				T ts = (T) its.next();
				Class tCls = ts.getClass();

				// 得到所有字段
				Field filed[] = ts.getClass().getDeclaredFields();
				// 标题
				List<String> exportfieldtile = new ArrayList<String>();
				// 导出的字段的get方法
				List<Method> methodObj = new ArrayList<Method>();
				// 遍历整个filed
				for (int i = 0; i < filed.length; i++) {
					Field f = filed[i];
					// 如果设置了annottion
					if (f.isAnnotationPresent(ExcelColumn.class)) {
						ExcelColumn exa = f.getAnnotation(ExcelColumn.class);
						String exprot = exa.name();
						// 添加到标题
						exportfieldtile.add(exprot);
						// 添加到需要导出的字段的方法
						String fieldname = f.getName();
						String getMethodName = "get"
								+ fieldname.substring(0, 1).toUpperCase()
								+ fieldname.substring(1);

						Method getMethod = tCls.getMethod(getMethodName,
								new Class[] {});


						methodObj.add(getMethod);
					}
				}
				// 产生表格标题行
				HSSFRow row = sheet.createRow(0);
				for (int i = 0; i < exportfieldtile.size(); i++) {
					HSSFCell cell = row.createCell(i);
					cell.setCellStyle(style);
					HSSFRichTextString text = new HSSFRichTextString(
							exportfieldtile.get(i));
					cell.setCellValue(text);
				}

				int index = 0;

				// 循环整个集合

				// 第一行
				index++;
				row = sheet.createRow(index);
				for (int k = 0; k < methodObj.size(); k++) {
					HSSFCell cell = row.createCell(k);
					cell.setCellStyle(bodystyle);
					Method getMethod = methodObj.get(k);
					Object value = getMethod.invoke(ts, new Object[] {});
					String textValue = getValue(value);
					cell.setCellValue(textValue);
				}

				while (its.hasNext()) {
					// 从第二行开始写，第一行是标题
					index++;
					row = sheet.createRow(index);
					T t = (T) its.next();
					for (int k = 0; k < methodObj.size(); k++) {
						HSSFCell cell = row.createCell(k);
						cell.setCellStyle(bodystyle);
						Method getMethod = methodObj.get(k);
						Object value = getMethod.invoke(t, new Object[] {});
						String textValue = getValue(value);
						cell.setCellValue(textValue);

					}

				}
				for (int i = 0; i < exportfieldtile.size(); i++) {
					sheet.autoSizeColumn(i);
				}
			}
			workbook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @param title
	 *            标题
	 * @param dataset
	 *            集合
	 * @param out
	 *            输出流
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void exportExcel(String title, Collection<T> dataset, OutputStream out) {
		// 声明一个工作薄
		try {
			// 首先检查数据看是否是正确的
			Iterator<T> its = dataset.iterator();
//			if (dataset == null || !its.hasNext() || title == null
//					|| out == null) {
//				throw new Exception("传入的数据不对！");
//			}
			if (dataset == null || title == null || out == null) {
				throw new Exception("传入的数据不对！");
			}

			HSSFWorkbook workbook = new HSSFWorkbook();
			// 生成一个表格
			HSSFSheet sheet = workbook.createSheet(title);
			// 设置表格默认列宽度为15个字节
			sheet.setDefaultColumnWidth(15);
			// 标题样式
			HSSFCellStyle style = workbook.createCellStyle();
			HSSFCellStyle bodystyle = workbook.createCellStyle();
			// 设置标题样式
			style = ExcelStyle.setHeadStyle(workbook, style);
			// 设置表格样式
			bodystyle = ExcelStyle.setbodyStyle(workbook, bodystyle);

			if(!its.hasNext()) {
				return;
			}
			// 取得实际泛型类
			T ts = (T) its.next();
			Class tCls = ts.getClass();

			// 得到所有字段
			Field filed[] = ts.getClass().getDeclaredFields();
			// 标题
			List<String> exportfieldtile = new ArrayList<String>();
			// 导出的字段的get方法
			List<Method> methodObj = new ArrayList<Method>();
			// 遍历整个filed
			for (int i = 0; i < filed.length; i++) {
				Field f = filed[i];
				// 如果设置了annottion
				if (f.isAnnotationPresent(ExcelColumn.class)) {
					ExcelColumn exa = f.getAnnotation(ExcelColumn.class);
					String exprot = exa.name();
					// 添加到标题
					exportfieldtile.add(exprot);
					// 添加到需要导出的字段的方法
					String fieldname = f.getName();
					String getMethodName = "get"
							+ fieldname.substring(0, 1).toUpperCase()
							+ fieldname.substring(1);

					Method getMethod = tCls.getMethod(getMethodName,
							new Class[] {});


					methodObj.add(getMethod);
				}
			}
			// 产生表格标题行
			HSSFRow row = sheet.createRow(0);
			for (int i = 0; i < exportfieldtile.size(); i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style);
				HSSFRichTextString text = new HSSFRichTextString(
						exportfieldtile.get(i));
				cell.setCellValue(text);
			}

			int index = 0;

			// 循环整个集合

			// 第一行
			index++;
			row = sheet.createRow(index);
			for (int k = 0; k < methodObj.size(); k++) {
				HSSFCell cell = row.createCell(k);
				cell.setCellStyle(bodystyle);
				Method getMethod = methodObj.get(k);
				Object value = getMethod.invoke(ts, new Object[] {});
				String textValue = getValue(value);
				cell.setCellValue(textValue);
			}

			while (its.hasNext()) {
				// 从第二行开始写，第一行是标题
				index++;
				row = sheet.createRow(index);
				T t = (T) its.next();
				for (int k = 0; k < methodObj.size(); k++) {
					HSSFCell cell = row.createCell(k);
					cell.setCellStyle(bodystyle);
					Method getMethod = methodObj.get(k);
					Object value = getMethod.invoke(t, new Object[] {});
					String textValue = getValue(value);
					cell.setCellValue(textValue);
				}

			}
			for (int i = 0; i < exportfieldtile.size(); i++) {
				sheet.autoSizeColumn(i);
			}
			workbook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getValue(Object value) {
		String textValue = "";
		if (value == null) {
			return textValue;
		}

		if (value instanceof Boolean) {
			boolean bValue = (Boolean) value;
			textValue = "是";
			if (!bValue) {
				textValue = "否";
			}
		} else if (value instanceof Date) {
			Date date = (Date) value;

			textValue = sdf.format(date);
		} /*
		 * else if (value instanceof Enum) { EnumText enumanno =
		 * value.getClass().getAnnotation(EnumText.class); if(enumanno!=null) {
		 * String[] values = enumanno.value(); Object[] enumArray =
		 * value.getClass().getEnumConstants(); for (int i = 0; i <
		 * enumArray.length; i++) { if
		 * (enumArray[i].toString().equals(value.toString())) { textValue =
		 * values[i]; return textValue; } } } textValue = value.toString(); }
		 */
		else {
			textValue = value.toString();
		}

		return textValue;
	}

	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void exportExcelmdc(List<String> title, ArrayList<List> list,
			OutputStream out) {
		// 声明一个工作薄
		try {
			
			HSSFWorkbook workbook = new HSSFWorkbook();
			
			
			for (int ww = 0; ww < title.size(); ww++) {
				if(list.get(ww).size() == 0){
					Iterator<T> its = list.get(ww).iterator();
					T ts = (T) its.getClass();
					Class tCls = ts.getClass();
					// 生成一个表格
					HSSFSheet sheet = workbook.createSheet(title.get(ww));
					// 设置表格默认列宽度为15个字节
					sheet.setDefaultColumnWidth(15);
					// 标题样式
					HSSFCellStyle style = workbook.createCellStyle();
					HSSFCellStyle bodystyle = workbook.createCellStyle();
					// 设置标题样式
					style = ExcelStyle.setHeadStyle(workbook, style);
					// 设置表格样式
					bodystyle = ExcelStyle.setbodyStyle(workbook, bodystyle);
					
					
					Field filed[] = ts.getClass().getDeclaredFields();
					// 标题
					List<String> exportfieldtile = new ArrayList<String>();
					// 导出的字段的get方法
					List<Method> methodObj = new ArrayList<Method>();
					// 遍历整个filed
					for (int i = 0; i < filed.length; i++) {
						Field f = filed[i];
						// 如果设置了annottion
						if (f.isAnnotationPresent(ExcelColumn.class)) {
							ExcelColumn exa = f.getAnnotation(ExcelColumn.class);
							String exprot = exa.name();
							// 添加到标题
							exportfieldtile.add(exprot);
							// 添加到需要导出的字段的方法
							String fieldname = f.getName();
							String getMethodName = "get"
									+ fieldname.substring(0, 1).toUpperCase()
									+ fieldname.substring(1);

							Method getMethod = tCls.getMethod(getMethodName,
									new Class[] {});


							methodObj.add(getMethod);
						}
					}
					// 产生表格标题行
					HSSFRow row = sheet.createRow(0);
					for (int i = 0; i < exportfieldtile.size(); i++) {
						HSSFCell cell = row.createCell(i);
						cell.setCellStyle(style);
						HSSFRichTextString text = new HSSFRichTextString(
								exportfieldtile.get(i));
						cell.setCellValue(text);
					}

				}else{
				
				
				// 首先检查数据看是否是正确的
				Iterator<T> its = list.get(ww).iterator();
				if (list.get(ww) == null || !its.hasNext() || title.get(ww) == null
						|| out == null) {
					throw new Exception("传入的数据不对！");
				}
				// 取得实际泛型类
				T ts = (T) its.next();
				Class tCls = ts.getClass();
			// 生成一个表格
			HSSFSheet sheet = workbook.createSheet(title.get(ww));
			// 设置表格默认列宽度为15个字节
			sheet.setDefaultColumnWidth(15);
			// 标题样式
			HSSFCellStyle style = workbook.createCellStyle();
			HSSFCellStyle bodystyle = workbook.createCellStyle();
			// 设置标题样式
			style = ExcelStyle.setHeadStyle(workbook, style);
			// 设置表格样式
			bodystyle = ExcelStyle.setbodyStyle(workbook, bodystyle);

			// 得到所有字段

			Field filed[] = ts.getClass().getDeclaredFields();
			// 标题
			List<String> exportfieldtile = new ArrayList<String>();
			// 导出的字段的get方法
			List<Method> methodObj = new ArrayList<Method>();
			// 遍历整个filed
			for (int i = 0; i < filed.length; i++) {
				Field f = filed[i];
				// 如果设置了annottion
				if (f.isAnnotationPresent(ExcelColumn.class)) {
					ExcelColumn exa = f.getAnnotation(ExcelColumn.class);
					String exprot = exa.name();
					// 添加到标题
					exportfieldtile.add(exprot);
					// 添加到需要导出的字段的方法
					String fieldname = f.getName();
					String getMethodName = "get"
							+ fieldname.substring(0, 1).toUpperCase()
							+ fieldname.substring(1);

					Method getMethod = tCls.getMethod(getMethodName,
							new Class[] {});


					methodObj.add(getMethod);
				}
			}
			// 产生表格标题行
			HSSFRow row = sheet.createRow(0);
			for (int i = 0; i < exportfieldtile.size(); i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style);
				HSSFRichTextString text = new HSSFRichTextString(
						exportfieldtile.get(i));
				cell.setCellValue(text);
			}

			int index = 0;

			// 循环整个集合

			// 第一行
			index++;
			row = sheet.createRow(index);
			for (int k = 0; k < methodObj.size(); k++) {
				HSSFCell cell = row.createCell(k);
				cell.setCellStyle(bodystyle);
				Method getMethod = methodObj.get(k);
				Object value = getMethod.invoke(ts, new Object[] {});
				String textValue = getValue(value);
				cell.setCellValue(textValue);
			}

			while (its.hasNext()) {
				// 从第二行开始写，第一行是标题
				index++;
				row = sheet.createRow(index);
				T t = (T) its.next();
				for (int k = 0; k < methodObj.size(); k++) {
					HSSFCell cell = row.createCell(k);
					cell.setCellStyle(bodystyle);
					Method getMethod = methodObj.get(k);
					Object value = getMethod.invoke(t, new Object[] {});
					String textValue = getValue(value);
					cell.setCellValue(textValue);
				}

			}
			for (int i = 0; i < exportfieldtile.size(); i++) {
				sheet.autoSizeColumn(i);
			}
			}
			}
			workbook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
