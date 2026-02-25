package com.busanit501.jsp_server_project1.mapper;

import com.busanit501.jsp_server_project1.springex_new_0219_keep.domain.TodoVO;
import com.busanit501.jsp_server_project1.springex_new_0219_keep.dto.PageRequestDTO;
import com.busanit501.jsp_server_project1.springex_new_0219_keep.mapper.TodoMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2 // 로그를 기록하는데, 어떤 기준으로 하나요??? 로그레벨
// info, debug, warning
// 로그 레벨 계층: (낮음) TRACE < DEBUG < INFO < WARN < ERROR < FATAL (높음)
@ExtendWith(SpringExtension.class) // Junit5 단위 테스트 기능 통합 설정.
// 빈을 등록한 파일의 위치를 지정, 그래서 단위 테스트 할 때, 해당파일을 참고해서, 테스트해줘
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {

    @Autowired(required = false)
    // 해당 객체를 활성화를 못하더래도, 예외를 발생 안시키고, null 로 할당 하겠다.
    private TodoMapper todoMapper;

    @Test
    public void testGetTime() {
        log.info("시간 확인으로 마이바티스 임시 연결 확인 : " + todoMapper.getTime());
    }

    @Test
    public void testInsert() {
        // 준비물, 화면에서 넘겨받은 TodoVO 있다고 가정, 또는 더미 데이터 준비.
        TodoVO todoVO = TodoVO.builder()
                .title("오늘 점심 뭐 먹죠?")
                .dueDate(LocalDate.now())
                .writer("이상용")
                .build();
        todoMapper.insert(todoVO);
    }

    @Test
    public void testSelectAll(){
        List<TodoVO> voList = todoMapper.selectAll();
        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectOne(){
        TodoVO todoVO = todoMapper.selectOne(49L);
        log.info(todoVO);
    }

    @Test
    public void testDeleteOne() {
    // 각자 데이터베이스에 있는 tno 번호 확인 후 , 테스트 진행하기.
        todoMapper.delete(38L);
    }

    @Test
    public void testDelete() {
        // 준비물, 화면에서 넘겨받은 TodoVO 있다고 가정, 또는 더미 데이터 준비.
        TodoVO todoVO = TodoVO.builder()
                .tno(50L)
                .title("바뀌니")
                .dueDate(LocalDate.of(2026,3,2))
                .finished(true)
                .build();
        todoMapper.update(todoVO);
        log.info("========== 수정");
        log.info(todoVO);
    }

    @Test
    public void testUpdate() {
        // 준비물, 화면에서 넘겨받은 TodoVO 있다고 가정, 또는 더미 데이터 준비.
        TodoVO todoVO = TodoVO.builder()
                .tno(50L)
                .title("또또 안 바뀌니???")
                .dueDate(LocalDate.of(2026,3,2))
                .finished(true)
                .build();
        todoMapper.update(todoVO);
    }

    // 페이징 처리가 된 목록 조회
    @Test
    public void testSelectList() {
    // 화면에서 전달 받은 페이지네이션을 위한 준비물 , 준비.
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(2)
                .size(10)
                .build();

        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        voList.forEach(vo -> log.info(vo));
    }

    // 전체 갯수 조회
    @Test
    public void testSelectListCount() {
        // 화면에서 전달 받은 페이지네이션을 위한 준비물 , 준비.
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        int resultCount = todoMapper.getCount(pageRequestDTO);
        log.info("전체갯수 : " + resultCount);
    }

    // 타입에 따른 검색 연습,
    @Test
    public void testSelectSearch() {
        // 검색시 준비물, 검색어 , 타입
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .types(new String[]{"t","w"})
                .keyword("점심")
                .finished(true)
                .from(LocalDate.of(2026,02,01))
                .to(LocalDate.of(2026,02,28))
                .build();

        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        voList.forEach(vo -> log.info(vo));
        log.info("검색테스트");
        // 전체 갯수
        log.info(todoMapper.getCount(pageRequestDTO));
    }



}
