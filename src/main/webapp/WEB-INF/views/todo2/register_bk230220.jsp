<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26. 2. 13.
  Time: 오후 2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>임시 register 화면</title>
</head>
<body>
<h1>임시 register 화면</h1>
<h2>스프링 수업중</h2>
<form action="/todo2/register" method="post">
    <div>
        <span>Title : </span><input type="text" name="title" placeholder="todo 제목을 입력해주세요">
    </div>
    <div>
        <span>DueDate : </span><input type="date" name="dueDate">
    </div>
    <div>
        <span>Writer : </span><input type="text" name="writer">
    </div>
    <div>
        <span>Finished : </span><input type="checkbox" name="finished">
    </div>
    <br>
    <div>
        <button type="reset">초기화</button>
        <button type="submit">등록처리</button>
    </div>
</form>
</body>
</html>
