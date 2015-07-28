
/**
 *
 */

$("#bankCardTypeDIV").change(function() {
    alert($("#bankCardTypeDIV option[index='0']").val());
});



$("#kdlimitHref").click(function(){
	//先判断是否在customer中有引用，有的话不允许删除
	alert($(this).parent().parent().children().first().text());
	$.ajax({
        url:getProjectName() + "/isBankCardTypeRefByCustomer" ,
        data:{bankCardTypeId:$(this).parent().parent().children().first().text()},
        type:"POST",
        success:(function(data,status) {
        			alert(data["result"]);
        			if(data["result"] == "failed"){
//        				delete();
						alert("fsddg");
        			}else{
						alert(data["info"]); 
        			}
                })
    });	
});
		
		//提交数据
//		var href = $(this).attr("href");
//		$("#kdlimitForm").attr("action", href).submit();
//		return false;
	});