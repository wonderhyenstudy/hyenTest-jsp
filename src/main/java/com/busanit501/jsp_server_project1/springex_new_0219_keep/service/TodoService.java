package com.busanit501.jsp_server_project1.springex_new_0219_keep.service;

import com.busanit501.jsp_server_project1.springex_new_0219_keep.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    // 추가 20260220
    // 화면에서, 입력된 정보를 받기 -> DT에 담기 -> VO 변환 -> DB 에 전달
    void register(TodoDTO todoDTO);

    // 전체 목록
    List<TodoDTO> getAll();

    // 하나 조회
    TodoDTO getOne(Long tno);

    // 삭제
    void remove(Long tno);

    // 수정하기
    void update(TodoDTO todoDTO);

}
