<%--
  Created by IntelliJ IDEA.
  User: cyan
  Date: 16/7/8
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- Bootstrap core CSS -->
    <link href="static/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
    <title>管理页面</title>
    <link rel="stylesheet" href="static/css/bamboo.css">
    <script src="static/js/jquery-3.0.0.min.js"></script>
    <script src="static/js/bamboo.0.1.js"></script>
</head>
<body>
<%
    if (session.getAttribute("id") == null) {
        request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
    }

%>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">学生社团管理系统</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/adminIndex">主页</a></li>
                <li><a href="/studentManage">学生管理</a></li>
                <li><a href="/courseManage">课程管理</a></li>
                <li><a href="/chooseManage">选课管理</a></li>
                <li><a href="/index">返回学生版主页</a></li>
            </ul>
        </div><!--/.nav-collapse -->

    </div>
</nav>

<div class="container" style="margin-top: 150px">

    <div id="chart" class="chart" style="width:100%;height:450px;"></div>

</div>

<script src="static/js/jquery-3.0.0.min.js"></script>
<script src="static/js/echarts.min.js"></script>
<script>
    var myChart = echarts.init(document.getElementById('chart'));

    var option = {
        title: {
            text: '课程选课统计表'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data: ['已选人数', '可选人数']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'value'
        },
        yAxis: {
            type: 'category',
            data: <%=session.getAttribute("listX")%>
        },
        series: [
            {
                name: '已选人数',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: <%=session.getAttribute("listSelected")%>
            },
            {
                name: '可选人数',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: <%=session.getAttribute("listLeft")%>
            }
        ]
    };

    myChart.setOption(option);
    window.onresize = myChart.resize;
    window.onload = myChart.resize;

</script>

</body>
</html>
