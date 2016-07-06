<%@ page import="com.cyan.entity.Course" %><%--
  Created by IntelliJ IDEA.
  User: cyan
  Date: 16/7/6
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程详情</title>
</head>
<body>
    <%
        Course c = (Course) session.getAttribute("course");
    %>
    <%=c.getName()%>
</body>
</html>
