<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>类型管理</title>
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
            类型名称：
            <div class="layui-inline">
                <input class="layui-input" name="name" id="name" autocomplete="off">
            </div>
            <button class="layui-btn" data-type="reload">搜索</button>
        </div>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add">添加</button>
                <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete">删除</button>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">修改</a>
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
            url: '${pageContext.request.contextPath}/typeAll',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50},
                //{field: 'id', width: 100, title: 'ID', sort: true},
                {field: 'name', width: 150, title: '类型名称'},
                {field: 'remarks', width: 200, title: '备注'},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            request:{
                pageName:'pageNum',
                limitName:'limit'
            },
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            skin: 'line',
            id:'testReload'
        });

        var $ = layui.$, active = {
            reload: function(){
                let name = $('#name').val();
                console.log(name)
                table.reload('testReload', {
                    page: {
                        curr: 1
                    }
                    ,where: {
                        name: name
                    }
                }, 'data');
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            let type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        table.on('tool(currentTableFilter)', function (obj) {
            let data=obj.data;
            if (obj.event === 'edit') {
                let index = layer.open({
                    title: '修改图书类型',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['60%', '60%'],
                    content: '${pageContext.request.contextPath}/queryTypeInfoById?id='+data.id,
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'delete') {
                layer.confirm('确定是否删除', function (index) {
                    deleteType(data.id);
                    layer.close(index);
                });
            }
        });

        table.on('checkbox(currentTableFilter)', function (obj) {
        });
        function deleteType(id){
            console.log(id)
            $.ajax({
                url:"deleteTypeById",
                type:"post",
                data: "id="+id,
                dataType: "json",
                success:function (result) {
                    if (result>0){
                        layer.msg("删除成功！",
                            {
                            icon:6,
                            time: 500
                            },function () {
                            let iframeIndex =parent.layer.getFrameIndex(window.name);
                            parent.layer.close(iframeIndex);
                            parent.location.reload();
                        })
                    }
                }
            })
        }
        function getCheckId(data){
            let arr=new Array();
            for(let i=0;i<data.length;i++){
                arr.push(data[i].id);
            }
            return arr.join(",");
        };

        function deleteInfoByIds(data){
            let ids = getCheckId(data);
            console.log(ids)
            $.ajax({
                url: "deleteTypeByIds",
                data:"ids="+ids,
                type:"post",
                dataType:"json",
                success:function (result) {
                    if (result>0){
                        layer.msg('删除成功',{
                            icon:6,
                            time: 500
                        },function () {
                            let iframeIndex=parent.layer.getFrameIndex(window.name);
                            parent,layer.close(iframeIndex);
                            parent.window.location.reload();
                        });
                    }else {
                        layer.msg("删除失败")
                    }
                }
            })

        };

        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {
                let index = layer.open({
                    title: '添加类型',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['60%', '60%'],
                    content: '${pageContext.request.contextPath}/typeAdd',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'delete') {
                let checkStatus=table.checkStatus(obj.config.id);
                let data=checkStatus.data;
                if(data.length==0){
                    layer.msg("请选择要删除的记录信息");
                }else{
                    layer.confirm('确定是否删除', function (index) {
                        console.log(data);
                        deleteInfoByIds(data);
                        layer.close(index);
                    });
                }
            }
        });

    });
</script>

</body>
</html>
