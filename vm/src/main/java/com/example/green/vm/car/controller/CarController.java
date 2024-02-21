package com.example.green.vm.car.controller;

import com.example.green.vm.car.service.CarServiceImpl;
import com.example.green.vm.car.vo.CarVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/car")
public class CarController {
    @Resource(name = "carService")
    private CarServiceImpl carService;

    @GetMapping("/list")
    public String list(){
        return "content/car/car_info";
    }

    @PostMapping("/insertCar")
    public String insertCar(CarVO carVO){
        carService.insertCar(carVO);
        return "redirect:/car/list";
    }




    @GetMapping("/vm")
    public String vm(Model model){
        List<CarVO> carList = carService.selectCarList();
        for (CarVO e : carList){
        System.out.println(e);
        }
        model.addAttribute("carList",carList);

        return "content/car/car_insert";
    }


}
