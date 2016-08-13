<%@ page import="com.cyan.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: cyan
  Date: 16/7/10
  Time: 13:11
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
    <title>新课程信息</title>
    <style>
        body {
            padding-top: 100px;
            padding-bottom: 40px;
            background-color: #eee;
        }

        form {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
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
                <li><a href="/adminIndex">主页</a></li>
                <li ><a href="/studentManage">学生管理</a></li>
                <li class="active"><a href="/courseManage">课程管理</a></li>
                <li><a href="/chooseManage">选课管理</a> </li>
                <li><a href="/index">返回学生版主页</a></li>
            </ul>
        </div><!--/.nav-collapse -->

    </div>
</nav>

<div class="container">
    <form action="/addCourse" method="post">
        <h3>新课程信息</h3>
        <div class="form-group">
            <label for="name">课程名</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="课程名" required>
        </div>
        <div class="form-group">
            <label for="time">开课学期</label>
            <input type="text" class="form-control" id="time" name="time" placeholder="开课学期" required>
        </div>
        <div class="form-group">
            <label for="credit">课程学分</label>
            <input type="text" class="form-control" id="credit" name="credit" placeholder="课程学分" required>
        </div>
        <div class="form-group">
            <label for="belong">所属社团</label>
            <input type="text" class="form-control" id="belong" name="belong" placeholder="所属社团" required>
        </div>
        <div class="form-group">
            <label for="place">开课地点</label>
            <input type="text" class="form-control" id="place" name="place" placeholder="开课地点" required>
        </div>
        <div class="form-group">
            <label for="amount">课程容量</label>
            <input type="text" class="form-control" id="amount" name="amount" placeholder="课程容量" required>
        </div>
        <div class="form-group">
            <label for="detail">课程描述</label>
            <input type="text" class="form-control" id="detail" name="detail" placeholder="课程描述" required>
        </div>
        <button type="submit" class="btn btn-success">提交</button>
        <a href="/courseManage" class="btn btn-default">返回</a>
    </form>
</div>
</body>
</html>
