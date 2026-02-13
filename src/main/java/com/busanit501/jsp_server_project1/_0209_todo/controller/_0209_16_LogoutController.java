package com.busanit501.jsp_server_project1._0209_todo.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@Log4j2
@WebServlet(name="_0209_16_LogoutController", urlPatterns = "/logout_0209")
public class _0209_16_LogoutController extends HttpServlet {
    // 로그 아웃 처리.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        log.info("로그아웃 처리를 담당하느 doPost 입니다. ");

        // 임시 로그아웃 효과,
        HttpSession session = req.getSession();
        // 세션의 loginInfo 라는 키를 삭제하면 됩니다.
        session.removeAttribute("loginInfo");


        ////////////////////////////////////// 로그아웃 추가 실습
        Cookie targetCookie = null; // 변수선언. 쿠키 값 비교하기
        Cookie[] cookies = req.getCookies(); // 브라우저 상의 쿠키 값
        String cookieName = "remember-me"; // 브라우저 상의 쿠키 Name > _0209_13_LoginController
        if(cookies != null && cookies.length > 0) { // 쿠키 값이 있다
            for(Cookie ck: cookies) { // cookies을 ck 에 반복해서 쿠키 값을 대입한다
                if(ck.getName().equals(cookieName)) { // 쿠키이름을 비교해 본다
                    targetCookie = ck; // targetCookie 이 ck 가 된다.
                    break;
                } //if
            } //for
        } // if

        // 위에서 대입해서 targetCookie 값을 찾았고, targetCookie이 빈값이 아니면
        if(targetCookie != null) {
            targetCookie = new Cookie(cookieName,"");
            targetCookie.setPath("/");
            // targetCookie 유효시간을 0 으로 만들어 쿠키값이 저장되는걸 막는다
            targetCookie.setMaxAge(0);
        }
        ////////////////////////////////////// 로그아웃 추가 실습


        resp.addCookie(targetCookie);




        // 적용하기.
        session.invalidate();
        // 리다이렉트
        resp.sendRedirect("/login_0209");




    }
}
