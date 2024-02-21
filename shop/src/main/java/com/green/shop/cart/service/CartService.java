package com.green.shop.cart.service;

import com.green.shop.buy.vo.BuyDetailVO;
import com.green.shop.buy.vo.BuyVO;
import com.green.shop.cart.VO.CartVO;
import com.green.shop.cart.VO.CartViewVO;

import java.util.List;

public interface CartService {
    //장바구니 상품 등록 및 상품 수량 변경
    void insertCart(CartVO cartVO);

    //장바구니 상품 목록 조회
    List<CartViewVO> selectCartList(String memberId);

    //장바구니 상품 하나 삭제
    void deleteCart(int cartCode);

    //장바구니 개수 변경
    void updateCartCnt(CartViewVO cartViewVO);

    //장바구니 선택 삭제
    void deleteCarts(CartVO cartVO);

    //선택 구매 insert
    List<CartViewVO> selectCartListForBuy(CartVO cartVO);




}
