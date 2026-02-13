package com.busanit501.jsp_server_project1._0209_todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode를 한 번에 생성
@Data
// 간단하게 객체를 생성
// @Setter 없이도 객체를 생성
@Builder
// 클래스의 모든 필드를 인자로 받는 생성자
@AllArgsConstructor
// 파라미터가 없는 기본 생성자를 생성 : 기본생성자
@NoArgsConstructor
public class _0209_18_MemberDTO {
    // 데이터베이스의 컬럼과 동일하게 작업.
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
}