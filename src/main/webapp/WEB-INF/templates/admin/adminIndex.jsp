<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>管理员管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css" media="all">
    <script src="${pageContext.request.contextPath}/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <div class="demoTable">
            <div class="layui-form-item layui-form">
                用户名：
                <div class="layui-inline">
                    <input class="layui-input" name="username" id="username" autocomplete="off">
                </div>
                管理员类型：
                <div class="layui-inline">
                    <select id="adminType" name="adminType" class="layui-input">
                        <option value="">请选择</option>
                        <option value="0">普通管理员</option>
                        <option value="1">超级管理员</option>
                    </select>
                </div>
                <button class="layui-btn" data-type="reload">搜索</button>
            </div>
        </div>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加 </button>
                <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete"> 删除 </button>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="update">修改</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>

    </div>
</div>

<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url: '${pageContext.request.contextPath}/adminAll',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50},
                //{field: 'id', width: 100, title: 'ID', sort: true},
                {field: 'username', width: 150, title: '用户名'},
                {field: 'adminType', width: 200, title: '管理员类型',templet:function (res) {
                        if (res.adminType == '0'){
                            return '<span class="layui-btn layui-btn-normal layui-btn-xs">普通管理员</span>';
                        }else{
                            return '<span class="layui-btn layui-btn-normal layui-btn-xs" style="background-color: orangered;">超级管理员</span>';
                        }
                    }},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            skin: 'line',
            id:'testReload'
        });

        var $ = layui.$, active = {
            reload: function(){
                var username = $('#username').val();
                var adminType = $('#adminType').val();
                console.log(name)
                table.reload('testReload', {
                    page: {
                        curr: 1
                    }
                    ,where: {
                        username: username,
                        adminType:adminType
                    }
                }, 'data');
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data=obj.data;
            if (obj.event === 'update') {
                var index = layer.open({
                    title: '修改管理员信息',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['60%', '60%'],
                    content: '${pageContext.request.contextPath}/queryAdminById?id='+data.id,
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'delete') {
                layer.confirm('确定是否删除', function (index) {
                    deleteAdmin(data.id);
                    layer.close(index);
                });
            }
        });

        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        function getCheckId(data){
            var arr=new Array();
            for(var i=0;i<data.length;i++){
                arr.push(data[i].id);
            }
            return arr.join(",");
        };

        function deleteAdmin(id){
            console.log(id);
            $.ajax({
                url:"deleteAdmin",
                type:"post",
                data:"id="+id,
                dataType:"json",
                success:function (result) {
                    if (result>0){
                        layer.msg("删除成功!",function () {
                            let index = parent.layer.getFrameIndex(window.name);
                            setTimeout(function () {parent.layer.close(index)},330,);
                            parent.location.reload();
                        })
                    }else{
                        layer.msg("删除失败!");
                    }
                }
            })
        }

        function fun1(data){
            let ids = getCheckId(data);
            $.ajax({
                url:"deleteAdminByIds",
                data:{ids:ids},
                type:"post",
                dataType: "json",
                success:function (result) {
                    if (result>0) {
                        layer.msg("删除成功!", {icon: 6, time: 500}, function () {
                            parent.location.reload();
                            let iframeIndex = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(iframeIndex);
                        })
                    }else{
                        layer.msg("删除失败!",{icon:5,time:500})
                    }
                }
            })
        };

        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {
                var index = layer.open({
                    title: '添加管理员',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['60%', '60%'],
                    content: '${pageContext.request.contextPath}/adminAdd',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'delete') {
                var checkStatus=table.checkStatus(obj.config.id);
                var data=checkStatus.data;
                if(data.length==0){
                    layer.msg("请选择要删除的记录信息");
                }else{
                    layer.confirm('确定是否删除', function (index) {
                        fun1(data);
                        layer.close(index);
                    });
                }
            }
        });

    });
</script>

</body>
</html>
