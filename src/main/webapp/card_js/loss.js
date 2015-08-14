/**挂失卡处理开始***/
/**挂失时，使用ajax判断，卡号是否有初始化；是否曾发放给客户 */
var isLossCardNoReady = false;
$("#lossCardNo").focusout(function() {
    var url = getProjectName() + "/loss/isLossCardExist";
    var cardNo = $("#lossCardNo").val();
    //首先判断卡号格式是否正确；
    if (intFixedLength(cardNo, 6, 6)) {
        $.post(url, {
            cardNo : cardNo
        }, function(data) {
            if (data["result"] == "success") {//代表此卡号是存在的,并且未挂失正在使用
                $("#loss").show();
                $("#lossCardNoDIV").attr("class", "control-group success");
                $("#lossCardNoDIV div span").text("卡号正常使用中,可以挂失");
                isLossCardNoReady = true;
            } else {
                $("#loss").hide();
                $("#lossCardNoDIV").attr("class", "control-group error");
                isLossCardNoReady = false;
                if(data["result"] == "notInitial")  $("#lossCardNoDIV div span").text("此卡未初始化,不能识别.....");               
                if(data["result"] == "failed")  $("#lossCardNoDIV div span").text("此卡为新卡,未发给任何客户.....");  
                if(data["result"] == "loss")  $("#lossCardNoDIV div span").text("此卡已经挂失.");  
                if(data["result"] == "reReleased")  $("#lossCardNoDIV div span").text("此卡曾挂失,且已经补卡..."); 
            }
            
        });
    } else {
        $("#lossCardNoDIV").attr("class", "control-group error");
        $("#lossCardNoDIV div span").text("");
        isLossCardNoReady = false;
    }
});

$("#lossReadCardNo").click(function() {
    $.ajax({
        url : getProjectName() + "/loss/isLossCardExist",
        data : {
            mac : readMac()
        },
        type : "POST",
        success : (function(data, status) {
            if (data["result"] == "success") {//卡号存在，并且未挂失正在使用
                $("#loss").show();
                $("#lossCardNoDIV").attr("class", "control-group success");
                if(data["result"] == "notInitial")  $("#lossCardNoDIV div span").text("卡号正常使用中,可以挂失"); 
                isLossCardNoReady = true;
            } else {
                $("#loss").hide();
                $("#lossCardNoDIV").attr("class", "control-group error");
                isLossCardNoReady = false;
                if(data["result"] == "notInitial")  $("#lossCardNoDIV div span").text("此卡未初始化,不能识别.....");               
                if(data["result"] == "failed")  $("#lossCardNoDIV div span").text("此卡为新卡,未发给任何客户.....");  
                if(data["result"] == "loss")  $("#lossCardNoDIV div span").text("此卡已经挂失."); 
                if(data["result"] == "reReleased")  $("#lossCardNoDIV div span").text("此卡曾挂失,且已经补卡..."); 
            }
            $("#lossCardNo").val(data["cardNo"]);
        })
    });
});

/**挂失时，当点击了挂失触发的条件与ajax处理*/
$("#loss").click(function() {
    if (isLossCardNoReady) {
        $.post(getProjectName() + "/loss/lossHandle", {
            cardNo : $("#lossCardNo").val()
        }, function(data) {
            if (data["result"] == "success") {
                $("#loss").show();
                $("#lossCardNoDIV").attr("class", "control-group success");
                isLossCardNoReady = true;
            } else {
                $("#loss").hide();
                $("#lossCardNoDIV").attr("class", "control-group error");
                isLossCardNoReady = false;
            }
            $("#lossCardNoDIV div span").text(data["info"]);
        });
    } else {
        $("#lossCardNoDIV").attr("class", "control-group error");
        return false;
    }
});
/**挂失卡处理部分完成*/

var isCancelLossReady = false;
/**解除挂失处理开始*/
/**解除挂失时，使用ajax判断，卡号是否有初始化；是否曾发放给客户 */
$("#cancelLossCardNo").focusout(function() {
    var url = getProjectName() + "/loss/isLossCardExist";
    var cardNo = $("#cancelLossCardNo").val();
    //首先判断卡号格式是否正确；
    if (intFixedLength(cardNo, 6, 6)) {
        $.post(url, {
            cardNo : cardNo
        }, function(data) {
            if (data["result"] == "loss") {//代表此卡号是存在的并且已经挂失
                $("#cancelLoss").show();
                $("#cancelLossReadCardNoDIV").attr("class", "control-group success");
                $("#cancelLossReadCardNoDIV div span").text("卡已经挂失,可以解挂");
                isCancelLossReady = true;
            } else {
                $("#cancelLoss").hide();
                $("#cancelLossReadCardNoDIV").attr("class", "control-group error");
                isCancelLossReady = false;
                if(data["result"] == "notInitial")  $("#cancelLossReadCardNoDIV div span").text("此卡未初始化,不能识别.....");               
                if(data["result"] == "failed")  $("#cancelLossReadCardNoDIV div span").text("此卡为新卡,未发给任何客户.....");  
                if(data["result"] == "success")  $("#cancelLossReadCardNoDIV div span").text("此卡未挂失.");
                if(data["result"] == "reReleased")  $("#cancelLossReadCardNoDIV div span").text("此卡曾挂失,且已经补卡..."); 
            }
        });
    } else {
        $("#cancelLossReadCardNoDIV").attr("class", "control-group error");
        $("#cancelLossReadCardNoDIV div span").text("卡号有误");
        isCancelLossReady = false;
    }
});

$("#cancelLossReadCardNo").click(function() {
    $.ajax({
        url : getProjectName() + "/loss/isLossCardExist",
        data : {
            mac : readMac()
        },
        type : "POST",
        success : (function(data, status) {
            if (data["result"] == "loss") {//代表此卡号是存在的并且已经挂失
                $("#cancelLoss").show();
                $("#cancelLossReadCardNoDIV").attr("class", "control-group success");
                $("#cancelLossReadCardNoDIV div span").text("卡已经挂失,可以解挂");
                isCancelLossReady = true;
            } else {
                $("#cancelLoss").hide();
                $("#cancelLossReadCardNoDIV").attr("class", "control-group error");
                isCancelLossReady = false;
                if(data["result"] == "notInitial")  $("#cancelLossReadCardNoDIV div span").text("此卡未初始化,不能识别.....");               
                if(data["result"] == "failed")  $("#cancelLossReadCardNoDIV div span").text("此卡为新卡,未发给任何客户.....");  
                if(data["result"] == "success")  $("#cancelLossReadCardNoDIV div span").text("此卡未挂失.");
                if(data["result"] == "reReleased")  $("#cancelLossReadCardNoDIV div span").text("此卡曾挂失,且已经补卡..."); 
            }
            $("#cancelLossCardNo").val(data["cardNo"]);
        })
    });
});

$("#cancelLoss").click(function() {
    if (isCancelLossReady) {
        $.post(getProjectName() + "/loss/cancelLossHandle", {
            cardNo : $("#cancelLossCardNo").val()
        }, function(data) {
            if (data["result"] == "success") {
                $("#cancelLossReadCardNoDIV").attr("class", "control-group success");
            } else {
                $("#cancelLossReadCardNoDIV").attr("class", "control-group error");
            }
            $("#cancelLossReadCardNoDIV div span").text(data["info"]);
        });
    } else {
        $("#cancelLossReadCardNoDIV").attr("class", "control-group error");
        return false;
    }
});

/**解除挂失处理结束*/

var isReReleaseOldCardNo = false;
var isReReleaseNewCardNo = false;
/**补卡处理开始*/
/**补卡时，使用ajax判断，卡号是否有初始化；是否曾发放给客户并且为挂失卡:首先判断的是旧卡；然后再判断新卡 */
$("#reReleaseOldCardNo").focusout(function() {
    var url = getProjectName() + "/loss/isLossCardExist";
    var cardNo = $("#reReleaseOldCardNo").val();
    //首先判断卡号格式是否正确；
    if (intFixedLength(cardNo, 6, 6)) {
        $.post(url, {
            cardNo : cardNo
        }, function(data) {
            if (data["result"] == "loss") {
                $("#reRelease").show();
                $("#reReleaseReadOldCardNoDIV").attr("class", "control-group success");
                $("#reReleaseReadOldCardNoDIV div span").text("卡已经挂失,可以进行补卡.");
                isReReleaseOldCardNo = true;
            } else {
                $("#reRelease").hide();
                $("#reReleaseReadOldCardNoDIV").attr("class", "control-group error");
                isReReleaseOldCardNo = false;
                if(data["result"] == "notInitial")  $("#reReleaseReadOldCardNoDIV div span").text("此卡未初始化,不能识别.....");               
                if(data["result"] == "failed")  $("#reReleaseReadOldCardNoDIV div span").text("此卡为新卡,未发给任何客户.....");  
                if(data["result"] == "success")  $("#reReleaseReadOldCardNoDIV div span").text("此卡正常使用中,只有挂失卡可进行补卡.");
                if(data["result"] == "reReleased")  $("#reReleaseReadOldCardNoDIV div span").text("此卡曾挂失,且已经补卡..."); 
            }
            
        });
    } else {
        $("#reReleaseReadOldCardNoDIV").attr("class", "control-group error");
        $("#reReleaseReadOldCardNoDIV div span").text("卡号有误");
        isReReleaseOldCardNo = false;
    }
});

$("#reReleaseNewCardNo").focusout(function() {
    var url = getProjectName() + "/loss/isLossCardExist";
    var cardNo = $("#reReleaseNewCardNo").val();
    //首先判断卡号格式是否正确；
    if (intFixedLength(cardNo, 6, 6)) {
        $.post(url, {
            cardNo : cardNo
        }, function(data) {
            if (data["result"] == "failed") {//代表此卡存在，并且没有发给客户可以使用
                $("#reRelease").show();
                $("#reReleaseReadNewCardNoDIV").attr("class", "control-group success");
                $("#reReleaseReadNewCardNoDIV div span").text("此卡为新卡,可以进行补卡");
                isReReleaseNewCardNo = true;
            } else {
                $("#reRelease").hide();
                $("#reReleaseReadNewCardNoDIV").attr("class", "control-group error");
                isReReleaseNewCardNo = false;
                if(data["result"] == "notInitial")  $("#reReleaseReadNewCardNoDIV div span").text("此卡未初始化,不能识别.....");               
                if(data["result"] == "loss")  $("#reReleaseReadNewCardNoDIV div span").text("已挂失卡,不能作为补卡中的新卡使用.....");  
                if(data["result"] == "success")  $("#reReleaseReadNewCardNoDIV div span").text("此卡正常使用中,只有挂失卡可进行补卡.");
                if(data["result"] == "reReleased")  $("#reReleaseReadNewCardNoDIV div span").text("此卡曾挂失,且已经补卡..."); 
            }
        });
    } else {
        $("#reReleaseReadNewCardNoDIV").attr("class", "control-group error");
        $("#reReleaseReadNewCardNoDIV div span").text("卡号有误");
        isReReleaseNewCardNo = false;
    }
});

$("#reReleaseReadNewCardNo").click(function() {
    $.ajax({
        url : getProjectName() + "/loss/isLossCardExist",
        data : {
            mac : readMac()
        },
        type : "POST",
        success : (function(data, status) {
            if (data["result"] == "failed") {//代表此卡存在，并且没有发给客户可以使用
                $("#reRelease").show();
                $("#reReleaseReadNewCardNoDIV").attr("class", "control-group success");
                $("#reReleaseReadNewCardNoDIV div span").text("此卡为新卡,可以进行补卡");
                isReReleaseNewCardNo = true;
            } else {
                $("#reRelease").hide();
                $("#reReleaseReadNewCardNoDIV").attr("class", "control-group error");
                isReReleaseNewCardNo = false;
                if(data["result"] == "notInitial")  $("#reReleaseReadNewCardNoDIV div span").text("此卡未初始化,不能识别.....");               
                if(data["result"] == "loss")  $("#reReleaseReadNewCardNoDIV div span").text("已挂失卡,不能作为补卡中的新卡使用.....");  
                if(data["result"] == "success")  $("#reReleaseReadNewCardNoDIV div span").text("此卡正常使用中,只有挂失卡可进行补卡.");
                if(data["result"] == "reReleased")  $("#reReleaseReadNewCardNoDIV div span").text("此卡曾挂失,且已经补卡..."); 
            }
            $("#reReleaseNewCardNo").val(data["cardNo"]);
        })
    });
});

$("#reRelease").click(function() {
    if (isReReleaseNewCardNo && isReReleaseOldCardNo) {
        $.post(getProjectName() + "/loss/reReleaseHandle", {
            oldCardNo : $("#reReleaseOldCardNo").val(),
            newCardNo : $("#reReleaseNewCardNo").val(),
        }, function(data) {
            $("#reReleaseDIV span").text(data["info"]);
        });
    } else {
        $("#reReleaseDIV span").text(data["当前卡号参数未通过验证"]);
        return false;
    }
});

/**补卡处理结束*/

/**工具类*/
function readMac() {
    if (rd.dc_init(100, 115200) < 0) {
        alert("打开读卡器失败，请检查是否已经打开过了！");
        return;
    }
    if (rd.dc_beep(10) != 0) {
        alert("打开读卡器失败:蜂鸣不成功！");
        rd.dc_exit();
        return;
    }
    ;
    var mac;
    if (rd.dc_card(0, mac) != 0)// 寻卡、返回值小于0表示失败
    {
        alert("打开读卡器失败:寻卡失败，请检查是否已经打开过了！");
        rd.dc_exit();
        return;
    }
    mac = rd.get_bstrRBuffer_asc;
    return mac;
}

