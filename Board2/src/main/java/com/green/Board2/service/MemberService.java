package com.green.Board2.service;

import com.green.Board2.vo.MemberVO;

public interface MemberService {


    void insertMember(MemberVO memberVO);

    MemberVO login(MemberVO memberVO);
}
