package com.green.Second.newController;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.green.Second.VO.ResumeVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResumeController {
    @GetMapping ("/r1")
    public String main(){
        return "resume";
    }

    @PostMapping("/r2")
    public String resumeInfo(@RequestParam(name = "name") String name,
                             @RequestParam(name = "tel") String tel
                            ,Model model){
        System.out.println("name = " + name);
        System.out.println("tel = " + tel);

        model.addAttribute("name", name);
        model.addAttribute("tel", tel);

        return "resume_2";
    }

    @PostMapping ("/r3")
    public String third(ResumeVO resumeVO){
        System.out.println(resumeVO);
        return "resume_3";
    }


}
