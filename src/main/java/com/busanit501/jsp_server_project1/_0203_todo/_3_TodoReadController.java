package com.busanit501.jsp_server_project1._0203_todo;

import com.busanit501.jsp_server_project1._0202_todo.dto._3_TodoDTO;
import com.busanit501.jsp_server_project1._0202_todo.service._4_TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "_3_todoReadController_0202", value = "/todo/read_0202")
public class _3_TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 현재, 작업하는 파일 어디인지, 서버 콘솔에 출력
        System.out.println("[read] /todo/read_0202, get으로 요청 처리함. ");

        // getParameter: 주소창의 값을 자바 변수로 옮김.
        // setAttribute: 자바 변수를 JSP 화면으로 옮김.

        // 임시로 하나 조회할 더미 데이터 지정.(더미 데이터 임의로 100번 지정)
        // 웹브라우저에서, 주소 요청 : http://localhost:8080/todo/read_0202?tno=100
        // 서버는, 웹에서 전달한 데이터를 가져오기.
        // req.getParameter("tno") => 문자열이기 때문에, 우리는 파싱해서, 다시 숫자 형태로 변경
        // Long.parseLong(문자열) -> 문자열 -> 숫자변경
        // req.getParameter : 입구 : 데이터를 가져오는 쪽
        // req.getParameter : 외부(브라우저)에서 보낸 데이터를 서블릿 안으로 들여오는 역할
        Long tno = Long.parseLong(req.getParameter("tno"));


        // 서브스에서 만들었던, get 메서드
        _3_TodoDTO dto = _4_TodoService.INSTANCE.get(tno);


        // 데이터를 전달 준비1
        // 찾아온 데이터를 "dto"라는 이름표를 붙여서 요청 상자(req)에 담습니다.
        // setAttribute("이름표", 실제데이터); : 데이터 전달용 임시 보관함(Request)에 짐을 싣는 과정
        // // 출구 : 데이터를 전달하는 쪽
        req.setAttribute("dto", dto);

        // 화면에 전달
        req.getRequestDispatcher("/WEB-INF/_0202_todo/todoRead.jsp").forward(req, resp);

    }
}
