<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26. 2. 13.
  Time: 오후 2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <title>임시 register 화면</title>
    <style>
        .custom-check-inline {
            display: flex; /* 요소들을 가로로 배치 */
            align-items: center; /* 수직 중앙 정렬 */
            gap: 10px; /* 라벨과 체크박스 사이의 간격 설정 */
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="/todo2/list">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
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
        <div class="row content">
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        글쓰기
                    </div>
                    <div class="card-body">
                        <form action="/todo2/register" method="post">
                            <div class="input-group mb-3">
                                <label class="input-group-text">Title</label ><input type="text" class="form-control" name="title" placeholder="todo 제목을 입력해주세요">
                            </div>
                            <div class="input-group mb-3">
                                <label class="input-group-text">DueDate</label ><input type="date" class="form-control" name="dueDate">
                            </div>
                            <div class="input-group mb-3">
                                <label class="input-group-text">Writer</label ><input type="text" class="form-control" name="writer">
                            </div>
                            <%--<div class="form-check form-check-reverse mb-3">
                                <input type="checkbox" class="form-check-input" name="finished">
                                <label class="form-check-label">Finished</label >
                            </div>--%>
<%--                            <div class="form-check mb-3">--%>
<%--                                <input class="form-check-input" type="checkbox" value="" id="checkDefault" name="finished">--%>
<%--                                <label class="form-check-label" for="checkDefault">Finished</label>--%>
<%--                            </div>--%>

                            <div class="form-check mb-3">
                                <span class="form-check-label">  Finished:  </span>
                                <input class="form-check-input" type="checkbox" name="finished">
                            </div>

                            <div class="mb-3">
                                <button type="reset" class="btn btn-secondary">초기화</button>
                                <button type="submit" class="btn btn-primary">등록처리</button>
                            </div>
                        </form>

                        <script>
                            // 자바스크립트 코드, 유효성체크시, 오류를 담아둘 빈 객체 정의
                            // 자바스크립트의 객체의 자료구조 형식 , { key:val, key2:val2,...}
                            const serverValidResult = {}
                            <c:forEach items="${errors}" var="error">
                            // ` -> 백틱
                            serverValidResult[`${error.getField()}`] = `${error.defaultMessage}`
                            </c:forEach>
                            console.log("유효성 오류가 난 부분들 : " , serverValidResult)
                        </script>


                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row content">
        <h1>content</h1>
    </div>
    <div class="row footer">
        <!--        <h1>footer</h1>-->
        <div class="row fixed-bottom" style="z-index:-100">
            <footer class="py-1 my-1">
                <p class="text-center text-muted">
                    Footer
                </p>
            </footer>
        </div>
    </div>
</div>
<h1>부트스트랩 적용, register 화면</h1>

<!-- Option 1: Bootstrap Bundle with Popper -->
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

</body>
</html>
