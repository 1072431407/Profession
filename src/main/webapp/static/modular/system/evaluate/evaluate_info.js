/**
 * 初始化广告详情对话框
 */
var EvaluateInfoDlg = {
    evaluateInfoData : {}
};

/**
 * 清除数据
 */
EvaluateInfoDlg.clearData = function() {
    this.evaluateInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
EvaluateInfoDlg.set = function(key, val) {
    this.evaluateInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
EvaluateInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
EvaluateInfoDlg.close = function() {
    parent.layer.close(window.parent.Evaluate.layerIndex);
}

/**
 * 收集数据
 */
EvaluateInfoDlg.collectData = function() {
    this
    .set('id')
    .set('title')
    .set('content')
    .set('user')
    .set('position')
    .set('recruiter')
    .set('createtime')
    .set('isdeleted');
}

/**
 * 提交添加
 */
EvaluateInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/evaluate/add", function(data){
        Feng.success("添加成功!");
        window.parent.Evaluate.table.refresh();
        EvaluateInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.evaluateInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
EvaluateInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/evaluate/update", function(data){
        Feng.success("修改成功!");
        window.parent.Evaluate.table.refresh();
        EvaluateInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.evaluateInfoData);
    ajax.start();
}

$(function() {

});
