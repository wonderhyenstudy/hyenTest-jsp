<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26. 1. 29.
  Time: 오후 3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>menu</title>
</head>
<body>
<h1>메뉴를 고르세요.</h1>
<form action="menuResult.jsp" method="post">
    <input type="text" name="menuName" id="">
    <input type="number" name="price" id="">
    <button type="submit">주문</button>

</form>
</body>
</html>
