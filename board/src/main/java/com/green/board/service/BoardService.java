package com.green.board.service;

import com.green.board.vo.BoardVO;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface BoardService {

    //게시글 목록 조회
    List<BoardVO> selectBoardList();

    //게시글 등록
    void insertBoard(BoardVO boardVO);

    //게시글 상세 조회
    BoardVO selectBoardDetail(int boardNum);

    void deleteBoard(int boardNum);

    void updateBoard(BoardVO boardVO);

}
