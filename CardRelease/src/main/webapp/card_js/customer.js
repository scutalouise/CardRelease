$("#readCardNo").click(function(){
    if (rd.dc_init(100, 115200) < 0) {
        alert("打开读卡器失败：初始化失败，请检查是否已经打开过了！");
        rd.dc_exit();
        return;
    }
    if (rd.dc_beep(5) != 0) {
        alert("打开读卡器失败：蜂鸣不成功！");
        rd.dc_exit();
        return;
    };
    var mac;
    //没多大用
    if (rd.dc_card(0, mac) != 0)//寻卡、返回值小于0表示失败
    {
        alert("dc_card 寻卡失败!请先打开读卡器");
        rd.dc_exit();
        return;
    }
    mac = rd.get_bstrRBuffer_asc;
    //发送ajax与从服务器获取密钥；
    $.get(getProjectName() + "/cardRelease/getKey/" + mac, function(data, status) {
        rd.put_bstrSBuffer_asc = data["keyA5"];
        if (rd.dc_load_key(0, 5) != 0)//载入对应扇区密钥，读取相关信息；;返回值小于0表示失败
        {
            alert("dc_load_key载入初始化密钥时出错！请确认此卡是否为本系统已经发布的卡？");
            rd.dc_exit();
            return;
        }
        if (rd.dc_authentication(0, 5) != 0)//核对密码函数、第一个参数为密码验证模式、第二个参数为扇区号;返回值小于0表示失败,卡号
        {
            alert("扇区核对密码时出错！");
            rd.dc_exit();
            return;
        }
        if (rd.dc_read(21) != 0) {
            alert("dc_read读区块错误");
            rd.dc_exit();
            return;
        }
        var cardno = rd.get_bstrRBuffer_asc;
        //读取的数据放在这个地址；注意区别：put_bstrSBuffer_asc
        cardno = cardno.substring(26);
        //取的是正常的数据，非16进制数据；
        $("#vipCardNo").val(cardno);
        //关闭端口
        rd.dc_exit();
    });
    
});

var isBankCardNoReady ;
var isVipCardNoReady ;
var isBankCardTypeIdReady ;
var isCustomerNameReady ;
var isCustomerTelReady ;
var isInvalidReady ;
var isOriginalPtReady;
var isHairpinDotReady;

$(document).ready(function(){
	if($("#originalPt").length == 0){//代表修改
		isBankCardNoReady = true;
		isVipCardNoReady = true;
		isBankCardTypeIdReady = true;
		isCustomerNameReady = true;
		isCustomerTelReady = true;
		isInvalidReady = true;
		isHairpinDotReady = true;
	}else{//代表新增
		isBankCardNoReady = false;
		isVipCardNoReady = false;
		isBankCardTypeIdReady = false;
		isCustomerNameReady = false;
		isCustomerTelReady = false;
		isInvalidReady = false;
		isOriginalPtReady = false;
		isHairpinDotReady = false;
	}
});

$("#hairpinDotDIV select").change(function(){
	if(!isFirstOptionSelected($("#hairpinDotDIV select"))){
		$("#hairpinDotDIV").attr("class", "control-group success");isHairpinDotReady = true;
	}else{
		$("#hairpinDotDIV").attr("class", "control-group error");isHairpinDotReady = false;
	}
});

$("#bankCardTypeIdDIV select").change(function(){
    if(!isFirstOptionSelected($("#bankCardTypeIdDIV select"))){
        $("#bankCardTypeIdDIV").attr("class", "control-group success");isBankCardTypeIdReady = true;
    }else{
        $("#bankCardTypeIdDIV").attr("class", "control-group error");isBankCardTypeIdReady = false;
    }
});

$("#customerName").blur(function(){
	var customerName = $("#customerName").val();
	if(!isNull(customerName) && stringFixedLength(customerName,1,20)){
		$("#customerNameDIV").attr("class", "control-group success");isCustomerNameReady = true;
	}else{
		$("#customerNameDIV").attr("class", "control-group error");isCustomerNameReady = false;
	}
});

$("#customerTel").blur(function(){
	var customerTel = $("#customerTel").val();
	if(!isNull(customerTel) && stringFixedLength(customerTel,8,15)){
		$("#customerTelDIV").attr("class", "control-group success");isCustomerTelReady = true;
	}else{
		$("#customerTelDIV").attr("class", "control-group error");isCustomerTelReady = false;
	}
});
$("#originalPt").blur(function(){
	var originalPt = $("#originalPt").val();
	if(!isNull(originalPt) && intFixedLength(originalPt,1,4)){
		$("#originalPtDIV").attr("class", "control-group success");isOriginalPtReady = true;
	}else{
		$("#originalPtDIV").attr("class", "control-group error");isOriginalPtReady = false;
	}
});

$("#invalid").blur(function(){
	var invalid = $("#invalid").val();
	if(!isNull(invalid)){
		$("#invalidDIV").attr("class", "control-group success");isInvalidReady = true;
	}else{
		$("#invalidDIV").attr("class", "control-group error");isInvalidReady = false;
	}
});

/*
 * 新增或更新客户信息时,写卡信息:新增与更新不同,新增会写卡的原始点数,而更新只修改联系方式
 */
$(".form-actions button").click(function(){
	// if(!isNull($("#vipCardNo").val())){
		// isVipCardNoReady = true;
	// }else{
		// isVipCardNoReady = false;
	// }
	if($("#originalPt").length == 0){//代表 提交的是修改
		if(isBankCardNoReady && isVipCardNoReady && isBankCardTypeIdReady && isCustomerNameReady && isCustomerTelReady && isInvalidReady && isHairpinDotReady){
			goToSubmit();
		}else{
			return false;
		}
	}else{//代表 提交的是新增
		if(isOriginalPtReady && isBankCardNoReady && isVipCardNoReady && isBankCardTypeIdReady && isCustomerNameReady && isCustomerTelReady && isInvalidReady && isHairpinDotReady){
			goToSubmit();
		}else{
			return false;
		}
	}
});

function goToSubmit(){
		//写卡操作
    if (rd.dc_init(100, 115200) < 0) {
        alert("打开读卡器失败：初始化，请检查是否已经打开过了！");
        rd.dc_exit();
        return;
    }
    if (rd.dc_beep(10) != 0) {
        alert("打开读卡器失败：蜂鸣不成功！");
        rd.dc_exit();
        return;
    };
    var mac;
    if (rd.dc_card(0, mac) != 0)//寻卡、返回值小于0表示失败
    {
        alert("寻卡失败，请检查是否已经打开过了！");
        rd.dc_exit();
        return;
    }
   mac = rd.get_bstrRBuffer_asc;
    $.get(getProjectName() + "/cardRelease/getKey/" + mac, function(data, status) {
		rd.put_bstrSBuffer_asc = data["keyA5"];
		if (rd.dc_load_key(0, 5) != 0)//返回值小于0表示失败
        {
            alert("载入初始化密钥时出错！");
            rd.dc_exit();
            return;
        }
        if (rd.dc_authentication(0, 5) != 0)//核对密码函数、第一个参数为密码验证模式、第二个参数为扇区号返回值小于0表示失败
        {
            alert("扇区核对密码时出错！");
            rd.dc_exit();
            return;
        }
        //写入"失效日期"+"联系方式"
        var date = $("#invalid").val().replace("-","").replace("-","");
		rd.put_bstrSBuffer_asc = date + $("#customerTel").val();//要写入卡的数据，放到这里:8+11位
        if (rd.dc_write(20) != 0)//向对应每个扇区写数据；并且将联系方式写到扇区5 块0；;返回值小于0表示失败
        {
            alert("dc_write 写卡错误!写的扇区为" + i);
            rd.dc_exit();
            return;
        }
        //判断，是否要写入次数(此处为原始的发卡点数)
        if($("#originalPt").val() != null && $("#originalPt").val() > 1 ){
	        rd.put_bstrSBuffer_asc = $("#originalPt").val();//要写入卡的数据，放到这里
	        if (rd.dc_write(22) != 0)//向对应每个扇区写数据；并且将联系方式写到扇区5 块0；;返回值小于0表示失败
	        {
	            alert("dc_write 写卡错误!写的扇区为" + i);
	            rd.dc_exit();
	            return;
	        }
        }
        //关闭端口
    	rd.dc_exit();
		//想服务器提交数据，记录客户信息到数据库
		$("#customerFrom").submit();
	});
}


/**
 * 新增时,判断银行卡后，是否已经在数据库中存在的ajax调用 
 */
$("#bankCardNoDIV input").focusout(function(){
	/* alert($("#bankCardNoDIV input").val()); */
	var bankCardNo = $("#bankCardNo").val();
	if(isMatchPattern(bankCardNo,"^\\d+$") &&　bankCardNo.length >= 15){
		$.ajax({
	        url:getProjectName() + "/customer/isBankCardNoExist" ,
	        data:{bankCardNo:$("#bankCardNoDIV input").val()},
	        type:"POST",
	        success:(function(data,status) {
	        			if(data["result"] == "success"){
	        				$(".form-actions button").hide();
	        				$("#bankCardNoDIV").attr("class","control-group error");
	        				$("#bankCardNoDIV div span").text(data["info"]);
	        				isBankCardNoReady = false;
	        			}else if(data["result"] == "failed"){
	        				$(".form-actions button").show();
	        				$("#bankCardNoDIV").attr("class","control-group success");
	        				$("#bankCardNoDIV div span").text(data["info"]);
	        				isBankCardNoReady = true;
	        			}
	                })
	    });	
	}else{
		$("#bankCardNoDIV").attr("class", "control-group error");isBankCardNoReady = false;
	}
});

/**
 * 新增时,判断卡号，是否已经在数据库中存在的ajax调用 
 */
$("#vipCardNo").focusout(function(){
	var vipCardNo = $("#vipCardNo").val();
	if(!isNull(vipCardNo) && intFixedLength(vipCardNo,6,6)){
		$.ajax({
	        url:getProjectName() + "/customer/isVipCardNoExist" ,
	        data:{cardNo:$("#vipCardNo").val()},
	        type:"POST",
	        success:(function(data,status) {
	        			if(data["result"] == "success"){
	        				$(".form-actions button").hide();
	        				$("#vipCardNoDIV").attr("class","control-group error");
	        				$("#vipCardNoDIV div span").text(data["info"]);
	        				isVipCardNoReady = false;
	        			}else if(data["result"] == "failed"){
	        				$(".form-actions button").show();
	        				$("#vipCardNoDIV").attr("class","control-group success");
	        				$("#vipCardNoDIV div span").text(data["info"]);
	        				isVipCardNoReady = true;
	        			}
	                })
	    });	
	}else{
		$("#vipCardNoDIV").attr("class", "control-group error");isVipCardNoReady = false;
	}
});

