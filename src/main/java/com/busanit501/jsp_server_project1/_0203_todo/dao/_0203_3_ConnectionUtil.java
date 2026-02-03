package com.busanit501.jsp_server_project1._0203_todo.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

// HikariCP를 사용하여 데이터베이스 연결(Connection)을 효율적으로 관리하는 전형적인 유틸리티 클래스
public enum _0203_3_ConnectionUtil {
    // INSTANCE 하나만 선언하여 클래스가 메모리에 딱 한 번만 올라가도록 보장했습니다.
    INSTANCE;

    private HikariDataSource ds; // DB에 연결하는 도구

    // 생성자
    _0203_3_ConnectionUtil() {
        // HikariConfig 클래스 이용해서, 옵션 설정.
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");

        // PreparedStatement 캐시 설정
        // 데이터 베이스에서 사용하는 sql 문장을 반복적으로 사용하는 것을 캐시 (저장해서) 사용하겠다.
        // - **개념**: PreparedStatement 캐싱 기능을 활성화하는 기본 옵션입니다.
        config.addDataSourceProperty("cachePrepStmts", "true");
        // 각 연결(Connection)당 캐시할 수 있는 PreparedStatement의 최대 개수입니다.
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        //- **개념**: 캐시할 수 있는 SQL 문의 최대 길이(문자 수)입니다.
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        // 위에 설정값을 바탕으로 커넥션 풀을 생성
        // 이제 ds가 미리 DB 연결을 여러 개 만들어 두고 관리하는 역할을 합니다.
        //HikariDataSource 클래스에, 위의 설정 클래스를 담아주기
        ds = new HikariDataSource(config);
    }

    // 외부(DAO 등)에서 DB 작업이 필요할 때 호출하는 창구입니다.
    public Connection getConnection() throws Exception {
        return ds.getConnection();
    }

}
