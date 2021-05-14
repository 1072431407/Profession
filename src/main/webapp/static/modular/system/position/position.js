/**
 * 兼职任务管理初始化
 */
var Position = {
    id: "PositionTable",	//表格id
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
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '名称', field: 'name', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '类型', field: 'typeName', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '人数', field: 'personnum', visible: true, align: 'center', valign: 'middle'},
            {title: '地点', field: 'place', visible: false, align: 'center', valign: 'middle',sortable: true},
            {title: '详情', field: 'information', visible: false, align: 'center', valign: 'middle'},
            {title: '薪水', field: 'salary', visible: false, align: 'center', valign: 'middle',sortable: true},
            {title: '联系方式', field: 'contact', visible: true, align: 'center', valign: 'middle'},
            {title: '类别', field: 'category', visible: false, align: 'center', valign: 'middle'},
            {title: '用户ID', field: 'user', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '删除标志', field: 'isDeleted', visible: true, align: 'center', valign: 'middle',sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Position.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Position.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加兼职任务
 */
Position.openAddPosition = function () {
    var index = layer.open({
        type: 2,
        title: '添加兼职任务',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/position/position_add'
    });
    this.layerIndex = index;
};

Position.launch=function(){
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '投放简历',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/position/position_launch/'+Position.seItem.id
        });
        this.layerIndex = index;
    }
}

Position.viewPosition=function(){
    if (this.check()) {
       location.href=Feng.ctxPath + '/position/view_position/'+Position.seItem.id;
    }
}
/**
 * 打开查看兼职任务详情
 */
Position.openPositionDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '兼职任务详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/position/position_update/' + Position.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除兼职任务
 */
Position.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/position/delete", function (data) {
            Feng.success("删除成功!");
            Position.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("positionId",this.seItem.id);
        ajax.start();
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
    var table = new BSTable(Position.id, "/position/list", defaultColunms);
    table.setPaginationType("client");
    Position.table = table.init();
});
