package com.example.FetchStudent.service;

import com.example.FetchStudent.vo.ClassVO;
import com.example.FetchStudent.vo.ScoreVO;
import com.example.FetchStudent.vo.StuVO;

import java.util.List;

public interface StuService {
    //학급 목록 조회
    List<ClassVO> selectClassList();

    List<StuVO> selectStuList(StuVO stuVO);



    StuVO selectStuDetail(int stuNum);

    //점수 정보 조회
    ScoreVO selectScoreInfo(int stuNum);

    //점수 등록
    void insertScore(ScoreVO scoreVO);
}
