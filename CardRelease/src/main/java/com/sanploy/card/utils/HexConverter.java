package com.sanploy.card.utils;

import java.io.ByteArrayOutputStream;

/**
 * @Description:
 * @author:scuta
 * @since:2015年6月29日
 * @version:default 0.0.0.1
 */
public class HexConverter {
	/*
	 * 16进制数字字符集
	 */
	private static String hexString = "0123456789ABCDEF";

	/**
	 * 两个十六进制字符串进行异或
	 * @param str1
	 * @param str2
	 * @return 十六进制的异或结果
	 */
	public static String ToStr1XORStr2(String str1, String str2) {
		int[] temp1 = new int[str1.length()];
		int[] temp2 = new int[str2.length()];
		char[] temp3 = str1.toCharArray();
		char[] temp4 = str2.toCharArray();
		int[] temp5 = new int[str2.length()];
		String str = "";
		for (int i = 0; i < (str1.length() + str2.length()) / 2; i++) {
			temp1[i] = Integer.parseInt(HexToDecimal(temp3[i]));
			temp2[i] = Integer.parseInt(HexToDecimal(temp4[i]));
			temp5[i] = temp1[i] ^ temp2[i];
			str += DecimalToHex(temp5[i]);
		}
		return str;
	}

	/**
	 * @Description:16进制字符串转10
	 * @param str	16进制字符串
	 * @return		10进制字符串
	 * @since:2015年6月29日 下午4:01:44
	 */
	public static String HexToDecimal(String str) {
		return HexToDecimal(str.toCharArray());
	}

	/**
	 * @Description:16进制字符数组转10进制字符串
	 * @param ch	16进制字符数组
	 * @return		10进制字符串
	 * @since:2015年6月29日 下午4:11:25
	 */
	public static String HexToDecimal(char[] ch) {
		String str = "";
		for (int i = 0; i < ch.length; i++) {
			str += HexToDecimal(ch[i]);
		}
		return str;
	}

	/**
	 * @Description:16进制字符转10进制字符串
	 * @param ch	16进制字符
	 * @return		10资质字符串
	 * @since:2015年6月29日 下午4:13:02
	 */
	public static String HexToDecimal(char ch) {
		String str = "";
		switch (ch) {
		case 'a':
		case 'A':
			str = "10";
			break;
		case 'b':
		case 'B':
			str = "11";
			break;
		case 'c':
		case 'C':
			str = "12";
			break;
		case 'd':
		case 'D':
			str = "13";
			break;
		case 'e':
		case 'E':
			str = "14";
			break;
		case 'f':
		case 'F':
			str = "15";
			break;
		default:
			str = subString(String.valueOf(ch));
		}
		return str;
	}

	/**
	 * @Description:格式化字符串为 00格式,主要处理0-9这10个数字，转化为00格式的；
	 * @param str	字符串
	 * @return		字符串
	 * @since:2015年6月29日 下午4:34:34
	 */
	private static String subString(String str) {
		if (str.length() == 1)
			str = "0" + str;
		return str;
	}
	
	/**
	 * @Description:10进制整型转16进制字符串
	 * @param Num	10进制整型
	 * @return		16进制字符串
	 * @since:2015年6月29日 下午4:13:49
	 */
	public static String DecimalToHex(int Num) {
		char digits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		int length = 32;
		String hexString = "";
		char[] result = new char[length];
		do {
			result[--length] = digits[Num & 15];
			Num >>>= 4;
		} while (Num != 0);
		for (int i = length; i < result.length; i++) {
			hexString += result[i];
		}
		return hexString;
	}

	/**
	 * @Description:将字符串编码成16进制数字,适用于所有字符（包括中文）
	 * @param string	字符串
	 * @return		16进制字符串
	 * @since:2015年6月29日 下午4:28:52
	 */
	public static String encode(String string) {
		// 根据默认编码获取字节数组
		byte[] bytes = string.getBytes();
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		// 将字节数组中每个字节拆解成2位16进制整数
		for (int i = 0; i < bytes.length; i++) {
			sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
			sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
		}
		return sb.toString();
	}

	/**
	 * @Description:将16进制数字解码成字符串,适用于所有字符（包括中文）
	 * @param string	16进制字符串
	 * @return		解码后的字符串
	 * @since:2015年6月29日 下午4:29:36
	 */
	public static String decode(String string) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream(string.length() / 2);
		// 将每2位16进制整数组装成一个字节
		for (int i = 0; i < string.length(); i += 2)
			baos.write((hexString.indexOf(string.charAt(i)) << 4 | hexString.indexOf(string.charAt(i + 1))));
		return new String(baos.toByteArray());
	}
	
	/**
	 * @deprecated
	 * @Description:字节数组转bcd编码
	 * @param bytes	字节数组
	 * @return		bcd字符串
	 * @since:2015年6月29日 下午4:18:19
	 */
	public static String bcd2Str(byte[] bytes) {
		char temp[] = new char[bytes.length * 2], val;
		for (int i = 0; i < bytes.length; i++) {
			val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f);
			temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
			val = (char) (bytes[i] & 0x0f);
			temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
		}
		return new String(temp);
	}

	// ----------------------简单测试--------------------------
	public static void main(String[] args) {
		System.out.println(encode("11"));
		System.out.println(decode(encode("11")));
	}
	// ----------------------简单测试--------------------------
}
