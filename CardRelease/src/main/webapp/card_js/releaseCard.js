/**
 * @Author scuta
 * @Since 2015-07-02
 * 对卡的操作封装在此；54D25627
 * 客户端通过发送mac地址到服务器，由服务器加密生成对应的keyA与keyB，
 * B759D7546D0804006263646566676869
 */
/**
 *卡号录入的检查、6位，number；需要通过ajax判断，是否数据库中已经存在；默认给出最大值。。。
 */
$("#cardno_div .controls input").blur(function() {
    var cardno = $("#cardno_div .controls input").val();
    var ex = /^\d{6}$/;
    if (!ex.test(cardno)) {
        $("#cardno_div").attr("class", "control-group error");
        $("#cardno_div label").attr("for", "inputError");
        $("#cardno_div .controls input").attr("id", "inputError");
        $("#cardno_div .controls span").text("输入卡号错误 ！");
        $("#releaseCard").hide();
        return;
    } else {
        $("#cardno_div").attr("class", "control-group success");
        $("#cardno_div label").attr("for", "inputSuccess");
        $("#cardno_div .controls input").attr("id", "inputSuccess");
        $("#cardno_div .controls span").text("卡号正确 ！");
        $("#releaseCard").show();
    }

    /**
     * 通过ajax判断，是否存在卡号，
     */
    $.ajax({
        url : getProjectName() + "/cardRelease/isCardNoExist",
        data : {
            cardNo : $("#cardno_div div input").val()
        },
        type : "POST",
        success : (function(data, status) {
            if (data["result"] == "failed") {
                $(".form-actions button").show();
                $("#cardno_div div span").text(data["info"]);
                $("#cardno_div").attr("class", "control-group success");
            } else if (data["result"] == "success") {
                $(".form-actions button").hide();
                $("#cardno_div div span").text(data["info"]);
                $("#cardno_div").attr("class", "control-group error");
            }
        })
    });
});

/**
 *发卡要做的操作：
 *  ①寻卡,根据寻卡得到的mac;
 *  ②向服务器发送ajax请求,获取加密后的对应扇区密钥；
 *  ③载入初始密钥、进行密钥验证；
 *  ④按照制定的制卡规格进行写数据进卡；写卡之前先发送请求添加发卡信息，发卡记录生成后，返回结果，再根据结果对卡进行发行；
 *  ⑤从读卡器退出；
 */
$("#releaseCard").click(function() {
    /**
     *首先判断，要求先点击打开读卡器；
     *其次，判断，是否有录入正确的卡号；
     */
    if (rd.dc_init(100, 115200) < 0) {
        alert("打开读卡器失败，请检查是否已经打开过了！");
        rd.dc_exit();
        return;
    }
    if (rd.dc_beep(10) != 0) {
        alert("打开读卡器失败:蜂鸣不成功！");
        rd.dc_exit();
        return;
    };
    var mac;
    if (rd.dc_card(0, mac) != 0)//寻卡、返回值小于0表示失败
    {
        alert("打开读卡器失败:寻卡不成功，请检查是否已经打开过了！");
        rd.dc_exit();
        return;
    }
    //验证下是否卡号无误；
    var cardno = $("#cardno_div .controls input").val();
    var ex = /^\d{6}$/;
    if (!ex.test(cardno)) {
        $("#cardno_div").attr("class", "control-group error");
        $("#cardno_div label").attr("for", "inputError");
        $("#cardno_div .controls input").attr("id", "inputError");
        $("#cardno_div .controls span").text("输入卡号错误 ！");
        rd.dc_exit();
        return;
    } else {
        $("#cardno_div").attr("class", "control-group success");
        $("#cardno_div label").attr("for", "inputSuccess");
        $("#cardno_div .controls input").attr("id", "inputSuccess");
        $("#cardno_div .controls span").text("卡号正确 ！");
    }

    mac = rd.get_bstrRBuffer_asc;
    // alert("得到的卡片物理地址为：" + rd.get_bstrRBuffer_asc);t_bstrRBuffer，一般有不可显示字符出现:"54D759B7"
    $.ajax({
        url : getProjectName() + "/cardRelease/release/",
        data : {
            mac : mac,
            cardNo : cardno
        },
        type : "POST",
        success : (function(data, status) {
        /**
         * 根据服务器返回的密钥，对卡进行处理码装入读写模块RAM中、第一个参数为装入密码模式、第二个参数为扇区号、
         * 对每一个扇区进行加密处理；
         * 发卡记录生成后，再进行卡的操作；
         */
            if (data["result"] == "success") {
                for (var i = 0; i < 16; i++) {
                    rd.put_bstrSBuffer_asc = "FFFFFFFFFFFF";
                    /**
                     *发卡：实质为向第一扇区、尾块写入对应的密钥keyA与keyB；以及控制位信息（妈蛋、js接口中没提供write函数的封装dc_changeb3()函数，只能自己去读取原始数据对数据进行拼接）
                     * 向卡中写入数据，一次必须写一个块、第一个参数为块地址
                     * 在调用dc_write必须前先设置属性rd.put_bstrSBuffer或rd.put_bstrSBuffer_asc
                     * 注意:(先读取要写的块的原始数据，并读取到控制符：)
                     */
                    if (rd.dc_load_key(0, i) != 0)//返回值小于0表示失败
                    {
                        alert("载入初始化密钥时出错！");
                        rd.dc_exit();
                        return;
                    }
                    if (rd.dc_authentication(0, i) != 0)//核对密码函数、第一个参数为密码验证模式、第二个参数为扇区号返回值小于0表示失败
                    {
                        alert("扇区核对密码时出错！");
                        rd.dc_exit();
                        return;
                    }
                    if (rd.dc_read(i * 4 + 3) != 0) {//js接口中没提供write函数的封装dc_changeb3()函数，只能自己去读取原始数据对数据进行拼接;读取每个区的尾块；
                        alert("dc_read读区块错误");
                        rd.dc_exit();
                        return;
                    }
                    var original = rd.get_bstrRBuffer_asc;
                    //取得原始区块的控制符 ;
                    var final = data["keyA" + i] + original.substring(12, 20) + data["keyB" + i];
                    rd.put_bstrSBuffer_asc = final;
                    if (rd.dc_write(i * 4 + 3) != 0)//向对应每个扇区写数据；并且将卡号写到扇区5 块1；;返回值小于0表示失败
                    {
                        alert("dc_write 写卡错误!写的扇区为" + i);
                        rd.dc_exit();
                        return;
                    }
                    if (i == 5) {//向第21块区，即第5扇区第1块写卡号,每个区块为32字节，卡号默认为6位；区块从0开始计数；
                        for (var m = cardno.length; m < 32; m++) {
                            cardno = "0" + cardno;
                        }
                        rd.put_bstrSBuffer_asc = cardno;
                        if (rd.dc_write(21) != 0) {
                            alert("dc_write 写卡错误!写的扇区为" + i);
                            rd.dc_exit();
                            return;
                        }
                    }
                }
                //关闭端口
                rd.dc_exit();
                //给客户端一个提示:
                $("#cardno_div .controls span").text("恭喜您，发卡成功 ！");
            } else {
                $("#cardno_div .controls span").text("发卡记录生成有误，发卡失败 ！");
                rd.dc_exit();
            }
        })
    });
});

/**
 * 读卡按钮的操作：直接读取卡物理地址，发送到服务器得到对应的卡密钥，
 * 载入卡密钥，读取卡信息，呈现；
 */
$("#readCard + div > button").click(function() {
    //打开读卡器
    if (rd.dc_init(100, 115200) < 0) {
        alert("打开读卡器失败，请检查是否已经打开过了！");
        rd.dc_exit();
        return;
    }
    if (rd.dc_beep(5) != 0) {
        alert("打开读卡器失败:蜂鸣不成功！");
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
    // alert($(this).val() + ":" + rd.get_bstrRBuffer_asc);//*****************************************
    //发送ajax与从服务器获取密钥；
    $.get(getProjectName() + "/cardRelease/getKey/" + rd.get_bstrRBuffer_asc, function(data, status) {
        // alert("status:" + status);//*****************************************
        rd.put_bstrSBuffer_asc = data["keyA5"];
        // rd.put_bstrSBuffer_asc = "FFFFFFFFFFFF";//测试需要去掉此为测试的默认代码；
        //载入对应扇区密钥，读取相关信息；
        if (rd.dc_load_key(0, 5) != 0)//返回值小于0表示失败
        {
            alert("dc_load_key载入初始化密钥时出错！请确认此卡是否为本系统已经发布的卡？");
            rd.dc_exit();
            return;
        }
        //核对密码函数、第一个参数为密码验证模式、第二个参数为扇区号
        if (rd.dc_authentication(0, 5) != 0)//返回值小于0表示失败,卡号
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
        // alert("读取的cardno:" + cardno); //*****************************************
        //取的是正常的数据，非16进制数据；
        $("#readCard .controls input").val(cardno);
        //关闭端口
        rd.dc_exit();
    });
});

/**
 *还原按钮的点击事件：对本系统发卡的卡，进行还原初始化，恢复至出厂状态；
 *  1. 卡初始化、寻卡、发送mac到服务器获取密钥；
 *  2. 根据返回的密钥，载入每个扇区，并对每个扇区进行初始化加密处理！keyA=‘FFFFFFFFFFFF’,keyB="000000000000"
 */
$("#recovery").click(function() {
    //打开读卡器
    if (rd.dc_init(100, 115200) < 0) {
        alert("打开读卡器失败，请检查是否已经打开过了！");
        rd.dc_exit();
        return;
    }
    if (rd.dc_beep(5) != 0) {
        alert("打开读卡器失败:蜂鸣失败！");
        rd.dc_exit();
        return;
    };
    var mac;
    //ma获取到，没多大用
    if (rd.dc_card(0, mac) != 0)//寻卡、返回值小于0表示失败
    {
        alert("dc_card 寻卡失败!请先打开读卡器");
        rd.dc_exit();
        return;
    }
    // alert($(this).val() + ":" + rd.get_bstrRBuffer_asc);//*****************************************
    //发送ajax与从服务器获取密钥；
    $.get(getProjectName() + "/cardRelease/getKey/" + rd.get_bstrRBuffer_asc, function(data, status) {
        // alert("status:" + status);//*****************************************
        for (var i = 0; i < 16; i++) {
            /**
             *发卡：实质为向每块扇区、尾块写入对应的密钥keyA与keyB；以及控制位信息（妈蛋、js接口中没提供write函数的封装dc_changeb3()函数，只能自己去读取原始数据对数据进行拼接）
             * 向卡中写入数据，一次必须写一个块、第一个参数为块地址
             * 在调用dc_write必须前先设置属性rd.put_bstrSBuffer或rd.put_bstrSBuffer_asc
             * 注意:(先读取要写的块的原始数据，并读取到控制符：)
             */
            rd.put_bstrSBuffer_asc = data["keyA" + i];
            //rd.put_bstrSBuffer_asc = "FFFFFFFFFFFF";//测试需要注释掉
            if (rd.dc_load_key(0, i) != 0)//返回值小于0表示失败
            {
                alert("dc_load_key载入初始化密钥时出错！请确认此卡是否为本系统已经发布的卡？");
                rd.dc_exit();
                return;
            }
            //核对密码函数、第一个参数为密码验证模式、第二个参数为扇区号
            if (rd.dc_authentication(0, i) != 0)//返回值小于0表示失败
            {
                alert("扇区核对密码时出错！");
                rd.dc_exit();
                return;
            }
            //js接口中没提供write函数的封装dc_changeb3()函数，只能自己去读取原始数据对数据进行拼接;读取每个区的尾块；
            if (rd.dc_read(i * 4 + 3) != 0) {
                alert("dc_read读区块错误");
                rd.dc_exit();
                return;
            }
            //取得原始区块的控制符 ;注意，在写入卡时，keyA+控制位+keyB；
            var original = rd.get_bstrRBuffer_asc;
            var final = "FFFFFFFFFFFF" + original.substring(12, 20) + "000000000000";
            rd.put_bstrSBuffer_asc = final;
            // alert(final);//*****************************************
            //向对应每个扇区尾块(3)写出厂数据数据；其他数据区全写0
            if (rd.dc_write(i * 4 + 3) != 0)//返回值小于0表示失败，恢复控制区
            {
                alert("dc_write 写卡错误!");
                rd.dc_exit();
                return;
            }
            rd.put_bstrSBuffer_asc = "00000000000000000000000000000000";
            //恢复数据区
            if (i == 0) {//第0扇区只有2个数据块区
                rd.dc_write(i * 4 + 1);
                rd.dc_write(i * 4 + 2);
            } else {//非0扇区有3个数据块
                rd.dc_write(i * 4 + 0);
                rd.dc_write(i * 4 + 1);
                rd.dc_write(i * 4 + 2);
            }
        }
        //关闭端口
        rd.dc_exit();
        //给出客户端的提示；
        $("#recovery + span").text("还原成功，已经初始化！");
        $("#recovery + span").css("color:#669533", "display:inline-block", "margin-bottom:0");
    });
});

