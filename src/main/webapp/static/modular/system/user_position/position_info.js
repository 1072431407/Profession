/**
 * 初始化兼职任务详情对话框
 */
var PositionInfoDlg = {
    positionInfoData: {}
};

/**
 * 清除数据
 */
PositionInfoDlg.clearData = function () {
    this.positionInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PositionInfoDlg.set = function (key, val) {
    this.positionInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PositionInfoDlg.get = function (key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
PositionInfoDlg.close = function () {
    parent.layer.close(window.parent.Position.layerIndex);
}

/**
 * 收集数据
 */
PositionInfoDlg.collectData = function () {
    this.set('id')
        .set('name')
        .set('type')
        .set('personnum')
        .set('place')
        .set('information')
        .set('salary')
        .set('contact')
        .set('category')
        .set('isdeleted');
};

/**
 * 提交添加
 */
PositionInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/position/add", function (data) {
        Feng.success("添加成功!");
        window.parent.Position.table.refresh();
        PositionInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.positionInfoData);
    ajax.start();
}

PositionInfoDlg.putIn=function(){
   var id=$("#lanuch").val();
    $.ajax({
        type: 'POST',
        url: '../../position_launch',
        dataType: 'json',
        async: false,
        data:{id:id} ,
        success: function(data) {
          if(data.code==200){
              layer.msg("投放简历成功!");
              PositionInfoDlg.close();
          }else{
              layer.msg(data.msg);
          }
        },
        error: function(data) {

        }
    });
}

/**
 * 提交修改
 */
PositionInfoDlg.editSubmit = function () {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/position/update", function (data) {
        Feng.success("修改成功!");
        window.parent.Position.table.refresh();
        PositionInfoDlg.close();
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.positionInfoData);
    ajax.start();
}

$(function () {
    $("#isdeleted").val($("#isdeletedValue").val());
});
