package com.ccbjb.common.utils.excel;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelColumn {

	/*
	 * 列名
	 */
	String name() default ""; 
	
	/*
	 * 格式
	 */
	String format() default "yyyy-MM-dd"; 

}
