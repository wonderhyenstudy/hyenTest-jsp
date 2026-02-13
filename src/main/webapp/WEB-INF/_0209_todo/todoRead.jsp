<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26. 2. 2.
  Time: 오후 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TodoRead 임시화면</title>
</head>
<body>
<h1>TodoRead 임시화면</h1>
<h3>하나의 정보를 불러오기, dto 라는 객체에서 정보를 하나씩 꺼내보기</h3>
<p>_0209_2_TodoDTO 모델클래스의 멤버를 getter로 가져오는 효과</p>
<div>
    <input type="text" name="tno" value="${dto.tno}" id="" readonly>
    <%--${dto.tno}--%>
</div>
<div>
    <input type="text" name="title" value="${dto.title}" id="" readonly>
<%--    ${dto.title}--%>
</div>
<div>
    <input type="date" name="dueDate" value="${dto.dueDate}" id="">
<%--    ${dto.dueDate}--%>
</div>
<div>
    <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""} id="" readonly>
    ${dto.finished}
</div>
<div>
    <a href="/todo/update_0209?tno=${dto.tno}">수정/삭제 바로가기</a><br>
    <a href="/todo/list_0209">목록 바로가기</a>
</div>
</body>
</html>
