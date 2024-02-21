package com.green.DbTest.service;

import com.green.DbTest.vo.StudentVO;

import java.util.List;

//인터페이스 : 기능 정의
//인터페이스는 public을 안 붙여도 알아서 붙는다.
public interface StudentService {

    //학생 한 명을 저장하는 기능
    void insertStudent();

    //학생 한 명을 삭제하는 기능
    void deleteStudent();

    //입력 받은 값으로 학생 삭제 기능
    void delete(int stuNo);

    //학번이 1번인 학생의 이름 조회
    String selectName();

    //학번이 1번인 학생의 점수 조회
    int selectScore();

    //학번이 1번인 학생을 조회
    StudentVO selectStu();

    //모든 학생 정보 조회
    List<StudentVO> selectStuList();

}
