<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26. 1. 30.
  Time: 오후 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>리스트</title>
</head>
<body>
<h1>list 임시 화면입니다.</h1>
<div><a href="/todo/register_0204">글쓰기 바로가기</a></div>
<ul>
<%--    1) 반복문--%>
<%--    문법 정의, <c:forEach> 태그 이용하기.--%>
<%--    속성,--%>
<%--    var(하나 꺼내서 사용할 요소의 변수명) ,--%>
<%--    items(목록 리스트 ),--%>
<%--    begin/end(인덱스에서 순번 정하기.)--%>
    <c:forEach var="dto" items="${dtoList}">
    <li>${dto}</li>
    </c:forEach>
</ul>

</body>
</html>
