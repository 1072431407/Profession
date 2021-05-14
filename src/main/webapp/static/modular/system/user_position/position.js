/**
 * 兼职任务管理初始化
 */
var Position = {
    id: "UserPositionTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Position.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle', sortable: true},
        {title: '申请人姓名', field: 'username', visible: true, align: 'center', valign: 'middle', sortable: true},
        {title: '求职意向', field: 'intention', visible: true, align: 'center', valign: 'middle', sortable: true},
        {title: '简历Id', field: 'resume', visible: true, align: 'center', valign: 'middle'},
        {title: '应聘职位Id', field: 'position_id', visible: true, align: 'center', valign: 'middle'},
        {title: '申请状态', field: 'status', visible: true, align: 'center', valign: 'middle', sortable: true},
        {title: '创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle', sortable: true},
    ];
};

/**
 * 检查是否选中
 */
Position.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        Position.seItem = selected[0];
        return true;
    }
};

/**
 * 查询兼职任务列表
 */
Position.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Position.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Position.initColumn();
    var table = new BSTable(Position.id, "/userPosition/list", defaultColunms);
    table.setPaginationType("client");
    Position.table = table.init();
});
