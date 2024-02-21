package com.green.shop.cart.controller;

import com.green.shop.cart.VO.CartVO;
import com.green.shop.cart.VO.CartViewVO;
import com.green.shop.cart.service.CartServiceImpl;
import com.green.shop.member.service.MemberServiceImpl;
import com.green.shop.member.vo.MemberVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Resource(name="cartService")
    private CartServiceImpl cartService;

    @PostMapping("/insertCart")
    @ResponseBody
    public void insertCart(CartVO cartVO,
                             @RequestParam(name="itemCode") int itemCode,
                             @RequestParam(name="cartCnt") int cartCnt,
                             HttpSession session){

        MemberVO member = (MemberVO) session.getAttribute("loginInfo");
        cartVO.setMemberId(member.getMemberId());
        cartService.insertCart(cartVO);
    }

    //장바구니 목록 조회
    @GetMapping("/list")
    public String list(Model model,
                       HttpSession session){
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        List<CartViewVO> cartList = cartService.selectCartList(loginInfo.getMemberId());
        model.addAttribute("cartList", cartList);

        //총 가격을 계산한 후 html 전달
        int sum = 0;
        for(CartViewVO e : cartList){
            sum = sum + e.getTotalPrice();
        }
//        model.addAttribute("finalPrice",sum);
        return "content/cart/cart_list";
    }

    //장바구니 삭제
    @GetMapping("/deleteCart")
    public String deleteCart(@RequestParam(name="cartCode") int cartCode){
        cartService.deleteCart(cartCode);
        return "redirect:/cart/list";
    }
    @ResponseBody
    @PostMapping("/updateCartCnt")
    public void updateCartCnt(CartViewVO cartViewVO,
                              HttpSession session){
        MemberVO member = (MemberVO) session.getAttribute("loginInfo");
        cartViewVO.setMemberId(member.getMemberId());
        cartService.updateCartCnt(cartViewVO);

    }



}
