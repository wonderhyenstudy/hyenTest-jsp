//package com.busanit501.jsp_server_project1.springex_0213.sample;
//
//import com.busanit501.jsp_server_project1.springex_0212.sample._1_SampleDAO_0212;
//import lombok.RequiredArgsConstructor;
//import lombok.ToString;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//// 시스템에 등록. 어떤용도??? 이 클래스가 서비스로 사용된다고 표현.
//// 서버가 시작시, 해당 객체를 활성화 한다
//
//// 방법1
//// 변경 전: 필드 주입 방식]
//// 코드는 짧지만, 외부에서 객체를 변경하기 어렵고 테스트가 힘듭니다.
////@Service
////public class _2_SampleService_0212 {
////    @Autowired
////    private _1_SampleDAO_0212 sampleDAO;
////}
//
//// [변경 후: 생성자 주입 방식 (권장)]
////@Service
////@Log4j2
////public class _2_SampleService_0212 {
////
////// 1. final 키워드를 사용하여 불변성 확보
////private final _1_SampleDAO_0212 sampleDAO;
////
////// 2. 생성자를 통해 주입 (Spring 4.3+ 에서는 @Autowired 생략 가능)
////public _2_SampleService_0212(_1_SampleDAO_0212 sampleDAO) {
////    this.sampleDAO = sampleDAO;
////}
//
//// 방법2
////@Service
////@RequiredArgsConstructor // final이 붙은 필드들을 모아 생성자를 자동으로 만들어줌
////public class _2_SampleService_0212 {
////    private final _1_SampleDAO_0212 sampleDAO;
////// 생성자 코드가 눈에 안 보이지만 실제로는 생성되어 작동함
////}
//
//// 방법3
//// 가장 안전하고 선호하는 방법. 실무에서 많이 사용하는 패턴
//// 실무에서는 생성자 코드를 일일이 짜는 것도 번거로워
//// Lombok의 @RequiredArgsConstructor를 함께 사용합니다.
//@Service
//@ToString
//@RequiredArgsConstructor
//public class _2_SampleService_0212 {
//    @Qualifier("normal")
////    @Qualifier("event")
//    private final _1_SampleDAO_0212 sampleDAO0212;
//}
//
//
//
//
