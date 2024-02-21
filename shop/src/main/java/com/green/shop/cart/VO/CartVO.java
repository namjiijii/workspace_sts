package com.green.shop.cart.VO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.swing.*;
import java.util.List;

@Getter
@Setter
@ToString
public class CartVO {
    private int cartCode;
    private int itemCode;
    private String memberId;
    private int cartCnt;
    private String cartDate;
    private List<Integer> cartCodeList;
}
