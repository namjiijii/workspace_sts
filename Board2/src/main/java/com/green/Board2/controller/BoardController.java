package com.green.Board2.controller;

import com.green.Board2.service.BoardService;
import com.green.Board2.service.BoardServiceImpl;
import com.green.Board2.service.ReplyServiceImpl;
import com.green.Board2.vo.BoardVO;
import com.green.Board2.vo.MemberVO;
import com.green.Board2.vo.ReplyVO;
import com.green.Board2.vo.SearchVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Resource(name = "boardService")
    private BoardServiceImpl boardService;

    @Resource(name = "replyService")
    private ReplyServiceImpl replyService;
    //목록조회, 글쓰기, 상세조회, 수정, 삭제



    //게시글 목록 페이지
    @RequestMapping("/list") //커맨드 객체 : 자동으로 데이터를 html로 넘겨주는 객체
    public String boardList(SearchVO searchVO, Model model){
        //전체 데이터 수
        int totalDataCnt = boardService.selectBoardCnt();
        searchVO.setTotalDataCnt(totalDataCnt);


        //페이지 정보 세팅
        searchVO.setPageInfo();
//        List<BoardVO> boardList = boardService.selectBoardList();  둘 다 사용 가능
        model.addAttribute("boardList", boardService.selectBoardList(searchVO));
        return "list";
    }

    //글쓰기
    @GetMapping("/insertBoard")
    public String insertBoard(){
        return "board_write_form";
    }
    //데이터 저장 메소드
    @PostMapping ("/insertBoard")
    public String insert(BoardVO boardVO){
        boardService.insertBoard(boardVO);
        return "redirect:/board/list";
    }

    //게시물 상세 정보 + html 전달
    @GetMapping("/boardDetail")
    public String boardDetail(@RequestParam(name = "boardNum") int boardNum, Model model){
        //조회수 증가
        boardService.updateReadCnt(boardNum);

        BoardVO board = boardService.selectBoardOne(boardNum);
        model.addAttribute("board", board);
        List<ReplyVO> replyList = replyService.selectReplyList(boardNum);
        model.addAttribute("replyList", replyList);
        return "board_detail";
    }

    //수정
    @GetMapping("/boardUpdate")
    public String boardUpdate(BoardVO boardVO, Model model){
        BoardVO board = boardService.selectBoardOne(boardVO.getBoardNum());
        model.addAttribute("board", board);

        return "board_update";
    }

    //수정및 화면
    @PostMapping("/boardUpdateForm")
    public String boardUpdateForm(BoardVO boardVO){
        boardService.updateBoard(boardVO);
        return "redirect:/board/boardDetail?boardNum="+ boardVO.getBoardNum();
    }

    //삭제
    @GetMapping("/boardDelete")
    public String boardDelete(@RequestParam(name="boardNum") int boardNum){
        boardService.deleteBoard(boardNum);
        return "redirect:/board/list";
    }

    @GetMapping("/writeForm")
    public String write(){
        return "write_form";
    }

    @PostMapping("/write")
    public String writeForm(BoardVO boardVO, HttpSession session){
        //세션에 저장된 로그인한 유저의 아이디 조회
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");

        //boardVO에 작성자 데이터 저장
        boardVO.setWriter(loginInfo.getMemberId());
        boardService.insertBoard(boardVO);
        return "redirect:/board/list";
    }



}
