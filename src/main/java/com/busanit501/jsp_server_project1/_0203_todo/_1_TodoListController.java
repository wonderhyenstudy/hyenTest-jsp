package com.busanit501.jsp_server_project1._0203_todo;

import com.busanit501.jsp_server_project1._0202_todo.dto._3_TodoDTO;
import com.busanit501.jsp_server_project1._0202_todo.service._4_TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "_1_todoListController_0202", value = "/todo/list_0202")
public class _1_TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("[list] 여기 왔다는 건, 클라이언트, url 주소 요청하고, 서버가 응답을 한다. ");
        System.out.println("[list] 서버기 일을 하고 있다. 조금 있디 화면을 웹브라우저에게 던져준다. ");
        System.out.println("[list] /todo/list_0202, get으로 요청 처리함. ");


        //_4_TodoService, 기능에서, 데이터를 조회하는 기능
        // 지금은 더미데이터, 나중에 데이터 베이스를 붙이기
        List<_3_TodoDTO> dtoList = _4_TodoService.INSTANCE.getList();

        // 서블릿(Java)에서 처리한 데이터를 JSP(화면)로 전달하기 위해 Request 객체에 담는 과정입니다.
        // list 라는 박스에 고객이 요청한 dtoList 를 담는다
        req.setAttribute("list", dtoList);



//        RequestDispatcher dispatcher = 
//                req.getRequestDispatcher("/WEB-INF/_0202_todo/list.jsp");
//        dispatcher.forward(req,resp);
        
        // 위에 코딩을 한줄로 줄였음
        req.getRequestDispatcher("/WEB-INF/_0202_todo/list.jsp").forward(req,resp);
        
        
    }

}
