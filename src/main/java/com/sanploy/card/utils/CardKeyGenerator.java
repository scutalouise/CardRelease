package com.sanploy.card.utils;

import java.util.HashMap;
import java.util.Map;


/**
 * @Description:卡加密算法、密钥生成器
 * 生成步骤见《M1卡规范及秘钥设定方式.docx》
 * @author:scuta
 * @since:2015年6月29日
 * @version:default 0.0.0.1
 */
public class CardKeyGenerator {
	
	private static final String DICTIONARY = "850429528E6BE1621BD0697CD9AD8C31BC10439DE99549CE9EA30A6212BD32066438C06DBCC75C92E49C9255ACE7E6BECB614E960C5208E059B7145E78";
	
	/**
	 * @Description:根据卡的物理地址返回经过加密的每一个区的密钥keyA以及keyB，
	 * @param macAddress	8位16进制物理地址
	 * @return				Map(String,String)类型，其中key格式分别为：keyA数字，keyBn
	 * @since:2015年6月30日 下午1:25:37
	 */
	public static Map<String,String> getKey(String macAddress){
		//要返回的参数
		Map<String,String> map = new HashMap<String,String>();
		map.putAll(CardKeyGenerator.getKeyA(macAddress));
		map.putAll(CardKeyGenerator.getKeyB(macAddress));		
		return map;
	}
	
	/**
	 * @Description:		获取keyA密钥
	 * 首先判断下是否为空；收到的卡片物理地址为8位16进制字符串，先进行转换；
	 * 取得先前操作中获取的16位10进制的字符串decimalMacAddress,并截取最后9位，再取绝对值；进行倒序；
	 * 先计算每个扇区的KeyA后6位密钥
	 * 再计算每个扇区KeyA密钥前6位的计算
	 * @param macAddress	卡物理地址8位16进制地址格式
	 * @return				Map对象，经过加密计算后得到的所有区块及对应keyA
	 * @since:2015年6月30日 上午11:25:09
	 */
	public static Map<String,String> getKeyA(String macAddress){
		
		Map<String,String> map = new HashMap<String,String>();						//函数返回对象
		
		char[] dictArray = CardKeyGenerator.DICTIONARY.toCharArray();				//字典数组
		
		int[] sectorsOrder = new int[16];											//扇区取值6位，每个扇区第一位在字典数组中的序号
		
		String[] sectorKeylast6CharArray = new String[16];							//每个扇区对应的密钥
		
		String decimalMacAddress = HexConverter.HexToDecimal(macAddress);
		
		String last9Character = decimalMacAddress.substring(decimalMacAddress.length()-9);
		
		last9Character = String.valueOf(Math.abs(Integer.parseInt(last9Character)));
//last9Character = "238375218";
		String reverseLast9Character = StringUtils.reverseString(last9Character);
		char[] charArray = reverseLast9Character.toCharArray();
		
		for(int i=0; i<sectorsOrder.length; i++){
			sectorsOrder[i] = Integer.parseInt(String.valueOf(charArray[0])) * 10 + Integer.parseInt(String.valueOf(charArray[1])) +i ;
		}
		
		for(int i=0; i<sectorsOrder.length; i++){									//对每个扇区后6位密钥的计算，在字典中取由对应扇区的对应起始序号为sectorsOrder，截取6位；
			String keyAlast6Char = "";
			for(int j=0; j<6; j++){
				keyAlast6Char += dictArray[sectorsOrder[i]+j];						//封装扇区在字典中对应的6位密钥（作为密钥的后6位）
			}
			sectorKeylast6CharArray[i]  = keyAlast6Char;
		}
		
		//根据计算方式，计算与KeyA前6位进行异或的2个对象中其中一个对象的值，6位字符串，由数据字典中读取
		int front6CharXorStringOrder = Integer.parseInt(String.valueOf(charArray[1])) * 10 + Integer.parseInt(String.valueOf(charArray[2])); 
		String front6CharXorString = "";
		for(int i=0; i<6; i++){
			front6CharXorString += dictArray[front6CharXorStringOrder + i];
		}
		
		//KeyA前6位进行异或的2个对象中其中另一个对象的值，6位字符串，由卡物理地址转换成的10进制地址某部分截取；
		String front3To8Char = last9Character.substring(2, 8);
		String front6String = HexConverter.ToStr1XORStr2(front6CharXorString, front3To8Char);
		for(int i=0; i<sectorKeylast6CharArray.length; i++){
			map.put("keyA"+i, front6String + sectorKeylast6CharArray[i]);
		}
		return map;
	}
	
	/**
	 * @Description:		获取keyB密钥
	 * 首先判断下是否为空；收到的卡片物理地址为8位16进制字符串，先进行转换；
	 * 取得先前操作中获取的16位10进制的字符串decimalMacAddress,并截取最后9位，再取绝对值；进行倒序；
	 * 先计算每个扇区的KeyA后6位密钥
	 * 再计算每个扇区KeyA密钥前6位的计算
	 * @param macAddress	卡物理地址8位16进制地址格式
	 * @return				Map对象，经过加密计算后得到的所有区块及对应keyB
	 * @since:2015年6月30日 上午11:25:09
	 */
	public static Map<String,String> getKeyB(String macAddress){
		
		char[] dictArray = CardKeyGenerator.DICTIONARY.toCharArray();				//计算在词典中的取值；词典数组
		
		int[] sectorsOrder = new int[16];											//扇区取值6位，每个扇区第一位在字典数组中的序号

		String[] sectorKeylast6CharArray = new String[16];							//每个扇区对应的密钥

		Map<String,String> map = new HashMap<String,String>();						//函数返回对象
		
		String decimalMacAddress = HexConverter.HexToDecimal(macAddress);
		
		String last9Character = decimalMacAddress.substring(decimalMacAddress.length()-9);
		
		last9Character = String.valueOf(Math.abs(Integer.parseInt(last9Character)));
//last9Character = "238375218";//测试
		String reverseLast9Character = StringUtils.reverseString(last9Character);
		 
		//先计算每个扇区的KeyB后6位密钥
		char[] charArray = reverseLast9Character.toCharArray();						//取得各个扇区的密钥；
		for(int i=0; i<sectorsOrder.length; i++){
			sectorsOrder[i] = Integer.parseInt(String.valueOf(charArray[1])) * 10 + Integer.parseInt(String.valueOf(charArray[2])) +i ;
		}
		
		//对每个扇区后6位密钥的计算，在字典中取由对应扇区的对应起始序号为sectorsOrder，截取6位；
		for(int i=0; i<sectorsOrder.length; i++){
			String keyBlast6Char = "";
			for(int j=0; j<6; j++){
				keyBlast6Char +=  dictArray[sectorsOrder[i]+j];						//封装扇区在字典中对应的6位密钥（作为密钥的后6位）
			}
			sectorKeylast6CharArray[i]  = keyBlast6Char;
		}
		
		//每个扇区KeyB密钥前6位的计算
		//根据计算方式，计算与KeyB前6位进行异或的2个对象中其中一个对象的值，6位字符串，由数据字典中读取
		int front6CharXorStringOrder = Integer.parseInt(String.valueOf(charArray[2])) * 10 + Integer.parseInt(String.valueOf(charArray[3])); 
		String front6CharXorString = "";
		for(int i=0; i<6; i++){
			front6CharXorString += dictArray[front6CharXorStringOrder + i];
		}
		
		//KeyB前6位进行异或的2个对象中其中另一个对象的值，6位字符串，由卡物理地址转换成的10进制地址某部分截取；
		String front3To8Char = last9Character.substring(2, 8);
		String front6String = HexConverter.ToStr1XORStr2(front3To8Char, front6CharXorString);
		for(int i=0; i<sectorKeylast6CharArray.length; i++){
			map.put("keyB"+i, front6String + sectorKeylast6CharArray[i]);
		}
		return map;
	}
	
//-----------------------------------------------------------------------------------------------	
	public static void main(String[] args) {
		
		String str = "238375218";
		/**
		 * 9763D754-----54D76397
		 * C781D554-----54D581C7
		 * 2744D754-----54D74427
		 * 2756D254-----54D25627
		 * 54D759B7
		 * 下面为加密词典的全文,以8位为一分组便于筛查；
		 * 85042952		
		 * 8E6BE162
		 * 1BD0697C
		 * D9AD8C31
		 * BC10439D
		 * E99549CE
		 * 9EA30A62
		 * 12BD3206
		 * 6438C06D
		 * BCC75C92
		 * E49C9255			4为第81位,从0开始计数
		 * ACE7E6BE
		 * CB614E96
		 * 0C5208E0
		 * 59B7145E
		 * 78
		 */
		String decimal = HexConverter.HexToDecimal(str);
		System.out.println(str + " 十进制数为:"+decimal);
		System.out.println(decimal.substring(decimal.length()-9));;
		System.out.println(decimal.substring(2, 8));
		
		//简单的测试；
//		Map<String, String > mapA = CardKeyGenerator.getKeyA(str);
//		Map<String, String > mapB = CardKeyGenerator.getKeyB(str);
//		for(String key : mapA.keySet()){
//			System.out.println(key + "---value:" + mapA.get(key));
//		}
//		for(String key : mapB.keySet()){
//			System.out.println(key + "---value:" + mapB.get(key));
//		}
		
//		HexConverter.DecimalToHex(238375218);
		
		Map<String, String> map = CardKeyGenerator.getKey("30803");
		for(String key : map.keySet()){
			System.out.println(key + "---" + map.get(key));
		}
	}
}
