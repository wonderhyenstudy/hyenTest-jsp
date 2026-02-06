package com.busanit501.jsp_server_project1._0206_todo.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet(name="_0206_13_LoginController", urlPatterns = "/login")
public class _0206_13_LoginController extends HttpServlet {
    // 로그인 화면 필요.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        log.info("로그인 화면을 제공하는 컨트롤러입니다.");
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
    }



    // 로그인 처리 필요.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        log.info("로그인 처리를 담당하느 doPost 입니다. ");

        // 화면에서, 전달받은 mid, mpw 정보를 가져오기. 무조건 문자열이다.
        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        // 임시로 : 아이디+패스워드 두 문자열을 합쳐서, loginInfo  저장.
        String mid_mpw = mid + mpw;

        // 세션 객체를 이용해서, 서버의 세션이라는 저장공간에 키 : loginInfo 저장.
        // 값 : 방금 아이디와 패스워드를 합친 문자열을 저장.
        HttpSession session = req.getSession();

        // 세션을 이용해서, 저장하기.
        session.setAttribute("loginInfo",mid_mpw );

        // 세션을 이용해서, 불로오기
        Object loginInfo = session.getAttribute("loginInfo");
        String loginInfoStr = (String) loginInfo;

        // 저장 후, 바로 불러오기 출력 확인.
        log.info("세션에 저장된 loginInfo 불러와 확인 loginInfoStr :  " + loginInfoStr);

        resp.sendRedirect("/todo/list_0206");
    }
}
