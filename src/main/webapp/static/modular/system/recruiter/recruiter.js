/**
 * 招聘者管理初始化
 */
var Recruiter = {
    id: "RecruiterTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Recruiter.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '姓名', field: 'name', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '性别', field: 'sexName', visible: false, align: 'center', valign: 'middle',sortable: true},
            {title: '电话号码', field: 'phonenum', visible: true, align: 'center', valign: 'middle'},
            {title: 'Email', field: 'email', visible: false, align: 'center', valign: 'middle'},
            {title: '身份证图片', field: 'idcardimage', visible: false, align: 'center', valign: 'middle'},
            {title: '公司名称', field: 'companyname', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '公司地址', field: 'companyplace', visible: false, align: 'center', valign: 'middle'},
            {title: '公司介绍', field: 'companyinfo', visible: false, align: 'center', valign: 'middle'},
            {title: '营业执照图片', field: 'companyimage', visible: false, align: 'center', valign: 'middle'},
            {title: '状态', field: 'statusName', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '用户ID', field: 'user', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '删除标志', field: 'isDeleted', visible: true, align: 'center', valign: 'middle',sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Recruiter.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Recruiter.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加招聘者
 */
Recruiter.openAddRecruiter = function () {
    var index = layer.open({
        type: 2,
        title: '添加招聘者',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/recruiter/recruiter_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看招聘者详情
 */
Recruiter.openRecruiterDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '招聘者详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/recruiter/recruiter_update/' + Recruiter.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除招聘者
 */
Recruiter.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/recruiter/delete", function (data) {
            Feng.success("删除成功!");
            Recruiter.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("recruiterId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询招聘者列表
 */
Recruiter.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Recruiter.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Recruiter.initColumn();
    var table = new BSTable(Recruiter.id, "/recruiter/list", defaultColunms);
    table.setPaginationType("client");
    Recruiter.table = table.init();
});
