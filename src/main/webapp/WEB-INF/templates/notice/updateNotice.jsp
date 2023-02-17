<!--<%@ page contentType="text/html;charset=UTF-8" language="java" %>-->
<!--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>-->
<!--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>-->
<!--<%@ page isELIgnored="false" %>-->
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>修改公告信息</title>
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
    <input type="hidden" name="id"  value="${info.id}">
    <div class="layui-form-item">
        <label class="layui-form-label">公告主题</label>
        <div class="layui-input-block">
            <input type="text" name="topic" readonly="true" value="${info.topic}" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">发布人</label>
        <div class="layui-input-block">
            <input type="text" name="author" readonly="true" value="${info.author}" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">公告内容</label>
        <div class="layui-input-block">
            <textarea name="content" readonly="true" class="layui-textarea" > ${info.content}</textarea>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$;

        form.on('submit(saveBtn)', function () {
            layer.msg("请联系QQ:1919066898 购买此系统");
        });
    });
</script>
</body>
</html>
