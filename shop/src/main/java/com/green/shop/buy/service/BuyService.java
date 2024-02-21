package com.green.shop.buy.service;

import com.green.shop.buy.vo.BuyDetailVO;
import com.green.shop.buy.vo.BuyVO;
import com.green.shop.cart.VO.CartVO;

import java.util.List;

public interface BuyService {

    //다음에 들어갈 buy_code 조회
    int selectNextBuyCode();

    void insertBuys (BuyVO buyVO, CartVO cartVO);

    void insertBuy(BuyVO buyVO, BuyDetailVO buyDetailVO);

    List<BuyVO> selectBuyList(String memberId);


}
