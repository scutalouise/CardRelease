package com.sanploy.card.utils;


/**
 * @Description:字符串工具类集
 * @author:scuta
 * @since:2015年6月29日
 * @version:default 0.0.0.1
 */
public class StringUtils {

	/**
	 * @Description: 判断一个字符串是否为空
	 * @param string
	 *            字符串
	 * @return boolean
	 * @since:2015年6月29日 下午5:10:27
	 */
	public static boolean isNull(String string) {
		if ("".equals(string) || string.trim().length() == 0 || null == string) {
			return false;
		}
		return true;
	}

	/**
	 * @Description:对字符串进行倒序
	 * @param string字符串
	 * @return 倒序后的字符串
	 * @since:2015年6月29日 下午5:30:24
	 */
	public static String reverseString(String string) {
		String resultString = "";
		char[] charArray = string.toCharArray();
		for (int i = charArray.length - 1; i >= 0; i--) {
			resultString += charArray[i];
		}
		return resultString;
	}
	

	// ---------------------------------------------------------------------
	public static void main(String[] args) {
		String originalString = "abcdefg";
		System.out.println(StringUtils.reverseString(originalString));
	}

}
