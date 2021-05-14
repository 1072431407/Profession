/**
 * 兼职任务管理初始化
 */
var Position = {
    id: "ViewPositionTable",	//表格id
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

function Review(){
    var review=null;
    var selected = $("#ViewPositionTable").bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return;
    }else{
        review= selected[0];
    }
    $.ajax({
        type: 'POST',
        url: '/userPosition/review',
        dataType: 'json',
        async: false,
        data:{id:review.id} ,
        success: function(data) {
            if(data.code==200){
                layer.msg("审阅成功!");
              window.location.reload();
            }else{
                layer.msg(data.msg);
            }
        },
        error: function(data) {

        }
    });
}

function ResumeDetail(){
    var review=null;
    var selected = $("#ViewPositionTable").bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return;
    }else{
        review= selected[0];
    }
    var index = layer.open({
        type: 2,
        title: '简历详情',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/resume/view_resume_detail/' + review.resume
    });
}


$(function () {
    var defaultColunms = Position.initColumn();
    var pid=$("#view-pid").val();
    var table = new BSTable(Position.id, "/userPosition/view_list?id="+pid, defaultColunms);
    table.setPaginationType("client");
    Position.table = table.init();
});
