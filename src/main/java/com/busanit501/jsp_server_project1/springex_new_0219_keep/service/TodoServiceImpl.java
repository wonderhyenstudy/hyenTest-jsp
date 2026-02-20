package com.busanit501.jsp_server_project1.springex_new_0219_keep.service;

import com.busanit501.jsp_server_project1.springex_new_0219_keep.domain.TodoVO;
import com.busanit501.jsp_server_project1.springex_new_0219_keep.dto.TodoDTO;
import com.busanit501.jsp_server_project1.springex_new_0219_keep.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

// 서비스는, 직접적으로 DB에 insert 기능이 있나요?
// 아니요. 어떻게 ? 1) 직접 만들기 2) 만들어진 것 가져와서 이용한다.
// 1) TodoMapper 2) DTO -> VO 변환 도구 : ModelMapper
// 어떻게 가져오죠? 포함 관계, 다른 클래스의 객체를 가져오고,
// 연결? 1)오토와이어드 2) 롬복을 이용해서, 생성자 주입 방식.
//2)을 이용해서, 연결하기.
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    // 화면에서, 입력된 정보를 받기 -> DTO담기 -> VO 변환 -> DB 에 전달.
    // 화면에서 전달받은 데이터를 가공해서 DB 창고에 넣는 과정
    // DTO 상자를 받아서, 내용을 VO 상자로 옮겨 담은 뒤, 창고(DB)에 넣는 과정입니다.
    // TodoDTO (택배 상자): 고객(사용자)이 화면에서 정성스럽게 싸서 보낸 상자입니다.
    // TodoVO (창고 규격 상자): 우리 회사 DB 창고에 넣으려면 반드시 이 규격의 상자여야만 합니다.
    // 화면에서 온 DTO를 받아서, ModelMapper라는 기계로 DB 규격인 VO로 변환한 다음,
    // MyBatis 통로를 통해 실제 DB에 Insert 하는 과정"입니다.
    @Override
    public void register(TodoDTO todoDTO) {
        log.info("서비스 작업: insert 기능 작업중. ");
        // 변환
        // 객체 변환(Mapping). 왜햐나?? 화면용(DTO)과 DB용(VO/Entity)은 용도가 다르기 때문
        // 옛날방식 -> vo.setTitle(dto.getTitle())
        // 현재방식 맵퍼로 간단하게-> ModelMapper가 이름이 같은 필드를 찾아서 자동으로 값을 복사
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info("서비스 작업: insert 기능 변환된 todoVO : " + todoVO);
        // 넣어주기
        // DB 저장 실행
        // TodoMapper.xml에 적힌 INSERT SQL 문장을 실행하라고 명령
        // 여기서 todoVO를 던져주면, MyBatis가 XML의 #{title}, #{dueDate} 자리에 값을 쏙쏙 박아넣습니다.
        todoMapper.insert(todoVO);

    }

    @Override
    public List<TodoDTO> getAll() {
        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }
}

