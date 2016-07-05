<%--
  Created by IntelliJ IDEA.
  User: cyan
  Date: 16/7/5
  Time: 11:19
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

    <title>用户登陆</title>
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">学生社团管理系统</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">主页</a></li>
                <li><a href="#about">所有课程</a></li>
                <li><a href="#contact">我的课程</a></li>
                <li><a href="#contact">关于我们</a></li>
            </ul>
                <form class="navbar-form navbar-right" action="/login" method="post">
                    <div class="form-group">
                        <input type="text" placeholder="学号" class="form-control" name="id">
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="密码" class="form-control" name="pwd">
                    </div>
                    <button type="submit" class="btn btn-success">登陆</button>
                </form>

        </div><!--/.nav-collapse -->

    </div>
</nav>
</body>
</html>
