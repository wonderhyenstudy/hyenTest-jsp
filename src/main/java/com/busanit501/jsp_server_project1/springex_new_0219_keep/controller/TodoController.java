package com.busanit501.jsp_server_project1.springex_new_0219_keep.controller;

import com.busanit501.jsp_server_project1.springex_new_0219_keep.dto.PageRequestDTO;
import com.busanit501.jsp_server_project1.springex_new_0219_keep.dto.PageResponseDTO;
import com.busanit501.jsp_server_project1.springex_new_0219_keep.dto.TodoDTO;
import com.busanit501.jsp_server_project1.springex_new_0219_keep.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
// http://localhost:8080/todo2/ 관련된 업무는 내가 처리할게.
@RequestMapping("/todo2")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // http://localhost:8080/todo2/list
    // 뷰 리졸버가 연결되어서,
    // todo2/list -> WEN-INF/views/todo2/list.jsp 연결 설정됨.

    // 페이징처리 전 리스트 20260224
//    @RequestMapping("/list")
//    public void list(Model model) {
//
//        log.info("todo2 list...");
//        List<TodoDTO> dtoList = todoService.getAll();
//        // 서버 -> 화면에 데이터 목록들을 전달. 박스 이름 : dtoList, 내용물: DB에서 받아온 목록들
//        model.addAttribute("dtoList",dtoList);
//    }

    // 페이징 처리 후, 목록 조회
    // 페이징 처리가 된 목록 조회로 변경. 기존에 페이징 처리가 안된 그냥 조회.
    // 화면으로 부터, 보고 있는 페이지 번호를 받는다, page, size 받는다, 낱개로 받기 싫어서, DTO 로 받는다.
    // PageRequestDTO
    // 스프링에서는 기본적으로 매개변수의 클래스 타입을 화면으로 전달함: PageRequestDTO pageRequestDTO
    @RequestMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult,
                     Model model) {
        log.info("pageRequestDTO : " + pageRequestDTO);
        log.info("todo2 list...페이징 처리가 된 리스트 조회");
        // 유효성 체크에 걸린다면
        if(bindingResult.hasErrors()) {
            // 잠시 대기. 추후 작업 할 예정.
            pageRequestDTO = PageRequestDTO.builder().build();
        }

        PageResponseDTO<TodoDTO> responseDTO = todoService.getList(pageRequestDTO);
        // 서버 -> 화면에 데이터 목록들을 전달. 박스 이름 : responseDTO, 내용물: DB에서 받아온 목록들
        model.addAttribute("responseDTO",responseDTO);
    }



    // http://localhost:8080/todo2/read?tno=38 : 하나 조회 화면
    // http://localhost:8080/todo2/modify?tno=38 : 수정폼 화면
//    @GetMapping("/read")
    // 재사용,
    // modify.jsp 화면만 추가하면됨. (read.jsp, modify.jsp 화면이 거의 비슷함), 재사용.
    @GetMapping({"/read", "/modify"})
//    public void read(Long tno, Model model) {
    // 서버 -> 화면으로, 해당 데이터 전달 : pageRequestDTO
    public void read(Long tno, PageRequestDTO pageRequestDTO, Model model) {
        log.info("todo2 read...");
        TodoDTO todoDTO = todoService.getOne(tno);
        // 서버 -> 화면에 데이터 목록들을 전달. 박스 이름 : dto, 내용물: DB에서 받아온 목록들
        model.addAttribute("dto",todoDTO);
    }

    @PostMapping("/delete")
    // 수정 화면에서, 삭제시 -> 히든으로 숨겨둔 페이지, 사이즈 정보를, page, size 전달을 하면
    // PageRequestDTO 가 자동으로 데이터를 맵핑을 함
    public String delete(Long tno, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes) {
        log.info("삭제 포스트 처리 작업 ");
        log.info("삭제할 tno 번호 확인 : " + tno);

        // 실제 삭제 기능은 아직 미구현,
        todoService.remove(tno);

        // 서버에서 -> 화면으로 데이터를 전달시, 쿼리 스트링으로 전달하는 방법.
//        redirectAttributes.addAttribute("page",1); // 1페이지로 이동
        redirectAttributes.addAttribute("page",pageRequestDTO.getPage()); // 현재 보고 있는 페이지로 이동.
        redirectAttributes.addAttribute("size",pageRequestDTO.getSize());

        return "redirect:/todo2/list?" + pageRequestDTO.getLink();
    }

    //    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    // 뷰 리졸버가 연결되어서,
    // todo2/list -> WEN-INF/views/todo2/register.jsp 연결 설정됨.
    public void getRegister() {
        log.info("todo register..get");
    }

    @PostMapping("/register")
    // 유효성 체크시, 주의사항, !) @Valid TodoDTO todoDTO, BindingResult bindingResult, 순서 주의!!!
    public String postRegister(@Valid TodoDTO todoDTO, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        log.info("todo2 register..post");
//        log.info("todoDTO : " + todoDTO);
//        boolean finishedBoolean = todoDTO.isFinished();
//        if (finishedBoolean){
//        todoDTO.setFinished(finishedBoolean);
//        }
        // 유효성 체크
        if(bindingResult.hasErrors()) {
            log.info("유효성 오류가 있습니다. ");
            // 서버에서 화면으로 임시 데이터를 전달. 박스이름: errors, 박스 내용물: 오류가 난 이유.
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            return "redirect:/todo2/register";
        }

        log.info("todoDTO2 : " + todoDTO);
        // 서비스의 도움을 받아서, 화면으로 부터 전달 받은 데이터를 전달하기.
        todoService.register(todoDTO);

        log.info(" 유효성 통과한 데이터 todoDTO : " + todoDTO);
        return "redirect:/todo2/list";
    }

    @PostMapping("/modify")
    // 유효성 체크시, 주의사항, !) @Valid TodoDTO todoDTO, BindingResult bindingResult, 순서 주의!!!
    // 수정 화면에서, 수정시 -> 히든으로 숨겨둔 페이지, 사이즈 정보를, page, size 전달을 하면
    // PageRequestDTO 가 자동으로 데이터를 맵핑을 함
    public String postModify(@Valid TodoDTO todoDTO, BindingResult bindingResult,
                             PageRequestDTO pageRequestDTO,
                               RedirectAttributes redirectAttributes) {
        log.info("todo2 modify..post");

        // 완료여부, 체크박스의 넘어온 값 : 문자열 : "on"
        // 따로 클래스를 만들어서, 등록하기


        // 유효성 체크
        if(bindingResult.hasErrors()) {
            log.info("유효성 오류가 있습니다. ");
            // 서버에서 화면으로 임시 데이터를 전달. 박스이름: errors, 박스 내용물: 오류가 난 이유.
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            redirectAttributes.addAttribute("page",pageRequestDTO.getPage()); // 현재 보고 있는 페이지로 이동.
            redirectAttributes.addAttribute("size",pageRequestDTO.getSize());
            return "redirect:/todo2/modify";
        }

        log.info("todoDTO2 : " + todoDTO);
        // 서비스의 도움을 받아서, 화면으로 부터 전달 받은 데이터를 전달하기.
        todoService.modify(todoDTO);

        log.info(" 유효성 통과한 데이터 todoDTO : " + todoDTO);
        // 서버에서 -> 화면으로 데이터를 전달시, 쿼리 스트링으로 전달하는 방법.
        redirectAttributes.addAttribute("page",pageRequestDTO.getPage()); // 현재 보고 있는 페이지로 이동.
        redirectAttributes.addAttribute("size",pageRequestDTO.getSize());
        // 상세보기로 이동시, 해당 tno 번호가 필요하므로, 이것도 쿼리스트링으로, 서버에서 화면으로 전달하기
        redirectAttributes.addAttribute("tno",todoDTO.getTno());
//        return "redirect:/todo2/list";
        return "redirect:/todo2/read";
    }



}
