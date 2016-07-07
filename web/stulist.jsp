<%@ page import="com.cyan.entity.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cyan.entity.Student" %>
<%@ page import="com.cyan.entity.StudyInfo" %><%--
  Created by IntelliJ IDEA.
  User: cyan
  Date: 16/7/7
  Time: 16:02
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
    <title>学生列表</title>
</head>
<body>
<%
    List<StudyInfo> students = (List<StudyInfo>) session.getAttribute("students");
    Course c = (Course) session.getAttribute("course");
    String name = (String) session.getAttribute("user");
    int num=1;
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
                <li><a href="/index">主页</a></li>
                <li><a href="/showAllClasses">所有课程</a></li>
                <li><a href="/showMyClasses">我的课程</a></li>
                <li><a href="#contact">关于我们</a></li>
            </ul>
            <%
                if (name != null) {
            %>

            <ul class="nav navbar-nav navbar-right">
                <li><a><%=name%> 欢迎您!
                </a></li>
                <li><a href="/changePwd">修改密码</a></li>
                <li><a href="/logout">退出登陆</a></li>
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

    <ol class="breadcrumb" style="margin-top: 100px">
        <li><a href="/index">首页</a></li>
        <li><a href="/showDetail?id=<%=c.getId()%>" onsubmit=""><%=c.getName()%></a></li>
        <li class="active">已选学生列表</li>
    </ol>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>编号</th>
            <th>学生姓名</th>
            <th>学号</th>
            <th>学院专业</th>
        </tr>
        </thead>
        <tbody>
        <%
            for(StudyInfo s:students){
        %>
        <tr>
            <td><%=num++%></td>
            <td><%=s.getS_name()%></td>
            <td><%=s.getS_id()%></td>
            <td><%=s.getS_major()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
