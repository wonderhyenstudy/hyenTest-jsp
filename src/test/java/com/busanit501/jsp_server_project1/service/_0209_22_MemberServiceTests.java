package com.busanit501.jsp_server_project1.service;

import com.busanit501.jsp_server_project1._0209_todo.dto._0209_18_MemberDTO;
import com.busanit501.jsp_server_project1._0209_todo.service._0209_21_MemberService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class _0209_22_MemberServiceTests {
    private _0209_21_MemberService memberService;

    @BeforeEach
    public void ready() {
        // 여기서, 전역으로 선언된 변수를 초기화해서, 사용할수 있게 만들기
        // 다른 메서드안에서도, todoServiece 를 사용할수 있다.
        memberService = _0209_21_MemberService.INSTANCE;
    }

    @Test
    public void testLogin() throws Exception {
        // 조회할 tno 를 알고 있음.
        String mid = "lsy";
        String mpw = "1234";
        // 조회
        _0209_18_MemberDTO memberDTO = memberService.login(mid,mpw);
        log.info("멤버 서비스 로그인 테스트 memberDTO: " + memberDTO);

    }

    @Test
    public void testLogin2() throws Exception {
        String uuid = "f8da50d2-6734-49fe-b6be-51cfbe1809eb";

        _0209_18_MemberDTO memberDTO = memberService.getByUUID(uuid);
        log.info("uuid 를 이용한 조회 멤버 서비스 로그인 테스트2 memberDTO: " + memberDTO);

    }


}
