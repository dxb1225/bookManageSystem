<!--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>-->
<!--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>-->
<!--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>-->
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>借书</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css" media="all">
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div class="layui-form layuimini-form">
    <div class="demoTable">
        <div class="layui-form-item" style="margin-left: 78px">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ISBN：
            <div class="layui-inline">
                <input class="layui-input" name="isbn" id="isbn" autocomplete="off">
            </div>
            图书名称：
            <div class="layui-inline">
                <input class="layui-input" name="name" id="name" autocomplete="off">
            </div>
            图书分类：
            <div class="layui-inline">
                <select id="typeId" name="typeId">
                    <option value="">请选择</option>
                </select>
            </div>
            <button class="layui-btn" data-type="reload">搜索</button>
        </div>

    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">图书列表</label>
        <div class="layui-input-block">
            <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">借书卡号</label>
        <div class="layui-input-block">
            <input type="text" name="readerNumber" lay-verify="required" lay-reqtext="借书卡不能为空" placeholder="请输入借书卡" value="" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认借书</button>
        </div>
    </div>

</div>
<script src="${pageContext.request.contextPath}/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table'], function(){
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;
        $.get("findAllList",{},function (data) {
            var list=data;
            var select=document.getElementById("typeId");
            if(list!=null|| list.size()>0){
                for(var obj in list){
                    var option=document.createElement("option");
                    option.setAttribute("value",list[obj].id);
                    option.innerText=list[obj].name;
                    select.appendChild(option);
                }
            }
            form.render('select');
        },"json")

        table.render({
            elem: '#currentTableId',
            url: '${pageContext.request.contextPath}/bookAll',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50},
                //{field: 'id', width: 100, title: 'ID', sort: true},
                {field: 'isbn', width: 140, title: 'ISBN'},
                {field: 'name', width: 140, title: '图书名称'},
                {field: 'author', width: 140, title: '作者'},
                {templet:'<div>{{d.typeInfo.name}}</div>',width:140,title:'图书类型'},
                {field: 'publish', width: 160, title: '出版社'},
                {field: 'publishDate', width: 140, title: '出版时间',templet: "<div>{{layui.util.toDateString(d.publishDate,'yyyy-MM-dd')}}</div>"},
                {field: 'language', width: 140, title: '语言'},
                {field: 'price', width: 140, title: '价格'},
                {field: 'status', width: 140, title: '书籍状态'},
                //{title: '', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            done: function(){
                $("[data-field='status']").children().each(function(){
                    if ($(this).text() != '书籍状态'){
                        if($(this).text()=='1'){
                            $(this).text("不可借阅")
                        }else {
                            $(this).text("可借阅")
                        }
                    }
                });
            },
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            skin: 'line',
            id:'testReload'
        });
        var $ = layui.$, active = {
            reload: function(){
                var name = $('#name').val();
                var isbn = $('#isbn').val();
                var typeId = $('#typeId').val();
                console.log(name)
                table.reload('testReload', {
                    page: {
                        curr: 1
                    }
                    ,where: {
                        name: name,
                        isbn:isbn,
                        typeId:typeId
                    }
                }, 'data');
            }
        };
        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        function getCheackId(data){
            var arr=new Array();
            for(var i=0;i<data.length;i++){
                arr.push(data[i].id);
            }
            return arr.join(",");
        };

        form.on('submit(saveBtn)', function () {
            fun5();
        });

        function fun5(){
            layer.msg("请联系QQ:1919066898 购买此系统");
        };
    });
</script>
</body>
</html>
