package com.busanit501.jsp_server_project1._0205_todo.service;

import com.busanit501.jsp_server_project1._0205_todo.dao._0205_3_TodoDAO;
import com.busanit501.jsp_server_project1._0205_todo.domain._0205_4_TodoVO;
import com.busanit501.jsp_server_project1._0205_todo.dto._0205_2_TodoDTO;
import com.busanit501.jsp_server_project1._0205_todo.util._0205_8_MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2 // 로그 기록 확인. src/main/resources/log4j2.xml
public enum _0205_1_TodoService {
    INSTANCE; // static final 생략이 되어있다.

    /////////////////////////////////////////////////////////////////

    // 0204, 1 기능추가. 클래스 가져오기
    // 1) DB 서버에 작업을 시키는 클래스를 가져오기. 선언만 했음.
    // 나중에 쓸때는 아래에서 초기화 해서 써야함
    private _0205_3_TodoDAO dao;

    // 2) DTO <- VO 클래스를 변환 해주는 기능 클래스
    // _0204_3_MapperUtil 에서 구현해 놨다. 가져와서 쓰자
    // ModelMapper
    // 서로 다른 클래스의 데이터를 분석하여 한 객체의 필드 값을 다른 객체의 필드로 자동으로 복사(매핑)해주는 라이브러리

    private ModelMapper modelMapper;


    // 0204, 2 생성자 호출
    _0205_1_TodoService() {
        // 위에서 전역으로 선언만
        dao = new _0205_3_TodoDAO();
        modelMapper = _0205_8_MapperUtil.INSTANCE.get();
    }

    /////////////////////////////////////////////////////////////////



    // 0204, 3 기능 변경해서 사용하기
    // 기능구현,
    // 글쓰기
    public void register(_0205_2_TodoDTO todoDTO) throws Exception {
        // todoDTO -> todoVo 변환
        // "이 VO 안에 들어있는 title, tno 같은 값들을 읽어서,
        // 똑같은 이름을 가진 TodoDTO 객체를 새로 만들어서 채워줘!"라는 뜻입니다.
        _0205_4_TodoVO todoVO = modelMapper.map(todoDTO, _0205_4_TodoVO.class);

        // 1) 방법1. 변환 확인.
//        System.out.println("_0204_4_TodoService에서 register 작업중, 변환 결과 확인 todoVO : " + todoVO);
        // 2) 방법2. @Log4j2 로 확인하는 방법
        log.info("[Service] : _0204_4_TodoService에서 register 작업중, 변환 결과 확인 todoVO : " + todoVO);

        // DB 에 작업 시키는 클래스를 이용해서, DB 서버에 쓰기 작업하기.
        // 기본 메서드에, 예외처리를 가능하게 변경.
        dao.insert(todoVO);

    }

    // 목록조회
    // 이전 코드
    public List<_0205_2_TodoDTO> getList() {
        // 하드코딩, 더미 데이터로, 10개만 샘플 등록,
        // 반복문으로
        List<_0205_2_TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(
                i -> {
                    // todo 하나가, todoDTO 객체. 임시 객체 생성해서, 여기에 더미 값을 담기.
                    _0205_2_TodoDTO dto = new _0205_2_TodoDTO();
                    dto.setTno((long)i);
                    dto.setTitle("Todo.." + i);
                    dto.setDueDate(LocalDate.now());
                    return dto;
                }
        ).collect(Collectors.toList());// mapToObj 닫기 태그, 반복문으로 각각의 todo 객체를 생성해서, 리스트로 만들기.
        return todoDTOS;
    } //getList 닫기

    // 변경 코드
    // 전체 목록 조회 , 실제 데이터베이스에 가져오기.
    public List<_0205_2_TodoDTO> listAll() throws Exception {
        // 하드코딩, 더미 데이터로, 10개만 샘플 등록,
        List<_0205_4_TodoVO> voList = dao.selectAll();
        log.info("voList 확인 : " + voList);

        // DAO 로 데이터베이스에 데이터를 가져오면, 타입을 _0204_2_TodoVO 타입으로 받음
        // 화면에 전달하기 위해서, DTO 타입으로 변환 ,
        // 변환작업.
        // 작업 순서
        // 1) voList 에 있는 모든 요소를 순회합니다.
        // 2) 리스트에서, 요소를 하나씩 꺼내서, vo -> dto 타입으로 변환합니다. 모든 요소를.
        // 3) 변환된 요소들을 묶어서, 리스트로 변경합니다.
        // 4) 재할당. ->  List<_0204_1_TodoDTO> dtoList
        List<_0205_2_TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, _0205_2_TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    } //listAll 닫기



    // Todo 조회
    // 화면에서, 무엇을 조회할지를 알고 있다. 예시) tno =1
    public _0205_2_TodoDTO get(Long tno) throws Exception {
        //객체 생성
        _0205_2_TodoDTO dto = new _0205_2_TodoDTO();
        // DB로부터 전달 받아서, 사용
        _0205_4_TodoVO todoVO =  dao.selectOne(tno);
        //vo -> dto 타입으로, 모델 맵퍼 이용해서, 변환.
        _0205_2_TodoDTO todoDTO = modelMapper.map(todoVO, _0205_2_TodoDTO.class);




        // 20260205 이전방법
//        // 전달 받은 tno 번호로 임시 번호 설정,
//        dto.setTno(tno);
//        // 임시 제목
//        dto.setTitle("샘플 Todo 더미 데이터" + tno);
//        // 임시날짜, 현재날짜.
//        dto.setDueDate(LocalDate.now());
//        // 임시 완료여부
//        dto.setFinished(true);

        return todoDTO;
    }

    //수정하기
    public void modify(_0205_2_TodoDTO todoDTO) throws Exception{
        log.info("[modify] todoDTO : " + todoDTO );
        // dto -> vo 타입으로 변경.
        _0205_4_TodoVO todoVO = modelMapper.map(todoDTO , _0205_4_TodoVO.class);
        // dao 의 도움을 받아서, DB 서버에게 일 시키기
        dao.updateOne(todoVO);
    }

    //삭제하기
    public void remove(Long tno) throws Exception{
        log.info("[remove] 삭제할 tno 번호 : " + tno);
        dao.deleteOne(tno);
    }



} //_4_TodoService 닫기
