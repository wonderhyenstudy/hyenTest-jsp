package com.busanit501.jsp_server_project1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 서버의 라우팅(길찾기), 웹브라우저가 http://localhost:8080/my 라고 호출하면
// jsp 컨테이너가 받아서, 해당 /my 해당하는 서블릿 자바 파일 찾기
// 서버 -> 웹브라우저에게 내용 전달
@WebServlet(name = "MyServlet", value = "/my")
public class MyServlet extends HttpServlet {

    @Override
//    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 지금 작성하는 코드는 절대 치지말고, 구경하세요.
        // 기본 원리를 한번 보여주는 용도, 절대 이렇게 작업안해요.
//        resp.setContentType("text/html");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        // 서버에서 작성한 내용을, 웹문서 형식에 맞게 조정해서, 보내기.
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>오늘 점심 뭐 먹죠? 맨날 먹는 것만 물어보네,네, 배고파요.!!<h1>");
        out.println("</body><html>");

        // 결과 확인.
        // http://localhost:8080/my

    }


}
