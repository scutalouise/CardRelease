$("#cardHref").click(function() {
    alert();
    var href = $(this).attr("href");
    alert(href);
    $("#bankCardTypeForm").attr("action", href).submit();
    return false;
});

//提交数据
$("#kdlimitHref").click(function() {
    //先判断是否在customer中有引用，有的话不允许删除
    /* console.info($(this).parent().parent().children().first().text()) */
    var commit = true;
    $.ajax({
        url : getProjectName() + "/basedata/isBankCardTypeRefByCustomer",
        data : {
            bankCardTypeId : $(this).parent().parent().children().first().text()
        },
        type : "POST",
        success : (function(data, status) {
            if (data["result"] == "failed") {
                commit = false;
            } else {
                alert(data["info"]);
            }
        })
    });
    //提交数据
    if (commit) {
        var href = $(this).attr("href");
        $("#kdlimitForm").attr("action", href).submit();
    }
    return false;
});
