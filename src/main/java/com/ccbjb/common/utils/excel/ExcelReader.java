package com.ccbjb.common.utils.excel;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 读取Excel文件并获得数据的抽象类。

 * @version 1.0
 * @since 2013.1.24
 *
 */
public abstract class ExcelReader {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	protected String filePath;
	/**
	 * 是否为老版本的Excel文件（97-03版本）。
	 */
	protected boolean isOldVersionExcel = false;
	/**
	 * 是否为CSV格式
	 */
	protected boolean isCsv = false;
	/**
	 * 是否读取Excel文件的所有sheet。默认值为否。
	 */
	protected boolean readAllSheets = false;
	/**
	 * 文件流转成byte数组保存。因为POI存在bug，fileStream只能用一次。
	 * <p>
	 * 所以先把fileStream转成byte数组，以后再用fileStream时，再从byte数组转成fileStream。
	 */
	protected byte[] fileStreamBytes = null;
	/**
	 * 从哪行开始获取数据，默认为第一行
	 */
	protected int startRowOfReading = 0;

	/**
	 * 构造方法
	 * @param excelFilePath Excel文件的绝对路径
	 * @throws QMException
	 */
	public ExcelReader(String excelFilePath) throws Exception {
		this.filePath = excelFilePath;
		checkFile(excelFilePath);
		try {
			fileStreamBytes = FileUtils.readFileToByteArray(new File(excelFilePath));
		} catch(IOException e) {
			logger.info(e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * 构造方法
	 * @param excelFile Excel文件的绝对路径
	 * @throws QMException
	 */
	public ExcelReader(byte[] excelFile) throws Exception {
		// checkFile(excelFile);
		fileStreamBytes = excelFile;
	}

	/**
	 * 检查文件是否有问题。
	 * @throws QMException
	 */
	private void checkFile(File file) throws Exception {

		// 文件不存在，或者路径是个文件夹
		if (!file.exists() || file.isDirectory()) {
			throw new FileNotFoundException();
		}

		// 文件不是Excel文件
		String fileName = file.getName();
		boolean isOldVersion = fileName.endsWith(".xls");
		boolean isNewVersion = fileName.endsWith(".xlsx");
		boolean isCsv = fileName.endsWith(".csv");
		if (!isOldVersion && !isNewVersion && !isCsv) {
			throw new Exception(getMessageBundle()
					.getString("excleFileError"));
		}

		isOldVersionExcel = isOldVersion;
	}

	/**
	 * 检查文件是否有问题。
	 * @throws QMException
	 */
	private void checkFile(String excelFilePath) throws Exception {
		File file = new File(excelFilePath);

		// 文件不存在，或者路径是个文件夹
		if (!file.exists() || file.isDirectory()) {
			throw new FileNotFoundException();
		}

		// 文件不是Excel文件
		String fileName = file.getName();
		boolean isOldVersion = fileName.endsWith(".xls");
		boolean isNewVersion = fileName.endsWith(".xlsx");
		boolean isCsv = fileName.endsWith(".csv");
		if (!isOldVersion && !isNewVersion && !isCsv) {
			throw new Exception(getMessageBundle()
					.getString("excleFileError"));
		}

		isOldVersionExcel = isOldVersion;
	}

	/**
	 * 获得文件路径错误消息
	 * @return 文件路径错误消息
	 */
	protected String getFilePathErrorMsg() {
		return getMessageBundle().getString("filePathError");
	}

	/**
	 * 获得属性文件的绑定
	 * @return 属性文件的绑定
	 */
	protected ResourceBundle getMessageBundle() {
		return ResourceBundle.getBundle("com.qm.jlllw.framework.util.file.excel.message");
	}

	/**
	 * 读取Excel文件的[第一Sheet页]/[所有sheet页]（根据readAllSheets属性）并获取其中的有效数据
	 * @return List<Object[]> List的每一条记录是一行结果，Object[]是一行中的所有列内容。
	 * 如果是所有sheet页，则把数据整合到了一起。
	 * @throws QMException
	 */
	public abstract List<String[]> read() throws Exception;

	/**
	 * 读取Excel文件的[第一Sheet页]/[所有sheet页]（根据readAllSheets属性）并获取其中的有效数据
	 * @return List<Object[]> List的每一条记录是一行结果，Object[]是一行中的所有列内容。
	 * 如果是所有sheet页，则把数据整合到了一起。
	 * @throws QMException
	 */
	public abstract Map<String, List<String[]>> readAllSheets() throws Exception;

	/**
	 * 读取Excel文件指定Sheet页并获取该Sheet页的有效数据
	 * @param sheetIndex Excel文件的Sheet页，从0开始
	 * @return List<Object[]> List的每一条记录是一行结果，Object[]是一行中的所有列内容
	 * @throws QMException
	 */
	public abstract List<String[]> read(int sheetIndex) throws Exception;

	/**
	 * 检查Excel第一个sheet页的 表头是否符合规范。（校验Excel文件模板是否正确）
	 * @param rowNumber 指定行，从0开始
	 * @param headerNames 表头内容
	 * @return <code>true</code>表示匹配成功，符合规范。否则为<code>false</code>
	 * @throws QMException
	 */
	public boolean checkHeader(int rowNumber, String[] headerNames)
			throws Exception {
		return checkHeader(0, rowNumber, headerNames);
	}

	/**
	 * 检查Excel指定sheet页的 表头是否符合规范。（校验Excel文件模板是否正确）
	 * @param sheetIndex 指定Sheet页，从0开始
	 * @param rowNumber 指定行，从0开始
	 * @param headerNames 表头内容
	 * @return <code>true</code>表示匹配成功，符合规范。否则为<code>false</code>
	 * @throws QMException
	 */
	public abstract boolean checkHeader(int sheetIndex, int rowNumber,
										String[] headerNames) throws Exception;

	/**
	 * 根据文件二进制数组转成文件流
	 * @return 文件流
	 */
	protected InputStream getFileStream() {
		return new ByteArrayInputStream(fileStreamBytes);
	}

	/**
	 * 处理整数变为double的情况。例如23从Excel里读出来却为23.0，这种情况下需要把小数点去掉
	 * @param number
	 * @return
	 */
	protected String handleIntHasPoint(double number) {
		return subZeroAndDot(String.valueOf(number));
		/*int intValue = new Double(number).intValue();
		return String.valueOf(number - intValue == 0 ? intValue : number);*/

		// 下面这段代码是另一种办法，利用了正则表达式。但是效率相对较低。
		// 保留这段代码，是为了以后参考。
		/*DecimalFormat decimalFormat = new DecimalFormat("#0");
		String resultStr = decimalFormat.format(number);
		if (resultStr.matches("^[-+]?\\d+\\.[0]+$")) {
			resultStr = resultStr.substring(0, resultStr.indexOf("."));
		} else if (resultStr.matches("^[-+]?\\d+\\.\\d+[0]+$")) {
			resultStr = Double.valueOf(resultStr).toString();
		}
		return resultStr;*/
	}

	public String subZeroAndDot(String s){
		if(s.indexOf(".") > 0){
			s = s.replaceAll("0+?$", "");//去掉多余的0
			s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
		}
		return s;
	}

	/**
	 * 是否读取所有sheet页
	 * @return
	 */
	public boolean isReadAllSheets() {
		return readAllSheets;
	}

	/**
	 * 设置是否读取所有sheet页
	 * @param readAllSheets <code>true</code>为读取所有sheet页，否则为<code>false</code>
	 */
	public void setReadAllSheets(boolean readAllSheets) {
		this.readAllSheets = readAllSheets;
	}

	/**
	 * 获取 读数据的起始行号
	 * @return 读数据的起始行号，默认为0，也就是第一行。
	 */
	public int getStartRowOfReading() {
		return startRowOfReading;
	}

	/**
	 * 设置 读数据的起始行号
	 * @param startRowOfReading 读数据的起始行号，从0开始。
	 */
	public void setStartRowOfReading(int startRowOfReading) {
		this.startRowOfReading = startRowOfReading;
	}
}
