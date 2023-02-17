<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>修改密码</title>
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
    <input type="hidden" name="id" value="${admin.id}">
    <input type="hidden" name="password" value="${admin.password}">
    <div class="layui-form-item">
        <label class="layui-form-label required">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="username" lay-verify="required"  value="${admin.username}" autocomplete="off" placeholder="请输入用户名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">管理员类型</label>
        <div class="layui-input-block">
            <select name="adminType" id="adminType" lay-verify="required">
                <option value="${admin.adminType}">请选择</option>
            </select>
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
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$;

        $.get("findAllList",{},function (data) {
            var adminType=$('#adminType')[0].value;
            var list = [{name:"超级管理员",id:"1"},{name:"普通管理员",id:"0"}];
            var select=document.getElementById("adminType");
            if(list!=null|| list.size()>0){
                for(var c in list){
                    var option=document.createElement("option");
                    option.setAttribute("value",list[c].id);
                    option.innerText=list[c].name;
                    select.appendChild(option);
                    if (list[c].id==adminType){
                        option.setAttribute("selected","selected");
                        layui.form.render('select');
                    }
                }
            }
            form.render('select');
        },"json")

        form.on('submit(saveBtn)', function () {
            layer.msg("请联系QQ:1919066898 购买此系统");
        });
    });
</script>
</body>
</html>
