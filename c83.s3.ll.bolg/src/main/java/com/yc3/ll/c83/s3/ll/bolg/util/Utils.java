package com.yc3.ll.c83.s3.ll.bolg.util;
import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

public class Utils {

	/**
	 * 	将所有的字段验证错写入到一个map
	 * @param errors
	 * @return
	 */
	public static Map<String, String> asMap(Errors errors) {
		if (errors.hasErrors()) {
			Map<String, String> ret = new HashMap<String, String>();
			for (FieldError fe : errors.getFieldErrors()) {
				ret.put(fe.getField(), fe.getDefaultMessage());
			}
			return ret;
		} else {
			return null;
		}
	}
}