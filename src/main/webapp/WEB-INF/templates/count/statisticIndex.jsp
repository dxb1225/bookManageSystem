<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>统计数据</title>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-min">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div id="main" style="width: 100%;min-height:500px"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>

    var sum = 0;
    <c:forEach items="${list}" var="type">
        sum = sum + ${type.counts}
    </c:forEach>

    layui.use(['layer', 'miniTab','echarts'], function () {
        var $ = layui.jquery,
            layer = layui.layer,
            miniTab = layui.miniTab,
            echarts = layui.echarts;


        layui.use(['echarts'], function () {
            var echarts = layui.echarts,
                $ = layui.jquery;
            console.log(echarts);
            var myChart = echarts.init(document.getElementById('main'));
            var option = {
                series : [
                    {
                        name: '访问来源',
                        type: 'pie',
                        radius: '55%',
                        data:[
                            <c:forEach items="${list}" var="type">
                            {value:${type.counts}, name:'${type.name}' + Math.floor(${type.counts}/sum*10000)/100 + '%'},
                            </c:forEach>
                        ],

                        roseType: 'angle',
                        itemStyle: {
                            normal: {
                                shadowBlur: 200,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };
            myChart.setOption(option);
        });
    });
</script>
</body>
</html>