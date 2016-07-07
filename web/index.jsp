<%@ page import="com.cyan.entity.Course" %>
<%@ page import="java.util.List" %><%--
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
<%
    String id=null;
    String msg=null;
    if(session!=null) {
        id = (String) session.getAttribute("user");
        msg=(String) session.getAttribute("msg");
    }

    if(msg!=null){

%>
<script>
    alert(<%=msg%>);
</script>
<%
    }
%>
<body role="document">
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
                <li class="active"><a href="/index">主页</a></li>
                <li><a href="#about">所有课程</a></li>
                <li><a href="#contact">我的课程</a></li>
                <li><a href="#contact">关于我们</a></li>
            </ul>
            <%
                if (id != null) {
            %>

            <ul class="nav navbar-nav navbar-right">
                <li><a><%=id%></a></li>
                <li><a>欢迎您!</a></li>
            </ul>
            <%
            } else {
            %>
            <form class="navbar-form navbar-right" action="/login" method="post">
                <div class="form-group">
                    <input type="text" placeholder="学号" class="form-control" name="id">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="密码" class="form-control" name="pwd">
                </div>
                <button type="submit" class="btn btn-success">登陆</button>
            </form>
            <%
                }
            %>
        </div><!--/.nav-collapse -->

    </div>
</nav>

<div class="container theme-showcase" role="main">
    <div class="jumbotron">
        <h1>欢迎登陆学生社团管理系统!</h1>
        <p>This is a template for a simple marketing or informational website. It includes a large callout called a
            jumbotron and three supporting pieces of content. Use it as a starting point to create something more
            unique.</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
    </div>


    <div class="container">
        <!-- Example row of columns -->
        <div class="row">
            <%
                List<Course> clzs = (List<Course>) session.getAttribute("clzs");
                if (!(clzs == null || clzs.isEmpty())) {
                    for (Course clz : clzs) {
            %>

            <div class="col-md-4">
                <h2><%=clz.getName()%>
                </h2>
                <p>所属社团:<%=clz.getBelong()%>
                </p>
                <p><%=clz.getDetail()%>
                </p>
                <p><a class="btn btn-default" href="/showDetail?id=<%=clz.getId()%>" role="button">View
                    details &raquo;</a></p>
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>
</div>
</div>
</body>
</html>
