//用于列表页面id列显示别名  这里存在一个约定规则，例如：expertId会去找expertIdName列内容
function labelFormatter(cellvalue, options, rowObject) {
    //debugger;
    var labelKey = options.colModel.name;
    var labelName = labelKey + "Name";
    var labelVal = rowObject[labelName];
    if (labelVal !== undefined) {
        return labelVal;
    } else {
        return "";
    }
}

function showLinkEditModel(cellvalue, options, rowObject) {
    if (cellvalue !== undefined) {
        return "<a href='javascript:void(0)' onclick='showEditModel(" + rowObject["id"] + ",\"" + options.colModel.name + "\",\"" + cellvalue + "\")'>" + cellvalue + "</a>";
    } else {
        var addAnswer = "添加答案";
        return "<a href='javascript:void(0)' onclick='showEditModel(" + rowObject["id"] + ",\"" + options.colModel.name + "\",\"" + addAnswer + "\")'>" + addAnswer + "</a>";
    }
}

function showEditModel(editId, editCtlId, editVal) {
    $('#editId').val(editId);
    $("textarea[id='" + editCtlId + "']").val(editVal);
    $('#edit_modal').modal('show');
}

//日期 long 显示为 yyyy-MM-dd hh:mm:ss
function formatdate(cellvalue) {
    if (cellvalue == null || cellvalue == '' || cellvalue == 0) {
        return "";
    }
    var date = new Date(cellvalue);
    var month = (date.getMonth() + 1);
    var dates = date.getDate();
    var hour = date.getHours();
    var minutes = date.getMinutes();
    var seconds = date.getSeconds();
    if (month < 10) {
        month = "0" + month;
    }
    if (dates < 10) {
        dates = "0" + dates;
    }
    if (hour < 10) {
        hour = "0" + hour;
    }
    if (minutes < 10) {
        minutes = "0" + minutes;
    }
    if (seconds < 10) {
        seconds = "0" + seconds;
    }


    return date.getFullYear() + "-" + month + "-" + dates + " " + hour + ":" + minutes + ":" + seconds;
}


//日期 long 显示为 yyyy-MM-dd
function formatshortdate(cellvalue) {
    if (cellvalue == null || cellvalue == '' || cellvalue == 0) {
        return "";
    }
    var date = new Date(cellvalue);
    var month = (date.getMonth() + 1);
    var dates = date.getDate();
    if (month < 10) {
        month = "0" + month;
    }
    if (dates < 10) {
        dates = "0" + dates;
    }


    return date.getFullYear() + "-" + month + "-" + dates;
}

//同步获取 jqgrid编辑页面 select 组件值
function dynGetData(ajaxUrl) {
    var returnStr = "";
    $.ajaxSettings.async = false;
    $.getJSON(ajaxUrl, function (result) {
        //debugger;
        if ("0000000" == result.rtnCode) {
            for (i = 0; i < result.bizData.rows.length; i++) {
                if (i < result.bizData.rows.length - 1) {
                    returnStr += result.bizData.rows[i].id + ":" + result.bizData.rows[i].name + ";";
                } else {
                    returnStr += result.bizData.rows[i].id + ":" + result.bizData.rows[i].name;
                }
            }

        } else {
            alert("request error");
        }

    });
    $.ajaxSettings.async = true;
    return returnStr;
}

//对一个字段多个属性值组合的列进行显示
function multiValsShow(cellvalue, options, rowObject) {
    if (cellvalue == null || cellvalue == '' || cellvalue == 0) {
        return "";
    }
    if (tempVals == undefined) {
        dynGetData2Map(options.colModel.formatoptions.ajaxUrl);
    }

    var returnStr = "";
    var vals = cellvalue.split(',');
    for (i = 0; i < vals.length; i++) {
        if (i < vals.length - 1) {
            returnStr += tempVals[vals[i]] + ",";
        } else {
            returnStr += tempVals[vals[i]];
        }
    }

    return returnStr;
}

var tempVals;
function dynGetData2Map(ajaxUrl) {
    tempVals = new Object();
    $.ajaxSettings.async = false;
    $.getJSON(ajaxUrl, function (result) {
        //debugger;
        if ("0000000" == result.rtnCode) {
            for (i = 0; i < result.bizData.rows.length; i++) {
                tempVals[result.bizData.rows[i].id] = result.bizData.rows[i].name;
            }

        } else {
            alert("request error");
        }

    });
    $.ajaxSettings.async = true;
}


//multi checkbox 编辑控件渲染
function MultiCheckElem(value, options) {
    //———-
    // for each checkbox in the list
    //   build the input element
    //   set the initial "checked" status
    // endfor
    //———-
    value = value + ",";
    var ctl = '';
    var ckboxAry = options.list.split(';');

    for (var i in ckboxAry) {
        var item = ckboxAry[i].split(':');

        ctl += '<input type="checkbox" ';

        if (value.indexOf(item[1] + ',') != -1)
            ctl += 'checked="checked" ';
        ctl += 'value="' + item[0] + '"> ' + item[1] + '</input><br />&nbsp;';
    }

    //ctl = ctl.replace( /<br />&nbsp;$/, '' );
    return ctl;
}
function showUser(cellvalue) {
    var userName;
    switch (cellvalue) {
        case 0:
            userName = "系统";
            break;
        case 1:
            userName = "戴工博";
            break;
        default :
            userName = "";
    }
    return userName;
}

//是否存在指定函数
function isExitsFunction(funcName) {
    try {
        if (typeof(eval(funcName)) == "function") {
            return true;
        }
    } catch (e) {
    }
    return false;
}
//是否存在指定变量
function isExitsVariable(variableName) {
    try {
        if (typeof(variableName) == "undefined") {
            //alert("value is undefined");
            return false;
        } else {
            //alert("value is true");
            return true;
        }
    } catch (e) {
    }
    return false;
}

function formatState(cellvalue) {
    if ("10" == cellvalue) {
        return "正常";
    } else if ("20" == cellvalue) {
        return "停用";
    } else { //30
        return "逻辑删除";
    }
}

function formatIsParent(cellvalue) {
    if ("true" == cellvalue) {
        return "是";
    } else {
        return "否"
    }
}

function formatHide(cellvalue) {
    if ("1" == cellvalue) {
        return "是";
    } else if ("0" == cellvalue) {
        return "否";
    } else { //30
        return "逻辑删除";
    }
}
function formatSex(cellvalue) {
    if ("1" == cellvalue) {
        return "男";
    } else if ("2" == cellvalue) {
        return "女";
    } else { //30
        return "未知";
    }
}

function tagType(cellvalue) {
    if ("1" == cellvalue) {
        return "A类";
    } else {
        return "B类";
    }
}


function clientType(cellvalue) {
    if ("1" == cellvalue) {
        return "内部应用";
    } else if ("2" == cellvalue) {
        return "外部应用";
    } else {
        return "特殊应用";
    }
}

function showXdName(value){
    if("1" == value){
       return "幼儿园"
    }else if ("2" == value){
        return "小学";
    }else if ("4" == value){
        return "初中";
    }else if ("8" == value){
        return "高中";
    }else{
        return "大学";
    }
}



function undefinedHide(cellvalue) {
    if (cellvalue == undefined) {
        return "";
    } else {
        return cellvalue;
    }
}
function goToSection(courseId) {
    var path = "/admin/video/exSection/sectioninfo?courseId=" + courseId;
    location.href = path;
}
function optionPackage(cellvalue) {
    if (cellvalue == "undefined") {
        return "";
    } else {
        //var path = "sectioninfo?courseId="+cellvalue;
        //var option = "<a href='"+path+"'>课时管理</a>";
        var option = "<a href='#' onClick='goToSection(" + cellvalue + ")'>课时管理</a>";
        return option;
    }
}
function formatSeconds(cellvalue) {
    var theTime = parseInt(cellvalue);// 秒
    var theTime1 = 0;// 分
    var theTime2 = 0;// 小时
    if (theTime > 60) {
        theTime1 = parseInt(theTime / 60);
        theTime = parseInt(theTime % 60);
        if (theTime1 > 60) {
            theTime2 = parseInt(theTime1 / 60);
            theTime1 = parseInt(theTime1 % 60);
        }
    }
    var result = "" + parseInt(theTime) + "秒";
    if (theTime1 > 0) {
        result = "" + parseInt(theTime1) + "分" + result;
    }
    if (theTime2 > 0) {
        result = "" + parseInt(theTime2) + "小时" + result;
    }
    return result;
}
//$(function(){
//    $("#del_grid-table").remove();
//
//})