package com.busanit501.jsp_server_project1._0205_todo.controller;

import com.busanit501.jsp_server_project1._0205_todo.dto._0205_2_TodoDTO;
import com.busanit501.jsp_server_project1._0205_todo.service._0205_1_TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "_0205_6_TodoListController", value = "/todo/list_0205")
@Log4j2 // 로그를 중요도에 따라서, 기록을 하는 방법을 다르게 한다.
public class _0205_6_TodoListController extends HttpServlet {
    // 컨트롤러에서, 목록조회하는 기능이 없음,
    // 1) 여기서 또 새로 만들거나 , 2) 이미 만들어진 기능을 가져와서 재사용.
    // 정답 : 2) 이용.

    // 서비스의 기능을 가지고 있는 클래스 이용 : _0204_4_TodoService
    private _0205_1_TodoService todoService = _0205_1_TodoService.INSTANCE;

//    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 테스트용
//        System.out.println("package com.busanit501.jsp_server_project1._0204_todo.controller; " +
//                "_0204_7_TodoListController, 시간 260204:141800 기존 콘솔에서 확인하는 방법. ");
//        log.info("[TodoListController] : log4j2를 이용해서, 기록하기. ");

        log.info("============== 전체 목록 조회 ================");
        try{
            List<_0205_2_TodoDTO> dtoList = todoService.listAll();
            req.setAttribute("dtoList", dtoList);

            req.getRequestDispatcher("/WEB-INF/_0205_todo/list.jsp").forward(req,resp);

        }catch (Exception e){
            log.error(e.getMessage());
            throw new ServletException("list error");
        }



        
    }

}
