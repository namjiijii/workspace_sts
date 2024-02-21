package com.green.shop.member.controller;

import com.green.shop.member.service.MemberServiceImpl;
import com.green.shop.member.vo.MemberVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Resource(name="memberService")
    private MemberServiceImpl memberService;


    //회원등록
    @PostMapping("/insertMember")
    public String insertMember(MemberVO memberVO){
        //문자열 치환
        memberVO.setMemberTel(memberVO.getMemberTel().replace(",","-"));
        memberVO.setMemberEmail(memberVO.getMemberEmail().replace(",",""));

        System.out.println(memberVO);
        //회원가입 쿼리 실행
        memberService.insertMember(memberVO);
        return "redirect:/item/list";
    }
    //로그인 페이지로 이동
    @GetMapping("/loginForm")
    public String loginForm(){
        return "content/member/login";
    }
    //로그인
    @PostMapping("/login")
    public String login(MemberVO memberVO, HttpSession session){
        MemberVO loginInfo = memberService.login(memberVO);

        //세션에 데이터가 조회가 되지 않을 땐 null값이 들어옴
        //세션에 데이터가 조회가 됐을 땐 null값이 안 들어옴
        if (loginInfo != null){
            session.setAttribute("loginInfo", loginInfo);
        }


        return "content/member/login_result";
    }

    //비동기 통신 로그인
    @ResponseBody
    @PostMapping("/loginFetch")
    public String loginFetch(MemberVO memberVO, HttpSession session){
        MemberVO loginInfo = memberService.login(memberVO);

        //세션에 데이터가 조회가 되지 않을 땐 null값이 들어옴
        //세션에 데이터가 조회가 됐을 땐 null값이 안 들어옴
        if (loginInfo != null){
            session.setAttribute("loginInfo", loginInfo);
        }

        return loginInfo == null ? "" : loginInfo.getMemberId();
    }


    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginInfo");
        return "redirect:/item/list";
    }

}
