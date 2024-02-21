package com.example.green.vm.sales.controller;

import com.example.green.vm.car.service.CarServiceImpl;
import com.example.green.vm.car.vo.CarVO;
import com.example.green.vm.sales.service.SalesService;
import com.example.green.vm.sales.service.SalesServiceImpl;
import com.example.green.vm.sales.vo.SalesVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sales")
public class SalesController {
    @Resource(name = "salesService")
    private SalesServiceImpl salesService;
    @Resource(name = "carService")
    private CarServiceImpl carService;

    @GetMapping("/selectBuy")
    public String selectBuy(Model model,CarVO carVO,SalesVO salesVO){
        model.addAttribute("carList", carService.selectCarList());
        model.addAttribute("salesList",salesService.selectBuyList());
        return "content/sales/car_buy";
    }

    @PostMapping("/insertSalesInfo")
    public String insertSalesInfo(SalesVO salesVO){
        salesService.insertSalesInfo(salesVO);
        return "content/sales/buy_list";
    }


    @GetMapping("/selectBuyInfoList")
    public String selectBuyInfoList(Model model){
        //System.out.println(salesService.selectBuyInfoList());
        for(CarVO e : salesService.selectBuyInfoList()){
            System.out.println(e);
            for(SalesVO e1 : e.getSalesList()){
                System.out.println(e1);
            }
        }

        model.addAttribute("buyList",salesService.selectBuyInfoList());
        return "content/sales/buy_list";
    }

}
