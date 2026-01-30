package com.busanit501.jsp_server_project1._0130_todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "_2_todoRegController", value = "/todo/register")
public class _2_TodoRegController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("/todo/register, 글작성 폼 임시화면 get으로 요청 처리함. ");

//        RequestDispatcher dispatcher =
//                req.getRequestDispatcher("/WEB-INF/_0130_todo/todoReg.jsp");
//        dispatcher.forward(req,resp);

        // 위에 코딩을 한줄로 줄였음
        req.getRequestDispatcher("/WEB-INF/_0130_todo/todoReg.jsp").forward(req,resp);

    }
    //글쓰기 로직 처리
    //post
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("[reg] _0130_todo/todoReg 글쓰기 로직 처리하는 곳입니다.");

        System.out.println("[reg] PRG 패턴으로 글쓰기 post 작업 후, 리다이렉트 목록 화면으로 이동하기.");
        resp.sendRedirect("/todo/list");


    }

}