<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 26. 2. 13.
  Time: 오후 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>임시 수정폼</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <!--        네비게이션 추가 작업-->
        <div class="col">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="/todo2/list">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/todo2/register">글쓰기</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Features</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Pricing</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <!--        네비게이션 추가 작업-->
        <div class="row content">
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        수정 화면
                    </div>
                    <div class="card-body">
                        <%--                            부트스트랩 이용중이고, 폼 컨트롤 하나씩 적용해보기.--%>
                        <%--                        상세보기 화면, 디비로 부터 전달 받은 데이터를 읽기 전용으로 화면에 표시하는게 목적. --%>
                        <form action="/todo2/modify" method="post">
                            <div class="input-group mb-3">
                                <span class="input-group-text">Tno:</span>
<%--                                <input class="form-control" type="text" name="tno" value=<c:out value="${dto.tno}"></c:out> readonly>--%>
<%--                                <input class="form-control" type="text" name="tno" value='<c:out value="${dto.tno}"></c:out>' readonly>--%>

                                <input class="form-control" name="title" value="<c:out value='${dto.title}'/>">
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text">Title:</span>
                                <input class="form-control" type="text" name="title"
                                       value=
                                <c:out value="${dto.title}"></c:out>>
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text">DueDate: </span>
                                <input class="form-control" type="date" name="dueDate"
                                       value=
                                <c:out value="${dto.dueDate}"></c:out>>
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text"> Writer:  </span>
                                <input class="form-control" type="text" name="writer"
                                       value=
                                       <c:out value="${dto.writer}"></c:out> readonly>
                            </div>
                            <div class="form-check mb-3">
                                <span class="form-check-label">  Finished:  </span>
                                <input class="form-check-input" type="checkbox" name="finished"
                                ${dto.finished? "checked" :""}>
                            </div>
                            <div>
                                <button class="btn btn btn-danger" type="button">삭제하기</button>
                                <button class="btn btn-primary" type="button">수정하기</button>
                                <button class="btn btn-secondary" type="button">목록가기</button>
                            </div>
                        </form>
                        <script>
                            //목록가기
                            document.querySelector(".btn-secondary").addEventListener("click", function (e) {
                                    self.location = "/todo2/list"
                                }, false
                            )
                            //삭제하기. -> form 태그 내부에 액션의 주소 : /todo2/modify
                            // 삭제하기 버튼 클릭 할 때, 주소를 변경 : /todo2/delete , post 로 전달하게끔, 변경.
                            // 자바스크립트 코드로 변경.
                            document.querySelector(".btn-danger").addEventListener("click", function (e) {
                                    // 기존 폼 태그의 전달이 될 주소를 변경.
                                    // 기존 폼 태그의 요소를 선택해서, 속성을 변경.
                                    const formObj = document.querySelector("form");

                                    // 기존의 서버 주소로 가는 기능을 막기.
                                    e.preventDefault();
                                    // 해당 버튼 만 클릭을 했을 때, 이벤트가 동작하는게 원함.
                                    // 만약, 버튼의 부모 요소를 클릭을 해도, 똑같이 클릭이 된 효과를 원하지 않아요.
                                    // 버튼이 아니라, 그 버튼 요소의 부모 요소의 배경을 클릭해도, 똑같이 이벤트 호출이 되는 것을 막음.
                                    // 결론, 삭제 버튼만 클릭해야, 삭제 기능을 동작 하겠다.
                                    e.stopPropagation();
                                    formObj.action = "/todo2/delete"
                                    formObj.method = "post"
                                    formObj.submit()
                                }, false
                            )
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row content">
        <%--        <h1>임시리스트</h1>--%>
    </div>
    <div class="row footer">
        <%--        <div class="row fixed-bottom" style="z-index: -100">--%>
        <%--    <div class="row fixed-bottom">--%>
        <footer class="py-3 mt-auto">
            <p class="text-center text-muted mb-0">
                Footer
            </p>
        </footer>
    </div>
    <%--    </div>--%>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>
