/** @namespace ztool */
var ztool = {};

/** @namespace ztool.util */
ztool.util = {};
/** @namespace ztool.util.StringUtil */
ztool.util.StringUtil = {};

/**
 * 字符串是否有值
 * @function isNotEmpty
 * @memberof ztool.util.StringUtil
 * @static
 * @param {string} str 待验证的字符串
 * @returns {boolean} true：有值
 */
ztool.util.StringUtil.isNotEmpty = function (str) {
    return undefined !== str && null != str && "" !== str;
};

/** @namespace ztool.util.net */
ztool.util.net = {};
/**
 * 获取当前项目路径
 * @function getURL
 * @memberof ztool.util.net
 * @static
 * @returns {string} 如：http://www.abc.com/platform
 */
ztool.util.net.getURL = function () {
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： cis/website/meun.htm
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName); //获取主机地址，如： http://localhost:8080
    var localhostPath = curWwwPath.substring(0, pos); //获取带"/"的项目名，如：/cis
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    var rootPath = localhostPath + projectName;
    return rootPath;
};
/** @namespace ztool.util.URL */
ztool.util.URL = {};
/**
 * 通过输入的参数名称获取URL的参数
 * @function getQueryString
 * @memberof ztool.util.URL
 * @static
 * @param {String} name 参数名称
 * @returns {string} 返回参数值，如果没有则返回null
 */
ztool.util.URL.getQueryString = function (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return decodeURI(r[2]);
    return null;
};
/** @namespace ztool.net */
ztool.net = {};
/**
 * 异步ajax请求
 * @function asyncAjaxData
 * @memberof ztool.net
 * @static
 * @param {String} url 请求地址
 * @param {json} data1 请求的json数据
 * @param {function}success 成功后回调函数
 */
ztool.net.asyncAjaxData = function (method, url, data1, success) {
    ztool.net.rest.ajaxJson(method, url, data1, function (data) {
        if ("function" === typeof (success)) {
            success(data);
        }
    }, function (error) {
        if (error.statusText) {
            if ("parsererror" === error.statusText) {
                alert("数据转换出错");
            } else {
                alert(error.statusText);
            }
            return;
        }
        if (error.status && error.status !== 200) {
            alert("访问出错；错误码：" + error.status + "内容：" + error.responseText);
            return;
        }
        alert(error);
    });
};
/**
 * 同步ajax请求
 * @function asyncAjaxData
 * @memberof ztool.net
 * @static
 * @param {string} url 请求的url
 * @param {json} data1 请求的json数据
 * @returns {*}服务器返回的数据
 */
ztool.net.ajaxData = function (method, url, data1) {
    var res = null;
    ztool.net.rest.syncajaxJson(method, url, data1, function (data) {
        res = data;
    }, function (error) {
        if (error.statusText) {
            if ("parsererror" === error.statusText) {
                alert("数据转换出错");
            } else {
                alert(error.statusText);
            }
            return;
        }
        if (error.status && error.status !== 200) {
            alert("访问出错；错误码：" + error.status + "内容：" + error.responseText);
            return;
        }
        alert(error);
    });
    return res;
};
/** @namespace ztool.net.rest */
ztool.net.rest = {};
/**
 * post异步请求
 * @function jsonpost
 * @memberof ztool.net.rest
 * @static
 * @param {string} url 请求的地址
 * @param {json} data 请求的json数据
 * @param {function} successcall 成功回调方法
 * @param {function} errorcall 失败回调方法
 */
ztool.net.rest.ajaxJson = function (method, url, data, successcall, errorcall) {
    this.invoke(url, method, 'json', JSON.stringify(data), true, successcall, errorcall);
};

/**
 * post同步请求
 * @function syncjsonpost
 * @memberof ztool.net.rest
 * @static
 * @param {string} url 请求的地址
 * @param {json} data 请求的json数据
 * @param {function} successcall 成功回调方法
 * @param {function} errorcall 失败回调方法
 */
ztool.net.rest.syncajaxJson = function (method, url, data, successcall, errorcall) {
    this.invoke(url, method, 'json', JSON.stringify(data), false, successcall, errorcall);
};
/**
 * 通用请求方法
 * @function invoke
 * @memberof ztool.net.rest
 * @static
 * @param {string} url 请求的地址
 * @param {string} method 请求类型 如 post get
 * @param {string} datatype 数据类型 参看jquery.ajax的dataType
 * @param {string} data 请求的数据
 * @param {bool} async 是否异步
 * @param {function} successcall 成功回调方法
 * @param {function} errorcall 失败回调方法
 */
ztool.net.rest.invoke = function (url, method, datatype, data, async, successcall, errorcall) {
    jQuery.ajax({
        "type": method,//'POST',
        "contentType": "application/" + datatype,
        "url": ztool.util.net.getURL() + url,
        "data": data,
        "async": async,
        "success": successcall,
        "error": errorcall
    });

};




