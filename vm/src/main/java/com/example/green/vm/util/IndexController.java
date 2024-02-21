package com.example.green.vm.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String main(){
        return "content/car/car_info";
    }
}
