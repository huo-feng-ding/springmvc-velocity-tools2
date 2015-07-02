package com.duxiu.modules.velocity.tools;

public class EscapeTool extends org.apache.velocity.tools.generic.EscapeTool {
	public static final String NOESC = "@NOESC@";
	
	/**
	 * 不进行转义
	 * 
	 * @param string
	 * @return
	 */
	public String noesc(Object string) {
		return string == null ? null : NOESC + String.valueOf(string);
	}
	
}
