package com.green.Board2.service;

import com.green.Board2.vo.ReplyVO;

import java.util.List;

public interface ReplyService {

    List<ReplyVO> selectReplyList(int boardNum);

    void insertReply(ReplyVO replyVO);

    ReplyVO selectTitle(String title);

    void deleteReply(ReplyVO replyVO);

}
