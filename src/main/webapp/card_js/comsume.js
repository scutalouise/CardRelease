/*
 * 点击了"扣减"操作时，需要：
 * 1.卡号信息是否正确，
 * 2.验证扣点参数是否正确；
 * 3.扣点记录写往数据库；并返回状态和相应的信息，再写入卡片。
 * 4.扣点记录写入卡片；
 * 注意:此过程，无法保证写入卡片与写入数据库的事务性操作；暂时未做同步的考虑与处理；
 */
$("#comsumeButton").click(function() {
    //发送到服务器进行记录的插入，服务器操作完毕返回密钥，以便客户卡对服务器进行读写；根据定义的方式，卡片会写3条记录和标志，需要一一确定。。。
    //通过ajax方式，读取密钥，对卡进行写卡；将当前信息进行提交并回显结果；
    $.ajax({
        url : getProjectName() + "/trade/comsume",
        data : {
            mac : openCard(),
            ptTrade : 1
        },
        type : "POST",
        success : (function(data, status) {
            if (data["result"] == "success") {
                //返回回来的JSON中包含密钥，对密钥进行一一验证，并写入[交易数据]到对应的区块；写入[卡当前的次数]
                rd.put_bstrSBuffer_asc = data["keyA6"];
                //存储第7扇区，扇区7的密钥,待写入交易详情；
                if (rd.dc_load_key(0, 6) != 0)//载入对应扇区密钥，读取相关信息； 返回值小于0表示失败
                {
                    alert("dc_load_key载入初始化密钥时出错！请确认此卡是否为本系统已经发布的卡？");
                    rd.dc_exit();
                    return;
                }
                if (rd.dc_authentication(0, 6) != 0)//核对密码函数、第一个参数为密码验证模式、第二个参数为扇区号; 返回值小于0表示失败,卡号
                {
                    alert("扇区核对密码时出错！");
                    rd.dc_exit();
                    return;
                }
                if (rd.dc_read(25) != 0) {//此处保存的交易
                    alert("dc_read读区块错误");
                    rd.dc_exit();
                    return;
                }
                var tradeDetail = rd.get_bstrRBuffer_asc;
                //从上一步读取到的交易详情；
                //写入当前的交易详情；
                var tradeDate = data["tradeDate"].replace("-", "").replace("-", "");
                var dotId = data["dotId"];
                var count = 1;
                //默认每次扣1次
                rd.put_bstrSBuffer_asc = tradeDate + dotId + count + '01';
                //暂存将要写入到卡里，区块的信息；
                if (rd.dc_write(25) != 0)//写入卡的交易详情； 返回值小于0表示失败
                {
                    alert("dc_write 写卡错误!写的扇区为" + i);
                    rd.dc_exit();
                    return;
                }
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
                rd.put_bstrSBuffer_asc = data.customer.remainingPt;
                //从customer里取得当前剩余的次数
                if (rd.dc_write(22) != 0)//写入卡次数； 返回值小于0表示失败
                {
                    alert("dc_write 写卡错误!写的扇区为" + i);
                    rd.dc_exit();
                    return;
                }
                //关闭读卡器，并提示扣除成功；
                rd.dc_exit();
                $("#customerNameSpan").text(data.customerName);
                $("#todayComsumeSpan").text(data.todayComsume);
                $("#sumComsumeSpan").text(data.sumComsume);
                $("#remainComsumeSpan").text(data.remainComsume);
            } else {
                //需要判断卡当前状态，如果不能使用，需要给出提示：
                if (data["result"] == "failed")
                    $("#message").text("未找到客户信息:可能情况为:此卡未初始化或此卡曾经挂失并进行了补办.");
                if (data["result"] == "loss")
                    $("#message").text("当前卡为挂失卡,不能进行体验...");
                if (data["result"] == "invalid")
                    $("#message").text("当前卡超过了有效期不能使用.");
                if (data["result"] == "notEnough")
                    $("#message").text("剩余点数不足.");
            }
            $("#message").text(data.message);
            setInterval("clearData()", 1000 * 10);
            //每5秒刷新下，清空提示；
        })
    });
});

function clearData() {
    $("#customerNameSpan").text("");
    $("#todayComsumeSpan").text("");
    $("#sumComsumeSpan").text("");
    $("#remainComsumeSpan").text("");
    $("#message").text("");
}

/*
 * 工具函数，打开读卡器，并返回卡的物理地址；
 * @returns
 */
function openCard() {
    if (rd.dc_init(100, 115200) < 0) {
        alert("打开读卡器失败，请检查是否已经打开过了！");
        rd.dc_exit();
        return;
    }
    if (rd.dc_beep(10) != 0) {
        alert("蜂鸣失败！");
        rd.dc_exit();
        return;
    }
    var mac;
    if (rd.dc_card(0, mac) != 0)// 寻卡、返回值小于0表示失败
    {
        alert("寻卡失败，请确认已经将卡已接近读卡器！");
        rd.dc_exit();
        return;
    }
    mac = rd.get_bstrRBuffer_asc;
    // 得到物理地址：
    return mac;
}
