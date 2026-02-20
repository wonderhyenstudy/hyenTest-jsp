package com.busanit501.jsp_server_project1.mapper;

import com.busanit501.jsp_server_project1.springex_0212.mapper.TimeMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2 // 로그를 기록하는데, 어떤 기준으로 하나요??? 로그레벨
// info, debug, warning
// 로그 레벨 계층: (낮음) TRACE < DEBUG < INFO < WARN < ERROR < FATAL (높음)
@ExtendWith(SpringExtension.class) // Junit5 단위 테스트 기능 통합 설정.
// 빈을 등록한 파일의 위치를 지정, 그래서 단위 테스트 할 때, 해당파일을 참고해서, 테스트해줘
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TimeMapperTests_bk20260212 {

    @Autowired(required = false)
    // 해당 객체를 활성화를 못하더래도, 예외를 발생 안시키고, null 로 할당 하겠다.
    private TimeMapper timeMapper;

    @Test
    public void testGetTime() {
        log.info("시간 확인으로 마이바티스 임시 연결 확인 : " + timeMapper.getTime());
    }

}
