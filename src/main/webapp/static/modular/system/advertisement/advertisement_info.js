/**
 * 初始化广告管理详情对话框
 */
var AdvertisementInfoDlg = {
    advertisementInfoData : {}
};

/**
 * 清除数据
 */
AdvertisementInfoDlg.clearData = function() {
    this.advertisementInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AdvertisementInfoDlg.set = function(key, val) {
    this.advertisementInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AdvertisementInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
AdvertisementInfoDlg.close = function() {
    parent.layer.close(window.parent.Advertisement.layerIndex);
}

/**
 * 收集数据
 */
AdvertisementInfoDlg.collectData = function() {
	layer.msg($("#imageUrlValue").val())
	this.advertisementInfoData['imageurl'] = $("#imageUrlValue").val();
	this
    .set('id')
    .set('title')
    .set('status')
    .set('isdeleted');
}

/**
 * 提交添加
 */
AdvertisementInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/advertisement/add", function(data){
        Feng.success("添加成功!");
        window.parent.Advertisement.table.refresh();
        AdvertisementInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.advertisementInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
AdvertisementInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/advertisement/update", function(data){
        Feng.success("修改成功!");
        window.parent.Advertisement.table.refresh();
        AdvertisementInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.advertisementInfoData);
    ajax.start();
}

$(function() {
	$("#status").val($("#statusValue").val());
    $("#isdeleted").val($("#isdeletedValue").val());
});
