<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26. 1. 30.
  Time: 오후 3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>등록</title>
</head>
<body>
<h1>todoReg 글쓰기 임시 화면입니다.</h1>
<div><a href="/todo/list_0206">목록 바로가기 </a></div>
<br>
<form action="/todo/register_0206" method="post">
    <div>
        <input type="text" name="title" placeholder="todo 제목을 입력해주세요">
    </div>
    <div>
        <input type="date" name="dueDate">
    </div>
    <button type="reset">초기화</button>
    <button type="submit">등록처리</button>
</form>
</body>
</html>
