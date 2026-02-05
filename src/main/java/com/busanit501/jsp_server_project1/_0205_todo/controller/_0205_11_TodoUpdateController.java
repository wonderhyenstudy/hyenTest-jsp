package com.busanit501.jsp_server_project1._0205_todo.controller;

import com.busanit501.jsp_server_project1._0205_todo.dto._0205_2_TodoDTO;
import com.busanit501.jsp_server_project1._0205_todo.service._0205_1_TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@WebServlet(name = "_0205_5_TodoUpdateController", value = "/todo/update_0205")
public class _0205_11_TodoUpdateController extends HttpServlet {

    // 2가지 기능을 제공
    // 1) 화면 제공, 2) 글쓰기 작업 수행.

    // 컨트롤러에서,  글쓰기하는 서비스 기능이 없음,
    // 1) 여기서 또 새로 만들거나 , 2) 이미 만들어진 기능을 가져와서 재사용.
    // 정답 : 2) 이용.

    // 서비스의 기능을 가지고 있는 클래스 이용 : _0204_4_TodoService
    private _0205_1_TodoService todoService = _0205_1_TodoService.INSTANCE;
    // 시간의 포맷 형태를 변경하는 기능을 추가. HH : 24시간제 표기 , a(오전/오후) hh : 1 ~12시 나타냄.
//    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm:ss");
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");



    // 수정 폼 화면
    // 이미 글은 작성이 되어 있고, DB 서버에 저장이 되어 있는 상태
    // 하나조회 화면(상세보기 화면), 수정/삭제 버튼 클릭해서, 수정화면으로 이동
    // -> 수정 화면 -> 기존의 데이터를, 화면에 불러오기
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {



        // 받을 때 한글 설정,
        req.setCharacterEncoding("UTF-8");

        log.info("[updateController] todo/update_0205 수정화면 로직 처리하는 곳입니다.");

        try {

            // 하나 조회했고, 수정화면으로 넘길때, 우리는 조회하는 todo의 tno번호를 알고 있다
            // 하나조회(상세보기), URL : http://localhost:8080/todo/read_0205?tno=24
            // 여기서, tno 번호를 서버에 전달하기
            // 서버입장에서, tno 번호를 가져오기
            // 문자열 -> 숫자 타입 변경, 파싱 : Long.parseLong()
            Long tno = Long.parseLong(req.getParameter("tno"));

            // DB 서버에게 일시키기. 우리는 서비스를 고용해서, 일 시키자
            // DB로 하나 조회된 데이터를 가지고 왔음
            _0205_2_TodoDTO todoDTO = todoService.get(tno);

            // 화면에 전달.
            req.setAttribute("dto", todoDTO);
            req.getRequestDispatcher("/WEB-INF/_0205_todo/modify.jsp").forward(req,resp);

            // 보낼 때 한글 설정,
            // 나중에, 서버에 한번만 설정해서, 따로 설정 없이, 이용만 하면됨.
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    // 수정 처리
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 받을 때 한글 설정,
        req.setCharacterEncoding("UTF-8");


        // 주의사항,
        // 수정시, 완료 여부가 체크박스 변수명 finished 넘어옴. 문자열로 체크 되면 : "on", 안되면 : null
        // 문자열로 다 받는다
        String tno = req.getParameter("tno");
        String title = req.getParameter("title");
        String dueDate = req.getParameter("dueDate");
        String finishedStr = req.getParameter("finished");
        //수정할 내용을 받은 상태
        // 수정된 내용으로, 서비스에게 일을 시키기
        // 넘어온 데이터를 dto에 담기
        _0205_2_TodoDTO todoDTO = _0205_2_TodoDTO.builder()
//                .tno(req.getParameter("tno"))
                // 문자열을 숫자로 바꿈
                .tno(Long.parseLong(tno))
                .title(title)
                // dueDate 문자열 -> LocalDate 타입으로 변경하고, 원하는 포맷팅 :yyyy-MM-dd
                .dueDate(LocalDate.parse(dueDate, DATEFORMATTER)) // 위에 문자열을 저장해 놨다
                .finished(finishedStr != null && finishedStr.equals("on")) // 문자열로 체크 되면 : "on", 안되면 : null
                .build();
        log.info("화면으로 전달 받은, 수정할 내용 확인 todoDTO: " + todoDTO);

        try {
            // 보낼 때 한글 설정,
            // 나중에, 서버에 한번만 설정해서, 따로 설정 없이, 이용만 하면됨.
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");

            todoService.modify(todoDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/todo/list_0205");
    }
}
