package com.ccbjb.common.utils.excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 向Excel写数据的抽象类。
  
 * @since 2013.1.25
 * @version 1.0
 * @see PoiExcelWriter
 * @see Poi2003ExcelWriter
 *
 */
public abstract class ExcelWriter {
	/**
	 * 要输出的Excel文件路径
	 */
	protected String excelFilePath;
	/**
	 * 要输出到Excel文件中的数据。List的每一条是一行，Object[]数组是一列
	 */
	protected List<Object[]> dataList;
	
	/**
	 * 构造方法
	 * @param dataList 输出到Excel文件中的数据。List的每一条是一行，Object[]数组是一列
	 * @param excelFilePath 要输出的Excel文件路径，不能为空，且路径有效并不能为文件夹.
	 */
	public ExcelWriter(List<Object[]> dataList, String excelFilePath) {
		if(excelFilePath == null) {
			throw new NullPointerException();
		}
		
		File file = new File(excelFilePath);
		if(!file.exists() || file.isDirectory()) {
			throw new NullPointerException();
		}
		
		this.dataList = (dataList == null ? new ArrayList<Object[]>() : dataList);
		this.excelFilePath = excelFilePath;
	}
	
	/**
	 * 向Excel文件中写入数据。
	 * @throws IOException
	 */
	public abstract void write() throws IOException;
}
