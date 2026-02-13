package com.busanit501.jsp_server_project1.dao;

import com.busanit501.jsp_server_project1._0209_todo.dao._0209_19_MemberDAO;
import com.busanit501.jsp_server_project1._0209_todo.domain._0209_17_MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
@Log4j2
public class _0209_20_MemberDAOTests {

    private _0209_19_MemberDAO memberDAO;

    @BeforeEach
    public void ready() {
        // 각 각의 단위테스트 메서드가 실행되기전에, 생성자 호출, 객체를 인스턴스화를 한다.
        memberDAO = new _0209_19_MemberDAO();
    }

    @Test
    public void testGetUser() throws Exception {
        // 조회할 tno 를 알고 있음.
        String mid = "lsy";
        String mpw = "1234";
        // 조회
        _0209_17_MemberVO memberVO = memberDAO.getWithPassword(mid,mpw);
        log.info("임시 로그인, 유저 조회 결과 : " + memberVO);

    }

    @Test
    public void testGetUserWithUUID() throws Exception {
        // 조회할 tno 를 알고 있음.
        String uuid = "f8da50d2-6734-49fe-b6be-51cfbe1809eb";
        // 조회
        _0209_17_MemberVO memberVO = memberDAO.selectUUID(uuid);
        log.info("uuid 이용해서 임시 로그인, 유저 조회 결과 : " + memberVO);

    }
}