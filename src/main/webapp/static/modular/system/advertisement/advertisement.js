/**
 * 广告管理管理初始化
 */
var Advertisement = {
    id: "AdvertisementTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Advertisement.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '标题', field: 'title', visible: true, align: 'center', valign: 'middle'},
            {title: '图片地址', field: 'imageurl', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'statusName', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle'},
            {title: '删除标志', field: 'isDeleted', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Advertisement.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Advertisement.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加广告管理
 */
Advertisement.openAddAdvertisement = function () {
    var index = layer.open({
        type: 2,
        title: '添加广告管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/advertisement/advertisement_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看广告管理详情
 */
Advertisement.openAdvertisementDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '广告管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/advertisement/advertisement_update/' + Advertisement.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除广告管理
 */
Advertisement.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/advertisement/delete", function (data) {
            Feng.success("删除成功!");
            Advertisement.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("advertisementId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询广告管理列表
 */
Advertisement.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Advertisement.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Advertisement.initColumn();
    var table = new BSTable(Advertisement.id, "/advertisement/list", defaultColunms);
    table.setPaginationType("client");
    Advertisement.table = table.init();
});
