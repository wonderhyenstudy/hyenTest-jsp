package com.busanit501.jsp_server_project1._0209_todo.controller;

import com.busanit501.jsp_server_project1._0209_todo.dto._0209_18_MemberDTO;
import com.busanit501.jsp_server_project1._0209_todo.service._0209_21_MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@Log4j2
// 라우팅 한다
// 라우팅(Routing) : 데이터를 목적지까지 보내기 위한 '경로를 찾아주는 과정'
@WebServlet(name="_0209_13_LoginController", urlPatterns = "/login_0209")
public class _0209_13_LoginController extends HttpServlet {
    // 앞에 만들었던, 멤버서비스의 기능을 의존하고, 부탁하고, 용역주기
    _0209_21_MemberService memberService = _0209_21_MemberService.INSTANCE;


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
        log.info("로그인 처리를 담당하는 doPost 입니다. ");

        // 화면에서, 전달받은 mid, mpw 정보를 가져오기. 무조건 문자열이다.
        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        // =====================================================================
        // 자동로그인 기능 추가
        String auto = req.getParameter("auto");
        // 화면에서 , 체크를 한 경우, 결과 문자열 : "on" 으로 넘어온다
        // 자동로그인 체크 여부의 상태 변수.
        boolean rememberMe = auto != null && auto.equals("on");
        try {
            //
            _0209_18_MemberDTO memberDTO = memberService.login(mid, mpw);

            if (rememberMe) {
                //임시로 UUID 클래스를 이용해서, 랜덤한 문자열 생성.
                String uuid = UUID.randomUUID().toString();
                log.info("생성된 uuid 값 확인: " + uuid);
                // 서비스의 도움의 받아서, DB 에 해당 유저의 uuid 컬럼 부분을 업데이트 하기.
                memberService.updateUuid(mid,uuid);
                // 멤버 테이블에 업데이트가 된 uuid를 현재 로그인한 유저 상태에도 똑같이 업데이트
                // 서버의 메모리에 저장
                memberDTO.setUuid(uuid);

                //쿠키 전달.  서버 : 쿠키 생성, 서버가 웹브라우저에게 쿠키를 전달함.
                Cookie rememberCookie = new Cookie("remember-me", uuid);
                // 유효기간 : 7일
                rememberCookie.setMaxAge(60 * 60 * 24 * 7);
                // 웹 애플리케이션 전체에서 사용. 루트 경로
                rememberCookie.setPath("/");
                // 서버가 전달하기.
                resp.addCookie(rememberCookie);

            }
            // 세션에 기록하기.
            // 세션(Session) : 서버에 저장하는 임시 메모리 공간. PC가 아닌 웹 서버
            HttpSession session = req.getSession();
            // 세션 : 서버에 저장하는 임시 메모리 공간,
            // setAttribute -> 저장 : 세션 객체에 데이터 저장
            // 키 : loginInfo(라벨이름)
            // 값 : memberDTO 
            // 세션이라는 임시 메모리 공간에 loginInfo 라는 이름의 공간을 만들어서 memberDTO 라는 객체를 저장하여 사용한다
            session.setAttribute("loginInfo", memberDTO);
            resp.sendRedirect("/todo/list_0209");

        }catch (Exception e){
            // 로그인 실패하면, try 에서 예외가 발생하면
            resp.sendRedirect("/login_0209?result=error");
        }



        // =====================================================================


        // 260209 데이터베이스 로직처리로 변경
//        try{
//            // 화면에 입력한 mid, mpw 내용이 데이터베이스에 있다면, 정상 로그인 처리하고
//            // 없다면 예외를 발생시켜서 로그인 페이지로 보내고,
//            // 쿼리 스트링으로 result=error 같이 전달
//            _0209_18_MemberDTO memberDTO = memberService.login(mid, mpw);
//            HttpSession session = req.getSession();
//            session.setAttribute("loginInfo", memberDTO);
//            resp.sendRedirect("/todo/list_0209");
//
//        } catch (Exception e) {
//            resp.sendRedirect("/login?result=error");
//        }



//        // 임시로 : 아이디+패스워드 두 문자열을 합쳐서, loginInfo  저장.
//        String mid_mpw = mid + mpw;
//
//        // 세션 객체를 이용해서, 서버의 세션이라는 저장공간에 키 : loginInfo 저장.
//        // 값 : 방금 아이디와 패스워드를 합친 문자열을 저장.
//        HttpSession session = req.getSession();
//
//        // 세션을 이용해서, 저장하기.
//        session.setAttribute("loginInfo",mid_mpw );
//
//        // 세션을 이용해서, 불로오기
//        Object loginInfo = session.getAttribute("loginInfo");
//        String loginInfoStr = (String) loginInfo;
//
//        // 저장 후, 바로 불러오기 출력 확인.
//        log.info("세션에 저장된 loginInfo 불러와 확인 loginInfoStr :  " + loginInfoStr);

//        resp.sendRedirect("/todo/list_0209");
    }
}
