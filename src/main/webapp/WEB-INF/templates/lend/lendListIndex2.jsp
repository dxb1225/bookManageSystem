<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>借阅管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <div class="layuimini-main">
            <div class="demoTable">
                <div class="layui-form-item layui-form ">
                   <%-- 借书卡号：
                    <div class="layui-inline">
                        <input class="layui-input" name="readerNumber" id="readerNumber" autocomplete="off">
                    </div>--%>
                    图书名称：
                    <div class="layui-inline">
                        <input class="layui-input" name="name" id="name" autocomplete="off">
                    </div>
                    归还类型：
                    <div class="layui-inline">
                        <select class="layui-input" name="type" id="type">
                            <option value=""></option>
                            <option value="0">正常还书</option>
                            <option value="1">延迟还书</option>
                            <option value="2">破损还书</option>
                            <option value="3">丢失</option>
                        </select>
                    </div>
                    图书类型：
                    <div class="layui-inline">
                        <select class="layui-input" name="status" id="status">
                            <option value=""></option>
                            <option value="0">已归还</option>
                            <option value="1">在借中</option>
                        </select>
                    </div>
                    <button class="layui-btn" data-type="reload">搜索</button>
                </div>
            </div>
        </div>
        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 借阅 </button>
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="back"> 归还 </button>
                <%-- <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete"> 删除 </button>--%>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
        <script type="text/html" id="currentTableBar">
            {{# if(d.backDate==null){ }}
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">异常还书</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
            {{# }else{ }}
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
            {{# } }}
        </script>

    </div>
</div>
<script src="${pageContext.request.contextPath}/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url: '${pageContext.request.contextPath}/lendListAll2',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50},
                //{field: 'id', width: 100, title: 'ID', sort: true},
                {templet: '<div>{{d.bookInfo.name}}</a></div>', width: 140, title: '图书名称'},
                {templet: '<div>{{d.readerInfo.readerNumber}}</div>', width: 140, title: '借书卡号'},
                {templet: '<div><a href="javascript:void(0)" style="color:#00b7ee" lay-event="readerInfoEvent">{{d.readerInfo.realName}}</a></div>',
                    width: 140, title: '借阅人'},
                // {templet: '<div>{{d.reader.name}}</div>', width: 80, title: '借阅人'},
                {templet:"<div>{{layui.util.toDateString(d.lendDate,'yyyy-MM-dd HH:mm:ss')}}</div>", width: 180, title: '借阅时间'},
                {field: 'backDate', width: 180, title: '还书时间'},
                {title:"还书类型",minWidth: 140,templet:function(res){
                        if(res.backType=='0'){
                            return '<span class="layui-badge layui-bg-green">正常还书</span>'
                        }else if(res.backType=='1'){
                            return '<span class="layui-badge layui-bg-gray">延迟还书</span>'

                        }else if(res.backType=='2') {
                            return '<span class="layui-badge layui-bg-yellow">破损还书</span>'
                        }else if(res.backType=='3'){
                            return '<span class="layui-badge layui-bg-green">丢失图书</span>'
                        }else{
                            return '<span class="layui-badge layui-bg-red">在借中</span>'
                        }
                    }},
                /* {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}*/
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            skin: 'line',
            id:'testReload'
        });


        var $ = layui.$, active = {
            reload: function(){
                var name = $('#name').val();
                var readerNumber = $('#readerNumber').val();
                var backType = $('#backType').val();
                var status = $('#status').val();
                var type = $('#type').val();
                table.reload('testReload', {
                    page: {
                        curr: 1
                    }
                    ,where: {
                        name: name,
                        readerNumber:readerNumber,
                        backType:backType,
                        status:status,
                        type:type
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
            if (obj.event === 'edit') {
                var index = layer.open({
                    title: '异常还书',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: '${pageContext.request.contextPath}/excBackBook?id='+data.id+"&bookId="+data.bookId,
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'delete') {
                layer.confirm('确定是否删除', function (index) {
                    fun3();
                    layer.close(index);
                });
            }else if( obj.event === 'bookInfoEvent') {
                var bid=data.bookId;
                queryLookBookList("book",bid);
            }else{
                var rid=data.readerId;
                queryLookBookList("user",rid);
            }
        });

        function queryLookBookList(flag,id){
            var index = layer.open({
                title: '借阅时间线',
                type: 2,
                shade: 0.2,
                maxmin:true,
                shadeClose: true,
                area: ['60%', '60%'],
                content: '${pageContext.request.contextPath}/queryLookBookList?id='+id+"&flag="+flag
            });
            $(window).on("resize", function () {
                layer.full(index);
            });
        }

        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        function getCheackId(data){
            var arr=new Array();
            for(var i=0;i<data.length;i++){
                arr.push(data[i].id);
            }
            return arr.join(",");
        };

        function getCheackBookId(data){
            var arr=new Array();
            for(var i=0;i<data.length;i++){
                arr.push(data[i].bookId);
            }
            //拼接id
            return arr.join(",");
        };

        function fun3(){
            layer.msg("请联系QQ:1919066898 购买此系统");
        };

        function fun4(){
            layer.msg("请联系QQ:1919066898 购买此系统");
        };

        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {
                var index = layer.open({
                    title: '借阅书籍',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: '${pageContext.request.contextPath}/addLendList',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            }else if (obj.event === 'back'){
                var checkStatus=table.checkStatus(obj.config.id);
                var data=checkStatus.data;

                if(data.length==0){
                    layer.msg("请选择要借阅还书的记录信息");
                }else{
                    layer.confirm('确定还书吗', function (index) {
                        fun4();
                        layer.close(index);
                    });
                }
            } else if (obj.event === 'delete') {
                var checkStatus=table.checkStatus(obj.config.id);
                var data=checkStatus.data;
                if(data.length==0){
                    layer.msg("请选择要删除的记录信息");
                }else{
                    layer.confirm('确定是否删除', function (index) {
                        fun3();
                        layer.close(index);
                    });
                }
            }
        });

    });
</script>

</body>
</html>
