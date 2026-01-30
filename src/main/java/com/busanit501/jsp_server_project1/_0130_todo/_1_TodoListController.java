package com.busanit501.jsp_server_project1._0130_todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "_1_todoListController", value = "/todo/list")
public class _1_TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("[list] 여기 왔다는 건, 클라이언트, url 주소 요청하고, 서버가 응답을 한다. ");
        System.out.println("[list] 서버기 일을 하고 있다. 조금 있디 화면을 웹브라우저에게 던져준다. ");
        System.out.println("[list] /todo/list, get으로 요청 처리함. ");

//        RequestDispatcher dispatcher = 
//                req.getRequestDispatcher("/WEB-INF/_0130_todo/list.jsp"); 
//        dispatcher.forward(req,resp);
        
        // 위에 코딩을 한줄로 줄였음
        req.getRequestDispatcher("/WEB-INF/_0130_todo/list.jsp").forward(req,resp); 
        
        
    }

}
