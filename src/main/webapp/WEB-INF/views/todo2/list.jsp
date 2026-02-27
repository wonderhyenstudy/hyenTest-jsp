<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26. 2. 13.
  Time: 오후 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>임시리스트</title>
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

        <%--검색영역--%>
        <div class="row content">
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        검색창 화면
                    </div>
                    <div class="card-body">
                        <form action="/todo2/list" method="get">
                            <%--계속 기본 page =1 전달이 되어서, 수정--%>
                            <%--<input type="hidden" name="page" value="${pageRequestDTO.page}">--%>
                            <input type="hidden" name="size" value="${pageRequestDTO.size}">
                            <div class="mb-3">
                                <input type="checkbox" name="finished"
                                ${pageRequestDTO.finished ? "checked" : ""}
                                > 완료여부
                            </div>
                            <div class="mb-3">
                                <input type="checkbox" name="types" value="t"
                                ${pageRequestDTO.checkType("t") ? "checked" : ""}
                                > 제목
                                <input type="checkbox" name="types" value="w"
                                ${pageRequestDTO.checkType("w") ? "checked" : ""}
                                > 작성자
                                <%-- c:out ,출력시, 검색어, 불필요한 자바스크립트 태그가 들어가면 보안상, 안좋으므로 --%>
                                <%-- 안전한 출력을 선택--%>
                                <input type="text" name="keyword" class="form-control"
                                       value='<c:out value="${pageRequestDTO.keyword}"/>'
                                >
                            </div>
                            <div class="mb-3 input-group dueDateDiv">
                                <input type="date" name="from" class="form-control"
                                       value="${pageRequestDTO.from}"
                                >
                                <input type="date" name="to" class="form-control"
                                       value="${pageRequestDTO.to}"
                                >
                            </div>
                            <div class="mb-3 input-group">
                                <div class="float-end">
                                    <button type="submit"  class="btn btn-primary">검색하기</button>
                                    <button type="reset" class="btn btn-info clearBtn">초기화하기</button>
                                </div>
                            </div>
                            <script>
                                document.querySelector(".clearBtn").addEventListener("click", function (e){
                                    e.preventDefault()
                                    e.stopPropagation()
                                    self.location = `/todo2/list`
                                })
                            </script>

                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%--검색영역--%>

        <div class="row content">
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        전체목록
                    </div>
                    <div class="card-body">
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">Tno</th>
                                <th scope="col">Title</th>
                                <th scope="col">Writer</th>
                                <th scope="col">DueDate</th>
                                <th scope="col">Finished</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%--<c:forEach items="${dtoList}" var="dto">--%>
                            <%-- responseDTO.dtoList 호출하는 것은 responseDTO의 getter 를 호출하는 효과와 동일--%>
                            <c:forEach items="${responseDTO.dtoList}" var="dto">
                                <tr>
                                    <th><c:out value="${dto.tno}"/></th>
                                    <td>
                                        <a href="/todo2/read?tno=${dto.tno}&${pageRequestDTO.link}" class="text-decoration-none">
                                            <c:out value="${dto.title}"/>
                                        </a>
                                    </td>
                                    <td><c:out value="${dto.writer}"/></td>
                                    <td><c:out value="${dto.dueDate}"/></td>
                                    <td><c:out value="${dto.finished}"/></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="d-flex justify-content-center">
                            <ul class="pagination flex-wrap">
                                <c:if test="${responseDTO.prev}">
                                    <li class="page-item"><a class="page-link" data-num="${responseDTO.start - 1}">Previous</a>
                                    </li>
                                </c:if>
                                <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                                    <li class="page-item ${responseDTO.page == num ? "active" : ""}">
                                        <a class="page-link" data-num="${num}">${num}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${responseDTO.next}">
                                    <li class="page-item"><a class="page-link"
                                                             data-num="${responseDTO.end + 1}">Next</a></li>
                                </c:if>
                            </ul>
                        </div>
                        <script>
                            // document.querySelector(".pagination") -> <ul>태그를 의미,
                            // <ul>태그 를 포함해서, 하위에 어떤 태그, <li>, <a> 태그도 있다.
                            document.querySelector(".pagination").addEventListener("click", function (e) {
                                e.preventDefault(); // 기본 동작 막기
                                e.stopPropagation(); // 부모 요소 전팍 막기, 해당 요소외에는 클릭을 감지 안하겠다.
                                const target = e.target //클릭한 <li>, <a> 태그 요소 의미,
                                if (target.tagName !== 'A') {
                                    return // 이벤트 처리 동작을 안하고, 그냥 나가겠다.
                                }
                                // <a>태그만 이벤트 처리를 하겠다.
                                // <a class="page-link" data-num=""
                                const num = target.getAttribute("data-num")
                                // 기존 정보는 단순, 페이지 정보만 유지한 채 이동했고,
                                // self.location = `/todo2/list?page=\${num}`

                                // 20260226 링크 정보 모두 유지하기 위해 수정 form 태그 이용
                                // 검색착 폼 태그를 이용해서, 서버에, 검색, 필터 준비물 같이 전달.
                                // 물론, 페이지, 사이즈 정보도 같이 전달. 히든으로 페이지, 사이즈 전달.
                                // 폼 방식으로 만 서버에 전달하면, 1) 검색, 필터 준비물 + 2) 페이지 정보, 사이즈 정보 같이 전달.
                                const formObj = document.querySelector("form")

                                //
                                formObj.innerHTML += `<input type='hidden' name='page' value='\${num}'>`

                                formObj.submit()


                            }, false)
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
