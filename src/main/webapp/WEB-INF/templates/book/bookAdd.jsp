<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>添加图书</title>
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
    <div class="layui-form-item">
        <label class="layui-form-label required">图书名称</label>
        <div class="layui-input-block">
            <input type="text" name="name" lay-verify="required" lay-reqtext="图书名称不能为空" placeholder="请输入图书名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">ISBN</label>
        <div class="layui-input-block">
            <input type="text" name="isbn" lay-verify="required" lay-reqtext="ISBN不能为空" placeholder="请输入ISBN" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">图书类别</label>
        <div class="layui-input-block">
            <select name="typeId" id="typeId" lay-verify="required" lay-reqtext="图书类别不能为空" >
                <option value="">请选择</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">图书作者</label>
        <div class="layui-input-block">
            <input type="text" name="author" lay-verify="required" lay-reqtext="图书作者不能为空" placeholder="请输入图书作者" class="layui-input" autocomplete="off">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">图书出版社</label>
        <div class="layui-input-block">
            <input type="text" name="publish" lay-verify="required" lay-reqtext="图书出版社不能为空" placeholder="请输入图书出版社"  class="layui-input" autocomplete="off">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">图书语言</label>
        <div class="layui-input-block">
            <input type="text" name="language" autocomplete="off" lay-verify="required" placeholder="请输入图书语言" lay-reqtext="图书语言不能为空" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">图书价格</label>
        <div class="layui-input-block">
            <input type="number" name="price" autocomplete="off" lay-verify="required" lay-reqtext="图书价格不能为空" placeholder="请输入图书价格" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">出版日期</label>
        <div class="layui-input-block">
            <input type="text" name="publishDate" id="date" lay-verify="date" autocomplete="off" placeholder="请输入出版日期" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">图书介绍</label>
        <div class="layui-input-block">
            <textarea name="introduction" class="layui-textarea" placeholder="请输入介绍信息"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form','laydate'], function () {
        var form = layui.form,
            layer = layui.layer,
            laydate=layui.laydate,
            $ = layui.$;

        laydate.render({
            elem: '#date',
            trigger:'click'
        });

        $.get("findAllList",{},function (data) {
            var list=data;
            var select=document.getElementById("typeId");
            if(list!=null|| list.size()>0){
                for(var c in list){
                    var option=document.createElement("option");
                    option.setAttribute("value",list[c].id);
                    option.innerText=list[c].name;
                    select.appendChild(option);
                }
            }
            form.render('select');
        },"json")

        form.on('submit(saveBtn)', function (data) {
            let url="${pageContext.request.contextPath}/bookAdd";
            $.post(url,data.field,function (result){
                if (result==1){
                    layer.msg('新增成功',function(){
                        let index = parent.layer.getFrameIndex(window.name);
                        setTimeout(function () {parent.layer.close(index)},330);
                        parent.location.reload();
                        });

                }else{
                    alert("新增失败");

                }


            },
            "json");
        });
    });
</script>
</body>
</html>

