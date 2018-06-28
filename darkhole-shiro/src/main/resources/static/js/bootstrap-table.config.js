/**
 * Created by timidus on 2016/12/21.
 */
;(function ($){
    $.fn.bootstrapTable.defaults.classes = 'table table-condensed';//紧缩表
    $.fn.bootstrapTable.defaults.striped = true;//斑马表
    $.fn.bootstrapTable.defaults.cache = false;//禁用缓存
    $.fn.bootstrapTable.defaults.pagination = true;//显示分页
    $.fn.bootstrapTable.defaults.pageSize = 10;
    $.fn.bootstrapTable.defaults.toolbar = '#toolbar';//设置工具栏
    $.fn.bootstrapTable.defaults.locale = 'zh-CN';//汉字
    $.fn.bootstrapTable.defaults.undefinedText = '***';//默认数据
    $.fn.bootstrapTable.defaults.paginationPreText = '上一页';
    $.fn.bootstrapTable.defaults.paginationNextText = '下一页';
    $.fn.bootstrapTable.defaults.iconsPrefix = 'fa';
    $.fn.bootstrapTable.defaults.icons = {
        paginationSwitchDown: 'fa-bars fa-fw',
        paginationSwitchUp: 'fa-bars fa-fw',
        refresh: 'fa-refresh fa-fw',
        toggle: 'fa-th-list fa-fw',
        columns: 'fa-ellipsis-v fa-fw',
        detailOpen: 'fa-plus-square fa-fw fa-2x',
        detailClose: 'fa-minus-square fa-fw fa-2x'
    };
    $.fn.bootstrapTable.defaults.sortable = true;//开启排序
    $.fn.bootstrapTable.defaults.filter = true;//开启过滤
    $.fn.bootstrapTable.defaults.search = false;//开启（前端）搜索
    $.fn.bootstrapTable.defaults.showExport = true;//开启导出
    $.fn.bootstrapTable.defaults.exportDataType = "basic";
    $.fn.bootstrapTable.defaults.showRefresh = false;
    $.fn.bootstrapTable.defaults.showColumns = false;
    $.fn.bootstrapTable.defaults.detailView = false;//开启子表
    $.fn.bootstrapTable.defaults.detailFormatter = function (index, row) {
        return "";
    };
    //$.fn.bootstrapTable.defaults.onLoadSuccess = function (data) {
    //    //...
    //    return false;
    //};
    //$.fn.bootstrapTable.defaults.onClickRow = function (item, $element) {
    //    //...
    //    return false;
    //};
})(jQuery);
