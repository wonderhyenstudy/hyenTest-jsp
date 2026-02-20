package com.busanit501.jsp_server_project1.springex_new_0219_keep.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 이 클래스는 XML 파일(root-context.xml 등)을 대신하는 자바 버전의 설계도다!
// @Configuration이 붙은 클래스 안에서 @Bean이 붙은 메소드를 만들면,
// 스프링이 그 메소드를 실행해서 나온 결과물을 스프링 창고(컨테이너)에 딱 하나만 저장해둡니다.
// 설정을 담당하는 클래스라고, 스프링(시스템에게) 알려주기
@Configuration // "이 클래스는 설정 파일이야!"
public class ModelMapperConfig {
    @Bean // "이 메소드가 리턴하는 객체를 창고에 보관해줘!"
    // build.gradle 에서 ModelMapper 설정해 줘서 쓰고 있다.
    // ModelMapper : 객체 간의 복사(Mapping)를 자동으로 해주는 기계
    // 일반 클래스 객체를 프링(시스템에게) 알려주기
    public ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();
        // 모델 맵퍼 사용하기 위한 , 기본 설정, (초기설정)한번만 설정 후, 재사용.
        modelMapper.getConfiguration()
            // dto <-> vo 클래스의 멤버의 일치 여부를 체크함.
            .setFieldMatchingEnabled(true)
            // 접근은 private 까지 가능하게
            .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
            // 매칭시, 검사시, 엄격하게 검사함.
            .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
