<%--
  Created by IntelliJ IDEA.
  User: a5429
  Date: 2018/10/2
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>SSM小项目</title>
</head>
<body>
    <div style="width:500px;margin:0px auto;text-align:center">
        <table align='center' border='1' cellspacing='0'>
            <tr>
                <td>id</td>
                <td>name</td>
            </tr>
            <c:forEach items="${cs}" var="c" varStatus="st">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                </tr>
            </c:forEach>
        </table>
        <div style="text-align:center">
            <a href="?start=0">首  页</a>
            <a href="?start=${page.start-page.count}">上一页</a>
            <a href="?start=${page.start+page.count}">下一页</a>
            <a href="?start=${page.last}">末  页</a>
        </div>
    </div>
</body>
</html>
