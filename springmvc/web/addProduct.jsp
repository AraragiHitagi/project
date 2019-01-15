<%--
  Created by IntelliJ IDEA.
  User: a5429
  Date: 2018/9/27
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="addProduct" method="post">
        产品名称 : <input type="text" name="name" value=""><br/>
        产品价格 : <input type="text" name="price" value=""><br/>
        <input type="submit" value="增加商品">
    </form>

    <form action="addCategory" method="post">
        产品类别 : <input type="text" name="cate_name" value=""><br/>
        <input type="submit" value="增加商品类别">
    </form>

</body>
</html>
