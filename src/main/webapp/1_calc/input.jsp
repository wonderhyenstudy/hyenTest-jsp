<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26. 1. 29.
  Time: 오후 2:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>input</title>
</head>
<body>
  <h1>get 방식 입력 조회 연습</h1>
  <p>웹브라우저에서, 서버로 전달한느 방법을 : post로 변경,<br>
  데이터를 공개하지 않고, 데이터의길이도 상관없음.</p>
<%--  get방식, 주소 노출--%>
<%--  <form>   --%>
<%--  post방식, --%>
  <form action="calcResult.jsp" method="post">
    <input type="number" name="num1" id="">
    <input type="number" name="num2" id="">
    <button type="submit">전송</button>
  </form>
</body>
</html>
