<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
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
        .layui-form-item .layui-input-company {width: auto;padding-right: 10px;line-height: 38px;}
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <input type="hidden" name="id" id="id" value="${sessionScope.user.id}">
        <input type="hidden" name="username" id="username" value="${sessionScope.user.username}">
        <input type="hidden" id="type" value="${sessionScope.type}" class="layui-input">
        <div class="layui-form layuimini-form">
            <div class="layui-form-item">
                <label class="layui-form-label required">旧的密码</label>
                <div class="layui-input-block">
                    <input type="password" name="oldPwd" id="oldPwd" lay-verify="required" lay-reqtext="旧密码不能为空" placeholder="请输入旧的密码"  value="" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label required">新的密码</label>
                <div class="layui-input-block">
                    <input type="password" name="newPwd" id="newPwd" lay-verify="required" lay-reqtext="新密码不能为空" placeholder="请输入新的密码"  value="" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">确认密码</label>
                <div class="layui-input-block">
                    <input type="password" name="password" id="againPwd" lay-verify="required" lay-reqtext="密码不能为空" placeholder="请输入新的密码"  value="" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$;

        form.on('submit(saveBtn)', function (data) {
            console.log(data)
            var datas=data.field;
            if (datas.newPwd != datas.password){
                layer.msg("两次输入的新密码不一致")
            }else{
                if (${sessionScope.type.equals("superAdmin")} || ${sessionScope.type.equals("admin")}){
                   updateAdminPwd(datas);
                }else{
                    updateReaderPwd(datas);
                }
            }
            return false;



        });
        function updateReaderPwd(datas) {
            let url="${pageContext.request.contextPath}/updateReaderPwd";
            let data="password="+datas.password+"&id="+$("#id").val();
            $.ajax({
                url:url,
                data:data,
                type:"post",
                dataType:"json",
                success:function (result) {
                    if (result){
                        layer.msg('修改成功',function(){
                            let index = parent.layer.getFrameIndex(window.name);
                            setTimeout(function () {parent.layer.close(index)},330);
                            parent.location.reload();
                        });

                    }else{
                        alert("修改失败");

                    }

                }
            })

        }

        function updateAdminPwd(datas) {
            let url="${pageContext.request.contextPath}/updateAdminPwd";
            let data="password="+datas.password+"&id="+$("#id").val();
            $.ajax({
                url:url,
                data:data,
                type:"post",
                dataType:"json",
                success:function (result) {
                    if (result){
                        layer.msg('修改成功',function(){
                            let index = parent.layer.getFrameIndex(window.name);
                            setTimeout(function () {parent.layer.close(index)},330);
                            parent.location.reload();
                        });

                    }else{
                        alert("修改失败");

                    }

                }
            })

        }
            $("#oldPwd").blur(function () {
                if (${sessionScope.type.equals("superAdmin")}||${sessionScope.type.equals("admin")}){
                    let url="${pageContext.request.contextPath}/checkOldPwd";
                    let data="oldPwd="+$(this).val()+"&username="+$("#username").val();
                    $.ajax({
                        url:url,
                        data:data,
                        type:"get",
                        dataType:"json",
                        success:function (result) {
                            if (result){
                                layer.msg("密码正确")
                            }else{
                                layer.msg("密码不正确")
                            }
                        },
                    })
                } else if(${sessionScope.type.equals("reader")}){
                    let url="${pageContext.request.contextPath}/checkOldPwdRea";
                    let data="oldPwd="+$(this).val()+"&username="+$("#username").val();
                    $.ajax({
                        url:url,
                        data:data,
                        type:"get",
                        dataType:"json",
                        success:function (result) {
                            if (result){
                                layer.msg("密码正确")
                            }else{
                                layer.msg("密码不正确")
                            }
                        },
                    })
                }

            })

    });


</script>
</body>
</html>