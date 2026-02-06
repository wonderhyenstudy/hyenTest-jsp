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
<div><a href="/todo/register_0206">글쓰기 바로가기</a></div>
<br>
<form action="/loout" method="post">
    <button>로그아웃</button>
</form>
<br>
<div style="margin:10px; padding:10px 30px; border:1px solid #000">
    <h2>서블릿 컨텍스트에 저장된 데이터 불러와서, 화면에 표현해보기</h2>
    <%-- 서블릿에서 설정한 데이터 가져오기 --%>
    <p>메시지: <%= application.getAttribute("globalMessage") %></p>
    <p>관리자 이메일: <%= application.getInitParameter("adminEmail") %></p>
    <hr>
    <h3>직접 가져오기.</h3>
    <p>이메일2:${globalMessage}</p>
    <p>관리자 이메일2:${adminEmailDirect}</p>
</div>
<ul>
<%--    1) 반복문--%>
<%--    문법 정의, <c:forEach> 태그 이용하기.--%>
<%--    속성,--%>
<%--    var(하나 꺼내서 사용할 요소의 변수명) ,--%>
<%--    items(목록 리스트 ),--%>
<%--    begin/end(인덱스에서 순번 정하기.)--%>
    <c:forEach var="dto" items="${dtoList}">
<%--    <li>${dto}</li>--%>
        <li>
            <span style="width:30px;display: inline-block;">${dto.tno}</span>
            <span><a href="/todo/read_0206?tno=${dto.tno}">${dto.title}</a></span>
            <span>${dto.dueDate}</span>
            <span>${dto.finished ? "완료" : "미완료"}</span>
        </li>
    </c:forEach>
</ul>


</body>
</html>
