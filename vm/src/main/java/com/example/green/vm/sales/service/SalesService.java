package com.example.green.vm.sales.service;

import com.example.green.vm.car.vo.CarVO;
import com.example.green.vm.sales.vo.SalesVO;

import java.util.List;

public interface SalesService {

    List<SalesVO> selectBuyList();

    void insertSalesInfo(SalesVO salesVO);

    List<CarVO> selectBuyInfoList();
}
