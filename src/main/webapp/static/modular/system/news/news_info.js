/**
 * 初始化新闻详情对话框
 */
var NewsInfoDlg = {
    newsInfoData : {},
	editor: null,
	validateFields: {
	    title: {
	        validators: {
	            notEmpty: {
	                message: '标题不能为空'
	            }
	        }
	    }
	}
};

/**
 * 清除数据
 */
NewsInfoDlg.clearData = function() {
    this.newsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
NewsInfoDlg.set = function(key, val) {
    this.newsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
NewsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
NewsInfoDlg.close = function() {
    parent.layer.close(window.parent.News.layerIndex);
}

/**
 * 收集数据
 */
NewsInfoDlg.collectData = function() {
	this.newsInfoData['content'] = NewsInfoDlg.editor.txt.html();
    this
    .set('id')
    .set('title')
    .set('newsurl')
    .set('isdeleted');
}

/**
 * 提交添加
 */
NewsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/news/add", function(data){
        Feng.success("添加成功!");
        window.parent.News.table.refresh();
        NewsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.newsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
NewsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/news/update", function(data){
        Feng.success("修改成功!");
        window.parent.News.table.refresh();
        NewsInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.newsInfoData);
    ajax.start();
}

$(function() {
	$("#isdeleted").val($("#isdeletedValue").val());
	Feng.initValidator("newsInfoForm", NewsInfoDlg.validateFields);

    //初始化编辑器
    var E = window.wangEditor;
    var editor = new E('#editor');
    editor.customConfig.uploadImgShowBase64 = true;
    editor.create();
    editor.txt.html($("#contentVal").val());
    NewsInfoDlg.editor = editor;
});
