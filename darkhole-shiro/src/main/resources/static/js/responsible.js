/**
 * Created by Administrator on 2017/12/11.
 */


/**************************选择下拉框****************************/

function showMenu(dom) {
    $(dom).next('.menuContent').slideDown("fast");
    $("body").bind("mousedown", onBodyDown);
}
function hideMenu() {
    $(".menuContent").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown);
}
function onBodyDown(event) {
    if (!(event.target.class == "menuBtn" || event.target.class == "menuContent" || $(event.target).parents(".menuContent").length>0)) {
        hideMenu();
    }
}

var zNodes =[
    {id:4, pId:0, name:"保卫部", open:true, chkDisabled:true},
    {id:41, pId:4, name:"张三"},
    {id:42, pId:4, name:"李四"},
    {id:43, pId:4, name:"王五"},
    {id:44, pId:4, name:"赵六"},
    {id:5, pId:0, name:"办公室", open:true, chkDisabled:true},
    {id:51, pId:5, name:"员工1"},
    {id:52, pId:5, name:"员工2"},
    {id:53, pId:5, name:"员工3"},
    {id:54, pId:5, name:"员工4"},
    {id:6, pId:0, name:"财务部", open:true, chkDisabled:true},
    {id:61, pId:6, name:"人员1"},
    {id:62, pId:6, name:"人员2"},
    {id:63, pId:6, name:"人员3"},
    {id:64, pId:6, name:"人员4"}
];



/***************************单选 树*************************/
    var setting = {
        view: {
            dblClickExpand: false
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            beforeClick: beforeClick,
            onClick: onClick
        }
    };
/*********************************************多选  树*****************************************/

    var setting1 = {
    check: {
        enable: true,
        chkboxType: {"Y":"", "N":""}
    },
    view: {
        dblClickExpand: false
    },
    data: {
        simpleData: {
            enable: true
        }
    },
    callback: {
        beforeClick: beforeClick1,
        onCheck: onCheck
    }
};

    /******************************编辑  多选 树**************************************/

    var setting2= {
        check: {
            enable: true,
            chkboxType: {"Y":"", "N":""}
        },
        data: {
            key: {
                title: "t"
            },
            simpleData: {
                enable: true
            }
        },
        view: {
            dblClickExpand: false
        },
        callback: {
            beforeClick: beforeClick1,
            onCheck: onCheck
        }
    };


function beforeClick(treeId, treeNode) {
        var check = (treeNode && !treeNode.isParent);
        if (!check) {
            console.log('不能选择部门')
        }
        return check;
    }
    function onClick(e, treeId, treeNode) {
        $(e.target).parents('.menuContent').siblings('input').val(treeNode.name)
    }

    function beforeClick1(treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj(treeId);
        zTree.checkNode(treeNode, !treeNode.checked, null, true);
        return false;
    }

    function onCheck(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj(treeId),
            nodes = zTree.getCheckedNodes(true),
            v = "";
        for (var i=0, l=nodes.length; i<l; i++) {
            v += nodes[i].name + ",";
        }
        if (v.length > 0 ) v = v.substring(0, v.length-1);
        var cityObj = $("#"+treeId).parents('.menuContent').siblings('input');
        cityObj.val(v);
    }


/******************************编辑 树**************************************/


var nodeList = [];
function searchNode(treeId, value) {
    var s= [];
    var zTree = $.fn.zTree.getZTreeObj(treeId);
    for (var i =0;i<value.length;i++){
        nodeList = zTree.getNodesByParam('id', value[i]);
        updateNodes(true,treeId);
        s += nodeList[0].name + ","
    }
    if (s.length > 0 ) s = s.substring(0, s.length-1);
    var cityObj = $("#"+treeId).parents('.menuContent').siblings('input');
    cityObj.val(s);
}
function updateNodes(isCheck,treeId) {
    var zTree = $.fn.zTree.getZTreeObj(treeId);
    for( var i=0, l=nodeList.length; i<l; i++) {
        nodeList[i].checked = isCheck;
        zTree.updateNode(nodeList[i]);
    }
}





