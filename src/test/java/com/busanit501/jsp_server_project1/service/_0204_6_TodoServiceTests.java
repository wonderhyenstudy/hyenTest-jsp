package com.busanit501.jsp_server_project1.service;

import com.busanit501.jsp_server_project1._0204_todo.dto._0204_1_TodoDTO;
import com.busanit501.jsp_server_project1._0204_todo.service._0204_4_TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@Log4j2 // 로그 기록 확인. src/main/resources/log4j2.xml

public class _0204_6_TodoServiceTests {
    // 외부 기능을 담당하는 클래스를 가져오기


    // 서비스 기능을 담당하는 클래스를 불러오기
    // 전역으로 선언한 하고, 실제 사용은 밑에서 초기화 해서 사용할수 있는 형태로 만들기
    private _0204_4_TodoService todoService;

    @BeforeEach
    public void ready() {
        // 여기서, 전역으로 선언된 변수를 초기화해서, 사용할수 있게 만들기
        // 다른 메서드안에서도, todoServiece 를 사용할수 있다.
        todoService = _0204_4_TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception {
        // 1) DB 서버에 일을 시키는 클래스를 미리 만들었다.
        // 2) 서비스 클래스를 만들어서, 어떤 기능을 하는지를 명확하게 메모화 했다
        // 3) 서비스에서, 기능들을 만들어서 1) 클래스에 연결시키기
        // 준비물) 글쓰기 -> 글제목, 날짜, 완료 여부 필요
        // 화면에서 데이터를 받고서 -> TodoDTO 에 담는다 -> 해당 서비스에 전달한다
        _0204_1_TodoDTO todoDTO = _0204_1_TodoDTO.builder()
                .title("샘플 제목, 오늘 점심 뭐 먹지?")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();
        // 2) 방법2. @Log4j2 로 확인하는 방법
        log.info("[Tests] : 로그 라이브러리 logd4j2 기능 테스트 ");
        log.info(todoDTO);

        todoService.register(todoDTO);
    }

}
