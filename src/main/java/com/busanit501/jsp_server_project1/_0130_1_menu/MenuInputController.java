package com.busanit501.jsp_server_project1._0130_1_menu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "menuInputController", value = "/menu/input")
public class MenuInputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        System.out.println("menuInputController의 doGet  메서드, 요청이 잘 도착했습니다. ");
        // 실습1. get용
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/_0130_1_menu/menuInput_get.jsp");
        // 실습2. post용
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/_0130_1_menu/menuInput_post.jsp");
        dispatcher.forward(req,resp);
    }


}
