package com.green.Board2.service;

import com.green.Board2.vo.ReplyVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("replyService")
public class ReplyServiceImpl implements ReplyService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<ReplyVO> selectReplyList(int boardNum) {
        return sqlSession.selectList("replyMapper.selectReplyList", boardNum);
    }

    @Override
    public void insertReply(ReplyVO replyVO) {
        sqlSession.insert("replyMapper.insertReply", replyVO);
    }

    @Override
    public ReplyVO selectTitle(String title) {
        return sqlSession.selectOne("selectTitle", title);
    }

    @Override
    public void deleteReply(ReplyVO replyVO) {
        sqlSession.delete("deleteReply",replyVO);
    }


}
