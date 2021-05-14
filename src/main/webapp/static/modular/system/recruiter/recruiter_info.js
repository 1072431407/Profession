/**
 * 初始化招聘者详情对话框
 */
var RecruiterInfoDlg = {
    recruiterInfoData : {}
};

/**
 * 清除数据
 */
RecruiterInfoDlg.clearData = function() {
    this.recruiterInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RecruiterInfoDlg.set = function(key, val) {
    this.recruiterInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RecruiterInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
RecruiterInfoDlg.close = function() {
    parent.layer.close(window.parent.Recruiter.layerIndex);
}

/**
 * 收集数据
 */
RecruiterInfoDlg.collectData = function() {
    this
    .set('id')
//    .set('name')
//    .set('sex')
//    .set('phonenum')
//    .set('email')
//    .set('idcardimage')
//    .set('companyname')
//    .set('companyplace')
//    .set('companyinfo')
//    .set('companyimage')
    .set('status')
//    .set('user')
//    .set('createtime')
    .set('isdeleted');
}

/**
 * 提交添加
 */
RecruiterInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/recruiter/add", function(data){
        Feng.success("添加成功!");
        window.parent.Recruiter.table.refresh();
        RecruiterInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.recruiterInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
RecruiterInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/recruiter/update", function(data){
        Feng.success("修改成功!");
        window.parent.Recruiter.table.refresh();
        RecruiterInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.recruiterInfoData);
    ajax.start();
}

$(function() {
	  //初始化简历状态选项
    $("#status").val($("#statusValue").val());
    $("#isdeleted").val($("#isdeletedValue").val());
});
