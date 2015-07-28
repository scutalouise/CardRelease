<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String basePath = "";
	String path = request.getContextPath(); 
	basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/card_js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/card_js/utils.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/card_js/releaseCard.js" defer="defer"></script>
<!-- 江汉使用的cab包：<Object id=rd codeBase="comRD800.cab#version=1,0,0,6" classid="clsid:638B238E-EB84-4933-B3C8-854B86140668"></Object> -->
<OBJECT id=rd codeBase=${pageContext.request.contextPath } /comRD800.dll classid="clsid:638B238E-EB84-4933-B3C8-854B86140668" style="display:none"></OBJECT>
<base href="<%=basePath%>">
</head>
<body>
	输入卡号：<input type="text" id="cardNo">
	<br>
	<br>
	当前操作：<input type="button" value="发卡" id="releaseCard">
	<span id="releaseCard_result"></span>
	<br>
	<br>
	<hr/>
	<input type="button" value="读卡" id="readCard">
	<span id="readCard_result"></span>
	<br>
	<br>
	<hr/>
	<input type="button" value="卡片还原" id="recovery">
	<span id="recovery_result"></span>
	<hr>
	
	<br>
	<h3>测试内容</h3>
	<input type="button" value="卡操作测试" id="read">
	<br>
	<br>
	<input type="button" value="获取加密后密钥" id="getKey">
	<br>
	<br>
	<form action="${pageContext.request.contextPath}/getKey/12345678" method="post">
		<input type="submit" value="测试发送json请求的地址是否正确">
	</form>

	<script type="text/javascript">
		//读写卡一套流程的测试
		function readCard() {
			//			alert("readCard be click");
			//			alert($("#cardno").val);
			///////////////////////////////////////////////////////////////////////////////
			//以下为非接触式读写器函数调用例子 for javascript
			//注意个别函数（例如dc_disp_str）只有当设备满足要求（例如有数码显示）时才有效
			//更详细的帮助可参照32位动态库对应的函数使用说明
			///////////////////////////////////////////////////////////////////////////////

			var st; //主要用于返回值
			var lSnr; //本用于取序列号，但在javascript只是当成dc_card函数的一个临时变量

			//初始化端口
			//第一个参数为0表示COM1，为1表示COM2，以此类推
			//第二个参数为通讯波特率
			st = rd.dc_init(100, 115200);
			if (st <= 0) //返回值小于等于0表示失败
			{
				alert("dc_init error!");
				return;
			}
			
			alert("33334444555566667777888899990000".substring(12, 20));
			alert("dc_init ok!");

			//蜂鸣
			//第一个参数为蜂鸣时间，单位是10毫秒
			st = rd.dc_beep(50);
			if (st != 0) //返回值小于0表示失败
			{
				alert("dc_beep error!");
				rd.dc_exit();
				return;
			}

			//寻卡，能返回在工作区域内某张卡的序列号
			//第一个参数一般设置为0，表示IDLE模式，一次只对一张卡操作
			//第二个参数在javascript只是当成dc_card函数的一个临时变量，仅在vbscript中调用后能正确返回序列号
			st = rd.dc_card(0, lSnr);
			if (st != 0) //返回值小于0表示失败
			{
				alert("dc_card error!");
				rd.dc_exit();
				return;
			}
			lSnr = rd.get_bstrRBuffer_asc;//物理地址，注意高低位
			alert("dc_card返回：" + st + " lSnr:" + lSnr);
			alert("dc_card ok!");
			alert("序列号为rd.get_bstrRBuffer，一般有不可显示字符出现:" + rd.get_bstrRBuffer); //序列号为rd.get_bstrRBuffer，一般有不可显示字符出现
			alert("序列号十六进制ascll码字符串表示为rd.get_bstrRBuffer_asc: " + rd.get_bstrRBuffer_asc); //序列号十六进制ascll码字符串表示为rd.get_bstrRBuffer_asc

			//将密码装入读写模块RAM中
			//第一个参数为装入密码模式
			//第二个参数为扇区号
			rd.put_bstrSBuffer_asc = "FFFFFFFFFFFF"; //在调用dc_load_key必须前先设置属性rd.put_bstrSBuffer或rd.put_bstrSBuffer_asc
						
			st = rd.dc_load_key(0, 0);
			if (st != 0) //返回值小于0表示失败
			{
				alert("dc_load_key error!");
				rd.dc_exit();
				return;
			}
			alert("dc_load_key ok!");

			//核对密码函数
			//第一个参数为密码验证模式
			//第二个参数为扇区号
			st = rd.dc_authentication(0, 1);
			if (st != 0) //返回值小于0表示失败
			{
				alert("dc_authentication error!");
				rd.dc_exit();
				return;
			}
			alert("dc_authentication ok!");

			//向卡中写入数据，一次必须写一个块
			//第一个参数为块地址
			//在调用dc_write必须前先设置属性rd.put_bstrSBuffer或rd.put_bstrSBuffer_asc
			rd.put_bstrSBuffer_asc = "123456";//默认是写在高位的;
			st = rd.dc_write(4);
			if (st != 0) //返回值小于0表示失败
			{
				alert("dc_write error!");
				rd.dc_exit();
				return;
			}
			alert("dc_write ok!");

			//读取卡中数据，一次必须读一个块
			//第一个参数为块地址
			//取出的数据放在属性放在rd.put_bstrSBuffer（正常表示）和rd.put_bstrSBuffer_asc（十六进制ascll码字符串表示）中
			//经测试发现是放到?????rd.get_bstrRBuffer_asc这个里面的！！！！！！！！
			st = rd.dc_read(4);
			if (st != 0) //返回值小于0表示失败
			{
				alert("dc_read error!");
				rd.dc_exit();
				return;
			}
			alert("dc_read ok!");
			alert(" : rd.get_bstrRBuffer:"+rd.get_bstrRBuffer);
			alert("  rd.get_bstrRBuffer_asc:"+rd.get_bstrRBuffer_asc);

			//设置读写器时间
			//04年 星期四 9月 9日 11点 20分 50秒
			rd.put_bstrSBuffer_asc = "04040909112050";
			st = rd.dc_settime();
			if (st != 0) //返回值小于0表示失败
			{
				alert("dc_settime error!");
				rd.dc_exit();
				return;
			}
			alert("dc_settime ok!");

			//在读写器的数码管上显示数字
			rd.put_bstrSBuffer = "12345678\0"; //显示12345678，注意字符串后必须附加一个ascll为0x00结束符号;
			st = rd.dc_disp_str();
			if (st != 0) //返回值小于0表示失败
			{
				alert("dc_disp_str error!");
				rd.dc_exit();
				return;
			}
			alert("dc_disp_str ok!");

			//蜂鸣
			//第一个参数为蜂鸣时间，单位是10毫秒
			st = rd.dc_beep(50);
			if (st != 0) //返回值小于0表示失败
			{
				alert("dc_beep error!");
				rd.dc_exit();
				return;
			}
			alert("dc_beep ok!");

			//关闭端口
			st = rd.dc_exit();
			if (st != 0) //返回值小于0表示失败
			{
				alert("dc_exit error!");
				return;
			}
			alert("dc_exit ok!");

		}
		$("#read").click(function() {
			alert($(this).val());
			readCard();
		});
		
		//----------------------------ajax中json数据的测试--------------------------
		$("#getKey").click(function() {
		    /**
		     * 初始化端口、蜂鸣提示、寻卡、
		     * 获取mac
		     * ajax请求加密后密钥
		     * web中提示，展现；
		     */
		    alert($(this).val());
		    // var mac;
		    // st = rd.dc_init(100, 115200);
		    // rd.dc_beep(50);
		    // rd.dc_card(0, mac);
		    // mac = rd.get_bstrRBuffer_asc;
		    $.get(getProjectName() + "/getKey/" + "54D759B7", function(data, status) {
		       alert("status:" + status);
		        $.each(data,function(key,value){
		            alert(key + ":" +value);
		        });
		        console.info(data);
		        alert("keyA0:" + data["keyA0"] + ";keyB0:" + data["keyB0"]);
		    });
		});
		
	</script>
</body>
</html>