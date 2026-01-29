package com.busanit501.jsp_server_project1;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
//        message = "Hello World!";
        message = "오늘 점심 뭐 먹죠??";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 한글 안깨지게 설정하려면, utf-8 설정 필요함.
        response.setContentType("text/html;charset=UTF-8");

        // 응답 문자의 인코딩 , utf-8 설정 필요함.
        // 나중에, 서버 단에서, 한번만 설정시, 일괄 전체 적용하는 방법 있음.
        // 지금은 임시로 한글 되는 방법만 보여드리기.
        response.setCharacterEncoding("UTF-8");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}