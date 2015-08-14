/**
 *
 */
function getProjectName() {
    //获取当前网址，如： http://localhost:8080/Tmall/index.jsp
    var curWwwPath = window.document.location.href;

    //获取主机地址之后的目录如：/Tmall/index.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);

    //获取主机地址，如： http://localhost:8080
    var localhostPaht = curWwwPath.substring(0, pos);

    //获取带"/"的项目名，如：/Tmall
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    
    return projectName;
}


/**是否为空(任意字符串)
 * @param {Object} cs
 */
function isNull(cs){
	if( cs != "" && cs.length >0 ){
		return false;
	}else{
		return true;
	}
}

/**是否满足长度的范围(单词字符)
 * @param {Object} cs
 * @param {Object} minLength
 * @param {Object} maxLength
 */
function stringFixedLength(cs,minLength,maxLength){
	var reg = new RegExp("^[\\w\\W]{" + minLength + "," + maxLength + "}$","i"); 
	if(reg.test(cs)){
		return true;
	}else{
		return false;
	}
}

/**是否为整数
 * @param {Object} cs
 */
function isInt(cs){
	var reg = new RegExp("^\\d+$","i");
	if(reg.test(cs)){
		return true;
	}else{
		return false;
	}
}


/**是否满足长度的范围(整数)
 * @param {Object} cs
 * @param {Object} minLength
 * @param {Object} maxLength
 */
function intFixedLength(cs,minLength,maxLength){
	var reg = new RegExp("^\\d{" + minLength + "," + maxLength + "}$","i"); 
	if(reg.test(cs)){
		return true;
	}else{
		return false;
	}
}

/**
 *是否包含特殊字符 
 * @param {Object} cs
 */
function isContainsSpecialString(cs){
	var reg = new RegExp("^[\u4E00-\u9FA5\uf900-\ufa2d\\w\.\\s]+$","i");
	if(reg.test(cs)){
		return true;
	}else{
		return false;
	}
}


/**
 *是否是email格式的； 
 * @param {Object} cs
 */
function isEmail(cs){
	var reg = new RegExp("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\.\\w+([-.]\\w+)*$","i");
	if(reg.test(cs)){
		return true;
	}else{
		return false;
	}
}

/**
 *是否为合法Url地址 
 * @param {Object} cs
 */
function isUrl(cs){
	var reg = new RegExp("^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$","i");
	if(reg.test(cs)){
		return true;
	}else{
		return false;
	}
	
}

/**
 * 是否为合法ip
 * @param {Object} cs
 */
function isIP(cs){
	/*var reg = new RegExp("((?:(?:25[0-5]|2[0-4]\d|((1\d{2})|([1-9]?\d)))\.){3}(?:25[0-5]|2[0-4]\d|((1\d{2})|([1-9]?\d))))","i");*/
	var reg = new RegExp("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$","i");
	if(reg.test(cs)){
		return true;
	}else{
		return false;
	}
}

/**
 *select元素当前选中项的索引是否为第一个 
 * @param {Object} cs :传入值为select元素
 */
function isFirstOptionSelected(cs){
	if(cs.prop('selectedIndex') == 0){
		return true;
	}else{
		return false;
	}
}

/**
 *是否匹配给定的正则表达式； 
 * @param {Object} cs
 * @param {Object} pattern
 */
function isMatchPattern(cs,pattern){
	var reg = new RegExp(pattern,"i");
	if(reg.test(cs)){
		return true;
	}else{
		return false;
	}
}