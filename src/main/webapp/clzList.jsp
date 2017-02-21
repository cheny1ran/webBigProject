<%@ page import="com.cyan.entity.Course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: cyan
  Date: 16/7/7
  Time: 17:46
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
<%
    String name = null;
    int num=1;
    List<Course> courses = (List<Course>) session.getAttribute("courses");
    if (session != null) {
        name = (String) session.getAttribute("user");
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
                <li><a href="/index">主页</a></li>
                <li class="active"><a href="/showAllClasses">所有课程</a></li>
                <li><a href="/showMyClasses">我的课程</a></li>
                <li><a href="/adminLogin.jsp">管理员登录</a></li>
            </ul>
            <%
                if (name != null) {
            %>

            <ul class="nav navbar-nav navbar-right">
                <li><a><%=name%> 欢迎您!
                </a></li>
                <li><a id="change" href="#" data-toggle="modal"
                       data-target="#myModal">修改密码</a></li>
                <li><a href="/logout">退出登录</a></li>
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
                <button type="submit" class="btn btn-success">登录</button>
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
        <li class="active">所有课程</li>
    </ol>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>编号</th>
            <th>课程名称</th>
            <th>所属社团</th>
            <th>学分</th>
            <th>开课学期</th>
            <th>课程容量</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            for(Course c:courses){
        %>
        <tr>
            <td><%=num++%></td>
            <td><%=c.getName()%></td>
            <td><%=c.getBelong()%></td>
            <td><%=c.getCredit()%></td>
            <td><%=c.getTime()%></td>
            <td><%=c.getSelected()%> / <%=c.getAmount()%></td>
            <td><a class="btn btn-primary" href="/showDetail?id=<%=c.getId()%>">详情</a></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close"
                            data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        修改密码
                    </h4>
                </div>
                <div class="modal-body">
                    <form action="/changePwd" method="post">
                        <div class="form-group">
                            <label for="old">旧密码</label>
                            <input type="password" class="form-control" id="old" name="old" placeholder="旧密码" required>
                        </div>
                        <div class="form-group">
                            <label for="newpwd">新密码</label>
                            <input type="password" class="form-control" id="newpwd" name="newpwd" placeholder="新密码" required>
                        </div>
                        <div class="form-group">
                            <label for="newagain">确认新密码</label>
                            <input type="password" class="form-control" id="newagain" name="newagain" placeholder="再次输入新密码" required>
                        </div>
                        <div class="modal-footer">
                            <input type="submit" class="btn btn-success" value="提交">
                            <button type="button" class="btn btn-default"
                                    data-dismiss="modal">关闭
                            </button>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

</div>
</body>
<script src="static/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

</html>
