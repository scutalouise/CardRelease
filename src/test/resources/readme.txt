建议分辨率大于：1280 * 768
指定浏览器：ie11(开启默认启动32位)

7.20需要处理的内容：
1.检查添加客户是否可用；(读卡部分)
2.添加修改客户，写卡信息处理。联系方式。。。
3.检查发卡，操作，添加

获取索引
$('#someId').prop('selectedIndex');
$('option:selected', '#someId').index();
$('#someId option').index($('#someId option:selected'))