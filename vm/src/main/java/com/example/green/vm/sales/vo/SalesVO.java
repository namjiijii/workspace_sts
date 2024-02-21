package com.example.green.vm.sales.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SalesVO {
    private int salesCode;
    private String buyerName;
    private String buyerTel;
    private String color;
    private int buyDate;
    private int carCode;
}
