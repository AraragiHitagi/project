<%--
  Created by IntelliJ IDEA.
  User: a5429
  Date: 2018/9/28
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="uploadImage" method="post" enctype="multipart/form-data">
        选择图片:<input type="file" name="image" accept="image/*" /> <br>
        <input type="submit" value="上传">
    </form>
</body>
</html>