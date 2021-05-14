/**
 * 广告管理初始化
 */
var Evaluate = {
    id: "EvaluateTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Evaluate.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '标题', field: 'title', visible: true, align: 'center', valign: 'middle'},
            {title: '内容', field: 'content', visible: true, align: 'center', valign: 'middle'},
            {title: '评价者ID', field: 'user', visible: true, align: 'center', valign: 'middle'},
            {title: '职位', field: 'position', visible: true, align: 'center', valign: 'middle'},
            {title: '招聘者资料ID', field: 'recruiter', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle'},
            {title: '删除标志', field: 'isdeleted', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Evaluate.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Evaluate.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加广告
 */
Evaluate.openAddEvaluate = function () {
    var index = layer.open({
        type: 2,
        title: '添加广告',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/evaluate/evaluate_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看广告详情
 */
Evaluate.openEvaluateDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '广告详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/evaluate/evaluate_update/' + Evaluate.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除广告
 */
Evaluate.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/evaluate/delete", function (data) {
            Feng.success("删除成功!");
            Evaluate.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("evaluateId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询广告列表
 */
Evaluate.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Evaluate.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Evaluate.initColumn();
    var table = new BSTable(Evaluate.id, "/evaluate/list", defaultColunms);
    table.setPaginationType("client");
    Evaluate.table = table.init();
});
