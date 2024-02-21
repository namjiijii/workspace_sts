package com.green.shop.member.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@ToString
public class MemberVO {
    private String memberId;
    private String memberPw;
    private String memberName;
    private String gender;
    private String memberEmail;
    private String memberTel;
    private String memberAddr;
    private String addrDetail;
    private String postCode;
    private String joinDate;
    private String memberRoll;

}
