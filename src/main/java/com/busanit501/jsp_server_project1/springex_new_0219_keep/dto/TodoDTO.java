package com.busanit501.jsp_server_project1.springex_new_0219_keep.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

// @Getter, @Setter, @ToString, @EqualsAndHashCode,
// @RequiredArgsConstructor를 모두 포함하는 복합 어노테이션입니다
@Data
@Builder // 객체 생성을 체인 기법을 이용해서, 편하게 작업하기 위해서 사용함.
@NoArgsConstructor // 기본 생성자를 생성함.
@AllArgsConstructor // 모든 멤버를 매개변수로 가지는 생성자를 생성함.
public class TodoDTO {
    private Long tno;

    //  null과 ""(빈 문자열)을 허용하지 않습니다. (단, " " 스페이스바 공백은 통과됨)
    @NotEmpty
    private String title;
    // / @Past: 미래 날짜 / 과거 날짜만 허용 (예: 회원가입일은 미래일 수 없음)

    @Future
    private LocalDate dueDate;

    private boolean finished;

    // (가장 강력함) null, "", " " 모두 허용하지 않습니다. 문자열 검사할 때 가장 많이 씁니다.
    @NotBlank
    private String writer;
}
