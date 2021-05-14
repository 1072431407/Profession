/**
 * 简历管理初始化
 */
var Resume = {
    id: "ResumeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Resume.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'ID', field: 'id', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '姓名', field: 'name', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '性别', field: 'sexName', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '出生年月', field: 'birthday', visible: false, align: 'center', valign: 'middle',sortable: true},
            {title: '电话号码', field: 'phonenum', visible: true, align: 'center', valign: 'middle'},
            {title: 'Email', field: 'email', visible: false, align: 'center', valign: 'middle'},
            {title: '学校名称', field: 'schoolname', visible: true, align: 'center', valign: 'middle'},
            {title: '入学时间到毕业时间', field: 'time', visible: false, align: 'center', valign: 'middle'},
            {title: '学历', field: 'education', visible: true, align: 'center', valign: 'middle'},
            {title: '专业', field: 'major', visible: false, align: 'center', valign: 'middle'},
            {title: '工作经验', field: 'experience', visible: false, align: 'center', valign: 'middle'},
            {title: '求职意向', field: 'jobintension', visible: false, align: 'center', valign: 'middle'},
            {title: '求职类型', field: 'typeName', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '用户id', field: 'user', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '状态', field: 'statusName', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle',sortable: true},
            {title: '删除标记', field: 'isDeleted', visible: true, align: 'center', valign: 'middle',sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Resume.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Resume.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加简历
 */
Resume.openAddResume = function () {
    var index = layer.open({
        type: 2,
        title: '添加简历',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/resume/resume_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看简历详情
 */
Resume.updateResume = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '编辑简历',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/resume/resume_update/' + Resume.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 打开查看简历详情
 */
Resume.openResumeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '简历详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/resume/resume_detail/' + Resume.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除简历
 */
Resume.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/resume/delete", function (data) {
            Feng.success("删除成功!");
            Resume.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("resumeId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询简历列表
 */
Resume.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Resume.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Resume.initColumn();
    var table = new BSTable(Resume.id, "/resume/list", defaultColunms);
    table.setPaginationType("client");
    Resume.table = table.init();
});
