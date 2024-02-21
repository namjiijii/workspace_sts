package com.green.Board2.service;

import com.green.Board2.vo.BoardVO;
import com.green.Board2.vo.SearchVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public void insertBoard(BoardVO boardVO) {
        sqlSession.insert("boardMapper.insertBoard", boardVO);
    }


    @Override
    public List<BoardVO> selectBoardList(SearchVO searchVO) {
        List<BoardVO> list = sqlSession.selectList("boardMapper.selectBoardList", searchVO);
        return list;
    }

    @Override
    public BoardVO selectBoardOne(int boardNum) {
        BoardVO result = sqlSession.selectOne("boardMapper.selectBoardOne", boardNum);
        return result;
    }

    @Override
    public void deleteBoard(int boardNum) {
        sqlSession.delete("boardMapper.deleteBoard", boardNum);
    }

    @Override
    public void updateBoard(BoardVO boardVO) {
        sqlSession.update("boardMapper.updateBoard",boardVO);
    }

    @Override
    public void updateReadCnt(int boardNum) {
        sqlSession.update("boardMapper.updateReadCnt", boardNum);
    }

    @Override
    public int selectBoardCnt() {
        return sqlSession.selectOne("boardMapper.selectBoardCnt");
    }


}
