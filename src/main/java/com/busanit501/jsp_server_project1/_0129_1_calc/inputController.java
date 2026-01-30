package com.busanit501.jsp_server_project1._0129_1_calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




// value = "/_1_calc/input" -> 브라우저에서 보여줄 http 웹주소 : http://localhost:8080/_1_calc/input
@WebServlet(name = "inputController", value = "/_1_calc/input")
public class inputController extends HttpServlet {
//public class InputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 순서1, 요청이 잘 왔는지 확인.
        System.out.println("InputController의 doGet  메서드, 요청이 잘 도착했습니다. ");
        // 순서2, 실제로, 어느 화면으로 갈지를 정해주는 기능.
        RequestDispatcher dispatcher =
                // 폴더/파일 경로를 어디로 연결하느냐에 따라 다름
                // /WEB-INF/_1_calc/input.jsp -> 이 파일을 불러온다.
                req.getRequestDispatcher("/WEB-INF/_0129/_1_calc/input.jsp");
//                req.getRequestDispatcher("/_1_calc/input.jsp");
        // 순서3, dispatcher(비유, 공항의 관제탑, 비행기 착륙시 어디 활주로로 갈까요?
        // 네, 8번 활주로 오세요 응답)
        // dispatcher -> 여기 화면으로 이동하세요.
        dispatcher.forward(req,resp);

        // 확인.
        // 웹브라우저에서,
//        http://localhost:8080/calc/input
        // 서버, 자바 코드 작업 후, 반드시 모두 배포 해주세요.,
        // 나중에, 자동 리로드가 됩니다. 일단, 지금은 수동으로.,



    }
}
