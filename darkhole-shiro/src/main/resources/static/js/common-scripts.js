
$(function () {
    $('#nav-accordion').dcAccordion({
        eventType: 'click',
        autoClose: true,
        saveState: true,
        disableLink: true,
        speed: 300,
        showCount: false,
        autoExpand: true,
        classExpand: 'dcjq-current-parent'
    });
});
var Script = function () {
'use strict';
    jQuery('#sidebar .sub-menu > a').click(function () {
        var o = ($(this).offset());
     //   diff = 250 - o.top;
		 var offset = o.top - $('#sidebar').height() / 2;
		 offset=offset+150;
		// alert(offset);
		$('#sidebar').animate({scrollTop: offset}, 500);
       
    });
    $(function () {
        function responsiveView() {
            var wSize = $(window).width();
            if (wSize <= 768) {
                $('#container').addClass('sidebar-close');
                $('#sidebar > ul').hide();
            }
            if (wSize > 768) {
                $('#container').removeClass('sidebar-close');
                $('#sidebar > ul').show();
            }
        }
        $(window).on('load', responsiveView);
        $(window).on('resize', responsiveView);
    });
    $('.fa-bars').click(function () {
        if ($('#sidebar > ul').is(":visible") === true) {
            $('#main-content').css({
                'margin-left': '0px'
            });
            $('#sidebar').css({
                'margin-left': '-210px'
            });
            $('#sidebar > ul').hide();
            $("#container").addClass("sidebar-closed");
        } else {
            $('#main-content').css({
                'margin-left': '210px'
            });
            $('#sidebar > ul').show();
            $('#sidebar').css({
                'margin-left': '0'
            });
            $("#container").removeClass("sidebar-closed");
        }
    });
    jQuery('.panel .tools .fa-chevron-down').click(function () {
        var el = jQuery(this).parents(".panel").children(".panel-body");
        if (jQuery(this).hasClass("fa-chevron-down")) {
            jQuery(this).removeClass("fa-chevron-down").addClass("fa-chevron-up");
            el.slideUp(200);
        } else {
            jQuery(this).removeClass("fa-chevron-up").addClass("fa-chevron-down");
            el.slideDown(200);
        }
    });
    jQuery('.panel .tools .fa-times').click(function () {
        jQuery(this).parents(".panel").parent().remove();
    });
    $('.tooltips').tooltip();
    $('.popovers').popover();
    if ($(".custom-bar-chart")) {
        $(".bar").each(function () {
            var i = $(this).find(".value").html();
            $(this).find(".value").html("");
            $(this).find(".value").animate({
                height: i
            }, 2000)
        })
    }
    iframe('.sub-menu li', $('#main-content'));

    $('.head-nav li').click(function () {
        $(this).attr('class','active').siblings().attr('class','hh')
    });

    // (function ($) {
    //     // 获取url中的id
    //     $.getUrlParam = function (name) {
    //         var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    //         var r = window.location.search.substr(1).match(reg);
    //         if (r !== null) {
    //             return decodeURI(r[2]);
    //         }
    //         return null;
    //     }
    //     $.jump = function () {
    //         //获取url中的参数
    //         var id = $.getUrlParam("id");
    //         var arr = [];
    //         for (var i=0;i<$('.sub-menu').length;i++){
    //             arr.push($('.sub-menu').eq(i).attr('id'))
    //         }
    //         for(var j =0;j<arr.length;j++) {
    //             if(id===arr[j]){
    //                 $('#'+arr[j]+ '>a').attr('class',"active");
    //                 $('#'+arr[j]+ '>ul').attr('display','block');
    //                 $('#main-content').load($('#'+arr[j]+' ul li a').eq(0).attr('target'))
    //             }
    //         }
    //     }
    // })(jQuery);

    // $.jump()
}();
// 提示
toastr.options = {
    "closeButton": false, //是否显示关闭按钮
    "debug": false, //是否使用debug模式
    "progressBar":false,
    "positionClass": "toast-top-center",//弹出窗的位置
    "showDuration": "300",//显示的动画时间
    "hideDuration": "300",//消失的动画时间
    "timeOut": "3000", //展现时间
    "extendedTimeOut": "1000",//加长展示时间
    "showEasing": "swing",//显示时的动画缓冲方式
    "hideEasing": "linear",//消失时的动画缓冲方式
    "showMethod": "fadeIn",//显示时的动画方式
    "hideMethod": "fadeOut" //消失时的动画方式
};
// //控件切换
// function controlToggle( dom ) {
//     var $dom = $(dom);
//     var _control = $dom.parent();
//     _control.attr('style','display: none;');
//     if(_flag === '+'){
//         _control.next('.input-group').removeAttr('style');
//         _control.children('input').val('')
//     }
//     if(_flag === '-'){
//         _control.prev('.input-group').removeAttr('style');
//         _control.children('input').val('')
//     }
// }

