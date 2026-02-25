<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26. 2. 23.
  Time: 오전 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <title>임시 하나조회</title>
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
            상세조회
          </div>
          <div class="card-body">
            <%-- 부트스트랩 이용중이고, 폼 컨트롤 하나씩 적용해보기.--%>
            <%-- 상세보기 화면, 디비로 부터 전달 받은 데이터를 읽기 전용으로 화면에 표시하는게 목적. --%>
              <div class="input-group mb-3">
                <span class="input-group-text">Tno:</span>
                <input class="form-control" type="text" name="tno"
                       value="<c:out value='${dto.tno}'></c:out>" readonly>
              </div>
              <div class="input-group mb-3">
                <span class="input-group-text">Title:</span>
                <input class="form-control" type="text" name="title"
                       value="<c:out value='${dto.title}'></c:out>" readonly>
              </div>
              <div class="input-group mb-3">
                <span class="input-group-text">DueDate: </span>
                <input class="form-control" type="date" name="dueDate"
                       value=<c:out value="${dto.dueDate}"></c:out> readonly>
              </div>
              <div class="input-group mb-3">
                <span class="input-group-text"> Writer:  </span>
                <input class="form-control" type="text" name="writer"
                       value=<c:out value="${dto.writer}"></c:out> readonly>
              </div>
              <div class="form-check mb-3">
                <span class="form-check-label">  Finished:  </span>
                <input class="form-check-input" type="checkbox" name="finished"
                ${dto.finished? "checked" :""}>
              </div>
              <div>
                <button class="btn btn-primary" type="button">수정하기</button>
                <button class="btn btn-secondary" type="button">목록가기</button>
              </div>
              <script>
                //목록가기
                document.querySelector(".btn-secondary").addEventListener("click", function (e) {
                          self.location = "/todo2/list?${pageRequestDTO.link}"
                          // self.location = "/todo2/list"
                        },false
                )
                //수정폼 가기
                document.querySelector(".btn-primary").addEventListener("click", function (e) {
                          <%--self.location = "/todo2/modify?tno=" + ${dto.tno}--%>
                          self.location = `/todo2/modify?tno=${dto.tno}&${pageRequestDTO.link}`
                        },false
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
    <%--        <div class="row fixed-bottom" style="z-index:-100">--%>
    <footer class="py-3 mt-auto">
      <p class="text-center text-muted mn-0">
        Footer
      </p>
    </footer>
    <%--        </div>--%>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>