//package com.busanit501.jsp_server_project1.springex_0213_keep.controller;
//
//import com.busanit501.jsp_server_project1.springex_0213_keep.dto.TodoDTO;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller // 서버 시작할때 해당 클래스 개체를 미리 활성화 시켜줘
//// 라우팅
//// http://localhost:8080/todo 관련된 업무는 내가 처리할게!
//@RequestMapping("/todo2")
//@Log4j2
//public class TodoController {
//    // http://localhost:8080/todo/list
//    // 뷰 리졸버가 연결되어서
//    // todo/list 로 오면 /WEB-INF/views/todo/list.jsp 화면으로 가도록 연결 설정됨
//    @RequestMapping("/list")
//    public void list() {
//        log.info("todo list...");
//    }
//    // todo/list ->    /WEB-INF/views/todo/register/list.jsp 연결 설정됨.
////    @RequestMapping(value = "/register", method = RequestMethod.GET)
////    public void register() {
////        log.info("todo register..get");
////
////    }
//    @GetMapping("/register")
//    public void getRegister() {
//        log.info("todo register..get");
//    }
//
//    @PostMapping("/register")
//    public void postRegister(TodoDTO todoDTO) {
//        log.info("todo register..post");
//        log.info("todoDTO : " + todoDTO);
//    }
//
//}
