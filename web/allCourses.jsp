<%@ page import="com.cyan.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cyan.entity.Course" %><%--
  Created by IntelliJ IDEA.
  User: cyan
  Date: 16/7/8
  Time: 20:53
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
    <title>所有课程</title>
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
                <li><a href="/studentManage">学生管理</a></li>
                <li class="active"><a href="/courseManage">课程管理</a></li>
                <li><a href="/chooseManage">选课管理</a></li>
                <li><a href="/index">返回学生版主页</a></li>
            </ul>
        </div><!--/.nav-collapse -->

    </div>
</nav>
<%
    List<Course> course = (List<Course>) session.getAttribute("courses");
    String msg = (String) session.getAttribute("msg");
    int num = 1;
%>
<div class="container theme-showcase" role="main">

    <ol class="breadcrumb" style="margin-top: 100px">
        <li><a href="/adminIndex">首页</a></li>
        <li class="active">课程管理</li>
    </ol>
    <%
        if (msg != null) {
            if (msg.equals("添加成功") || msg.equals("更新成功") || msg.equals("删除成功")) {
    %>
    <div class="alert alert-success" style="margin-top: 50px" role="alert">
        <%
        } else {
        %>
        <div class="alert alert-danger" style="margin-top: 50px" role="alert">
            <%
                }
            %>
            <strong><%=msg%>
            </strong>
        </div>

        <%
                session.setAttribute("msg", null);
            }
        %>


        <table class="table table-striped">
            <thead>
            <tr>
                <th>编号</th>
                <th>课程编号</th>
                <th>课程名</th>
                <th>开课学期</th>
                <th>课程学分</th>
                <th>所属社团</th>
                <th>开课地点</th>
                <th>已选人数/课程容量</th>
                <%--<th>课程描述</th>--%>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Course c : course) {
            %>
            <tr>
                <td><%=num++%>
                </td>
                <td><%=c.getId()%>
                </td>
                <td><%=c.getName()%>
                </td>
                <td><%=c.getTime()%>
                </td>
                <td><%=c.getCredit()%>
                </td>
                <td><%=c.getBelong()%>
                </td>
                <td><%=c.getPlace()%>
                </td>
                <td><%=c.getSelected()%> / <%=c.getAmount()%>
                </td>
                <%--<td><%=c.getDetail()%>--%>
                <%--</td>--%>
                <%--<td><a href="/changeStudent?id=<%=s.getId()%>" class="btn btn-primary" id="changeStu">修改</a>--%>
                <td><a href="/changeCourse?id=<%=c.getId()%>" class="btn btn-primary">修改</a>
                    <a href="/adminDelCourse?id=<%=c.getId()%>" class="btn btn-danger">删除</a>
                </td>
            </tr>
            <%
                }
            %>
            <tr>
                <td colspan="8">&nbsp</td>
                <td><a href="addCourse.jsp" class="btn btn-success">添加课程</a></td>
            </tr>

            </tbody>
        </table>
    </div>

</div>

<script type="text/javascript" src="static/js/jquery-3.0.0.min.js"></script>

</body>
</html>
