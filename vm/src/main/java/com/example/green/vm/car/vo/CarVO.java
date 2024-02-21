package com.example.green.vm.car.vo;

import com.example.green.vm.sales.vo.SalesVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CarVO {
    private int carCode;
    private String carName;
    private int carPrice;
    private String company;
    private List<SalesVO> salesList;
}
