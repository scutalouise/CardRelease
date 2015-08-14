/*
 * 逻辑： 1.从vip卡上，读取卡信息； 2.将卡信息通过ajax方式发送到服务器，以cardNo查询出客户信息；此处选择读取卡信息，通过密钥的方式
 */
$("#readCard").click(function() {
    //有2种方式去取数据，2.1得到密钥，根据密钥去读取写在卡面的数据；2.2从服务器上去取mac对应的卡号和客户信息，回显到客户端...
    var url = getProjectName() + "/trade/recharge/getInfoByMac";
    var mac = openCard();
    $.post(
        url,
        {mac:mac},
        function(data){
            if(data["result"]== "success"){
                $("#rechargeButtonDIV button").show();
                $("#cardNo").val(data.customer.cardNo);
                $("#bankCardNo").val(data.customer.bankCardNo);
                $("#customerName").val(data.customer.customerName);
                $("#customerTel").val(data.customer.customerTel);
                $("#ptBefore").val(data.customer.remainingPt);
            }else{
                $("#rechargeButtonDIV button").hide();
                $("#readCardDIV").attr("class", "control-group error");
                if(data["result"]== "notInitial")$("#readCardDIV div span").text("此卡未发行，需要初始化.");
                if(data["result"]== "loss")$("#readCardDIV div span").text("挂失卡");
                if(data["result"]== "reReleased")$("#readCardDIV div span").text("曾经的挂失卡，并且已经补发了新卡.此卡已经不能使用。");
                if(data["result"]== "failed")$("#readCardDIV div span").text("此卡未分配给一个客户.不能使用。");
            }
        }
    );
});

$("#ptTrade").blur(function(){
    if (!(/^\d{1,2}$/.test($("#ptTrade").val())) || $("#ptTrade").val() < 0) {
        $("#ptTradeDIV").attr("class", "control-group error");
        return;
    }else{
    	$("#ptTradeDIV").attr("class", "control-group success");
    }
});


/*
 * 点击了"充点"操作时，需要：
 * 1.卡号信息是否正确，
 * 2.验证充点参数是否正确；
 * 3.充点记录写往数据库；并返回状态和相应的信息，再写入卡片。
 * 4.充点记录写入卡片；
 * 注意:此过程，无法保证写入卡片与写入数据库的事务性操作；暂时未做同步的考虑与处理；
 */
$("#rechargeButton").click(function() {
    //检查卡号是否存在，
    if ($("#cardNo").val().length != 6) {
        $(".form-actions button").hide();
        $("#readCardDIV").attr("class", "control-group error");
        $("#readCardDIV div span").text("请先读取卡信息");
        return;
    } else {
        $(".form-actions button").show();
        $("#readCardDIV div span").text("");
        $("#readCardDIV").attr("class", "control-group success");
    };
    //验证扣点参数格式是否正确
    var pt = $("#ptTrade").val();
    if (!(/^\d{1,2}$/.test(pt)) || pt < 0) {
        alert("数量必须是正整数！");
        return;
    }
    //发送到服务器进行记录的插入，服务器操作完毕返回密钥，以便客户卡对服务器进行读写；根据定义的方式，卡片会写3条记录和标志，需要一一确定。。。
    var mac = openCard();
    var ptTrade = $("#ptTrade").val();
//    alert("mac:" + mac + ";ptTrade" + ptTrade);
    //通过ajax方式，读取密钥，对卡进行写卡；将当前信息进行提交并回显结果；
    $.ajax({
        url : getProjectName() + "/trade/recharge",
        data : {
            mac : mac,
            ptTrade : ptTrade
        },
        type : "POST",
        success : (function(data, status) {
            //返回回来的JSON中包含密钥，对密钥进行一一验证，并写入[次数]到第6扇区，即扇区5块2
            //准备写入最新的卡片次数
            rd.put_bstrSBuffer_asc = data["keyA5"];
            //存储第6扇区，扇区5密钥
            if (rd.dc_load_key(0, 5) != 0)//载入对应扇区密钥，读取相关信息； 返回值小于0表示失败
            {
                alert("dc_load_key载入初始化密钥时出错！请确认此卡是否为本系统已经发布的卡？");
                rd.dc_exit();
                return;
            }
            if (rd.dc_authentication(0, 5) != 0)//核对密码函数、第一个参数为密码验证模式、第二个参数为扇区号; 返回值小于0表示失败,卡号
            {
                alert("扇区核对密码时出错！");
                rd.dc_exit();
                return;
            }
            rd.put_bstrSBuffer_asc = data["remainingPt"];
            //从customer里取得当前剩余的次数
            if (rd.dc_write(22) != 0)//写入卡次数； 返回值小于0表示失败
            {
                alert("dc_write 写卡错误!写的扇区为" + i);
                rd.dc_exit();
                return;
            }
            //关闭读卡器，并提示扣除成功；
            rd.dc_exit();
            $("#rechargeButtonDIV span").text(data["message"]);
            $("#cardNo").val(data.customer.cardNo);
            $("#bankCardNo").val(data.customer.bankCardNo);
            $("#customerName").val(data.customer.customerName);
            $("#customerTel").val(data.customer.customerTel);
            $("#ptBefore").val(data.ptBefore);
            $("#ptTrade").val(data.ptTrade);
            $("#ptAfter").val(data.ptAfter);
        })
    });
});

/*
 * 工具函数，打开读卡器，并返回卡的物理地址；
 * @returns
 */
function openCard() {
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
    // 得到物理地址：
    return mac;
}
