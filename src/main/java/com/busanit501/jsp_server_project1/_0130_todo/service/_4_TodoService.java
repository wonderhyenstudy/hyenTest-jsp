package com.busanit501.jsp_server_project1._0130_todo.service;

import com.busanit501.jsp_server_project1._0130_todo.dto._3_TodoDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum _4_TodoService {
    INSTANCE; // static final 생략이 되어있다.

    // 기능구현,
    // 글쓰기
    public void register(_3_TodoDTO todoDTO) {
        System.out.println("서비스 기능, 글쓰기 기능, " +
                "사용자가 일정을 입력하면, todoDTO 라는 객체에 담겨서, 전달을 받습니다." +
                "꺼내서 사용하면됩니다. 뼈대만 구성.");
        System.out.println("todoDTO : " + todoDTO);
    }
    // 목록조회

    // 코드의 복잡한 부분을 쉽게 풀면 이렇습니다:
//    List<_3_TodoDTO> list = new ArrayList<>(); // 빈 리스트 준비
//
//    for(int i=0; i<10; i++) { // 10번 반복하자!
//            _3_TodoDTO dto = new _3_TodoDTO(); // 빈 바구니 만들어서
//            dto.setTno((long)i);               // 번호 매기고 (0, 1, 2...)
//            dto.setTitle("Todo.." + i);        // 제목 붙이고 (Todo..0, Todo..1...)
//            dto.setDueDate(LocalDate.now());   // 오늘 날짜 도장 쾅!
//            list.add(dto);                     // 리스트에 담기
//        }
//    return list; // 10개가 담긴 리스트 반환!


    public List<_3_TodoDTO> getList() {
        // 하드코딩, 더미 데이터로, 10개만 샘플 등록,
        // 반복문으로
        List<_3_TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(
                i -> {
                    // todo 하나가, todoDTO 객체. 임시 객체 생성해서, 여기에 더미 값을 담기.
                    _3_TodoDTO dto = new _3_TodoDTO();
                    dto.setTno((long)i);
                    dto.setTitle("Todo.." + i);
                    dto.setDueDate(LocalDate.now());
                    return dto;
                }
        ).collect(Collectors.toList());// mapToObj 닫기 태그, 반복문으로 각각의 todo 객체를 생성해서, 리스트로 만들기.
        return todoDTOS;
    } //getList 닫기
} //_4_TodoService 닫기
