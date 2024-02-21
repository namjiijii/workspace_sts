package com.green.StudentManager.service;

import com.green.StudentManager.vo.StuVO;

import java.util.List;

public interface StuService {

    //SELETC 리턴 : 매번 달라짐
    //INSERT, DELETE , UPDATE : void , int(정석) 변화된 값을 숫자로 받기때문에

    //리턴 타입 : 쿼리 실행 결과를 받아옴
    ///INSERT, DELETE , UPDATE는 쿼리 실행 결과가
    //몇 개의 행이 삽입, 삭제, 수정 되었는지 보여줌
    //그래서 위 세개의 쿼리 결과 리턴 타입은 무조건 int, void
    //SELECT는 어떤 쿼리인지에 따라서 리턴 타입이 달라짐
    //조회 결과 데이터가 0행 혹은 1행일 경우 리턴 타입 : vo클래스
    //조회 결과 데이터 행의 개수가 매번 다른 경우 리턴 타입 : List<vo>

    //매개변수 : 쿼리 실행 시 빈 값을 채우는 역할
    //빈 값을 채울 데이터가 0개, 1개, 여러개 구분
    //빈 값 0개 : 매개변수 필요없음
    //빈 값 1개
    //1) 빈 값의 자료형인 숫자인 경우
    //   매개변수로 int 자료형 하나
    //2) 빈 값의 자료형인 문자열인 경우
    //   매개변수로 String 자료형 하나
    //빈 값 여러개인 경우는 vo객체

    //학생 등록
    int insertStu(StuVO stuVO);

    //학생 목록 조회
    List<StuVO> selectStuList();


    StuVO selectStu(int stuNo);

    int deleteStu(int stuNo);
}
