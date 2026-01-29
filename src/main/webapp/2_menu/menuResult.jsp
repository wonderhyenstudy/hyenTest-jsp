<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26. 1. 29.
  Time: 오후 3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    request.setCharacterEncoding("UTF-8"); //한글 깨짐 방지 : 인코딩
%>
<head>
    <title>menuResult</title>
</head>
<body>
<h1>주문한 메뉴입니다.</h1>
<p>===================</p>
<h2>주문메뉴 : ${param.menuName}</h2>
<h2>가격 : ${param.price}</h2>
</body>
</html>
