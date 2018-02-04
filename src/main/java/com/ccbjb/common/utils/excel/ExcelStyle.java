package com.ccbjb.common.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class ExcelStyle {
	public static HSSFCellStyle setHeadStyle(HSSFWorkbook workbook,
			HSSFCellStyle style) {

		/*
		 * style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		 * style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		 */
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);

		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成字体
		HSSFFont font = workbook.createFont();
		// font.setColor(HSSFColor.VIOLET.index);
		font.setColor(HSSFColor.BLACK.index);
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样样式
		style.setFont(font);
		return style;

	}

	public static HSSFCellStyle setbodyStyle(HSSFWorkbook workbook,
			HSSFCellStyle style) {
		/*
		 * style.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		 * style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		 */
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_GENERAL);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成字体
		HSSFFont font = workbook.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样样式
		style.setFont(font);

		// 单元格样式
		HSSFDataFormat format = workbook.createDataFormat();
		style.setDataFormat(format.getFormat("@"));

		return style;
	}
}
