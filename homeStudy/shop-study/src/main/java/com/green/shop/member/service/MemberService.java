package com.green.shop.member.service;

import com.green.shop.member.vo.MemberVO;

public interface MemberService {

    //회원가입
    void insertMember(MemberVO memberVO);

    //회원가입
    MemberVO login(MemberVO memberVO);
}
