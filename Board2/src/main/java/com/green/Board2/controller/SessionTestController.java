package com.green.Board2.controller;

import com.green.Board2.vo.MemberVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class SessionTestController {

    @GetMapping("/page1")
    public String page1(HttpSession session){
        //세션에 데이터 저장하기
        session.setAttribute("name", "java");
        session.setAttribute("age", 20);
        session.setAttribute("member", new MemberVO());
        //세션 유지시간 설정 : 초 단위
        session.setMaxInactiveInterval(60 * 30);
        return "page1";
    }

    @GetMapping("/page2")
    public String page2(HttpSession Session){
        //세션에 담긴 데이터 확인
        String name  = (String) Session.getAttribute("name");
        int age = (int) Session.getAttribute("age");
        MemberVO vo = (MemberVO) Session.getAttribute("member");

        //세션 데이터 삭제
        Session.removeAttribute("age");

        //모든 세션 데이터 삭제
        Session.invalidate();
        return "page2";
    }

    @GetMapping("/page3")
    public String page3(){
        return "page3";
    }
}
