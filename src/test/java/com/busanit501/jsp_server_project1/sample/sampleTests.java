package com.busanit501.jsp_server_project1.sample;

import com.busanit501.jsp_server_project1.springex_0212.sample._2_SampleService_0212;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Log4j2 // 로그를 기록하는데, 어떤 기준으로 하나요??? 로그레벨
// info, debug, warning
// 로그 레벨 계층: (낮음) TRACE < DEBUG < INFO < WARN < ERROR < FATAL (높음)
@ExtendWith(SpringExtension.class) // Junit5 단위 테스트 기능 통합 설정.
// 빈을 등록한 파일의 위치를 지정, 그래서 단위 테스트 할 때, 해당파일을 참고해서, 테스트해줘
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")

public class sampleTests {
    @Autowired // 자동으로 해당 객체를 연결하겠다.
    // (root-context.xml 에  객체 등록을 이미 햇음.
    // 활성화( 객체로 치면 생성자 호출)
    // 그렇다면?? 그전에는 어떻게 햇지???
    // 외부 클래스는 전역으로 선언해준다음
    // 메소드 생성 후 new 로 직접 객체생성을 해줘서 썻다

    // 현재는 root-context.xml 에 클래스 등록후
    // 선언 해주고 사용한다
    
    // 직접하냐 vs 빈에서 등록만 하고 사용하냐~   의 차이

    // (root-context.xml , 객체 등록 했음, 서버 시작시, 활성화(객체로 치면 생성자 호출)

    //의존성 주입
    private _2_SampleService_0212 sampleService0212;

    // 데이터베이스 연결 객체를 서버 시작시, 활성화가 되니, 우리는 연결안함
    @Autowired
    private DataSource dataSource; // 느슨한 결합


    @Test
    public void testService1() {
        log.info("실제 객체가 활성화가 되었는지 여부를 객체를 조회해보기," + sampleService0212);
        Assertions.assertNotNull(sampleService0212);
    }

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        log.info("testConnection : " + connection);
        Assertions.assertNotNull(connection);
        connection.close();
    }










}
