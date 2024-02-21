package com.green.shop.buy.controller;

import com.green.shop.buy.service.BuyServiceImpl;
import com.green.shop.buy.vo.BuyDetailVO;
import com.green.shop.buy.vo.BuyVO;
import com.green.shop.cart.VO.CartVO;
import com.green.shop.cart.VO.CartViewVO;
import com.green.shop.cart.service.CartServiceImpl;
import com.green.shop.item.vo.ItemVO;
import com.green.shop.member.vo.MemberVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/buy")
public class BuyController {
    @Resource(name = "cartService")
    private CartServiceImpl cartService;
    @Resource(name = "buyService")
    private BuyServiceImpl buyService;

    //선택구매
    @GetMapping("/buyCarts")
    public String buyCarts(CartVO cartVO, HttpSession session,BuyVO buyVO){
        //구매 상세 테이블에 insert할 ITEM_CODE, BUY_CNT, TOTAL_PRICE 조회
        List<CartViewVO> cartViewList = cartService.selectCartListForBuy(cartVO);

        //구매 정보 테이블에 들어갈 BUY_PRICE(구매 총 가격)계산
        int buyPrice = 0;
        for (CartViewVO e : cartViewList){
            buyPrice += e.getTotalPrice();
        }


        //구매자 ID
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        //buyVO에 memberId 데이터 넣기
        buyVO.setMemberId(loginInfo.getMemberId());
        //다음에 들어갈 BUY_CODE 결정
        int buyCode = buyService.selectNextBuyCode();
        //buyVO에 buyCode 데이터 넣기
        buyVO.setBuyCode(buyCode);


        //buyVO에 buyPrice 데이터 넣기
        buyVO.setBuyPrice(buyPrice);

        //ITEM_CODE, BUY_CNT, TOTAL_PRICE를 담을 객체 생성
        List<BuyDetailVO> buyDetailList = new ArrayList<>();

        for(CartViewVO cartView : cartViewList){
            BuyDetailVO vo = new BuyDetailVO();
            vo.setItemCode(cartView.getItemCode());
            vo.setBuyCnt(cartView.getCartCnt());
            vo.setTotalPrice(cartView.getTotalPrice());

            buyDetailList.add(vo);
        }

        buyVO.setDetailBuyList(buyDetailList);

        //insert 메소드
        buyService.insertBuys(buyVO,cartVO);


        return "redirect:/item/list";
    }

    // 바로 구매
    @PostMapping("/buys")
    public String buys(BuyDetailVO buyDetailVO
                    , BuyVO buyVO
                    , HttpSession session){
        int buyCode = buyService.selectNextBuyCode();
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");

        buyVO.setBuyCode(buyCode);

        buyVO.setMemberId(loginInfo.getMemberId());

        buyVO.setBuyPrice(buyDetailVO.getTotalPrice());

        buyDetailVO.setBuyCode(buyCode);


        buyService.insertBuy(buyVO,buyDetailVO);

        return "redirect:/";
    }

    //구매 이력 페이지
    @GetMapping("/history")
    public String history(@RequestParam(name="page") String page,
                          Model model,
                          HttpSession session){
        //로그인 정보
        MemberVO loginInfo = (MemberVO)session.getAttribute("loginInfo") ;

        model.addAttribute("page",page);
        //구매 목록 조회
        List<BuyVO> buyList = buyService.selectBuyList(loginInfo.getMemberId());
        for(BuyVO e : buyList){
            System.out.println(e);
        }
        model.addAttribute("buyList",buyList);
        return "content/buy/history";
    }

}
