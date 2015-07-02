package com.duxiu.modules.velocity.tools;

import javax.servlet.http.HttpServletRequest;

import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.generic.SafeConfig;

import com.duxiu.modules.utils.CookieUtils;
import com.duxiu.modules.utils.StringUtils;
import com.duxiu.sslibrary.utils.BookCoverURLUtils;
import com.duxiu.sslibrary.utils.BookCoverURLUtils.BookCoverSize;

@DefaultKey("sslib")
public class SSLibTool extends SafeConfig {
	
	/**
	 * 获取小封面图片
	 * 
	 * @param ssid
	 * @return
	 */
	public String bookSmallCover(String ssid) {
		return BookCoverURLUtils.bookCoverURL(ssid, BookCoverSize.small);
	}
	
	/**
	 * 获取中等封面图片
	 * 
	 * @param ssid
	 * @return
	 */
	public String bookMiddleCover(String ssid) {
		return BookCoverURLUtils.bookCoverURL(ssid, BookCoverSize.middle);
	}
	
	/**
	 * 获取大封面图片
	 * 
	 * @param ssid
	 * @return
	 */
	public String bookLargeCover(String ssid) {
		return BookCoverURLUtils.bookCoverURL(ssid, BookCoverSize.larg);
	}
	
	/**
	 * 字符串超过长度的用...代替，一个汉字代表两个字符
	 * 
	 * @param str
	 * @param maxLen
	 * @return
	 */
	public String abbreviateZhcn(String str, int maxLen) {
		return StringUtils.abbreviateZhcn(str, maxLen);
	}
	
	/**
	 * 格式化主题词（去掉括号）
	 * 
	 * @param keyword
	 * @return
	 */
	public String formatkw(String keyword) {
		return keyword.replace("(", " ").replace(")", " ");
	}
	
	/**
	 * 获取 cookie value
	 * 
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public String getcookie(HttpServletRequest request, String name) {
		return StringUtils.defaultString(CookieUtils.getString(request, name), "");
	}
	
}
