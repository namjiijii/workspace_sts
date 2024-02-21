package com.example.FetchStudent.controller;

import com.example.FetchStudent.vo.ScoreVO;
import com.example.FetchStudent.vo.StuVO;
import org.codehaus.groovy.transform.sc.transformers.CompareIdentityExpression;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// 비동기 통신 학습용 컨트롤러
// javascript -> fetch
// jquery -> ajax
// react ->axios
@Controller
@RequestMapping("/study")
public class FetchController {


    @GetMapping("/t1")
    public String t1(){
        return "fetch_test";
    }

    // @ResponseBody : 해당 메소드는 비동기 통신을 사용학 때문에
    // 메소드의 마지막 return으로 페이지 전환 하지 않겠다를
    // spring에게 알려주는 코드.
    @ResponseBody
    @PostMapping("/t2")
    public int t2(@RequestParam(name = "name") String name
                , @RequestParam(name = "age") int age){
        System.out.println("t1 메소드 실행");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return 100;
    }


    @ResponseBody
    @PostMapping("/t3")
    public StuVO t3(StuVO VO){
        System.out.println(VO);
        System.out.println("t3 메소드 실행");

        StuVO stuVO = new StuVO();
        stuVO.setStuNum(1);
        stuVO.setStuName("김자바");
        stuVO.setClassCode(1);
        stuVO.setClassName("자바반");



        return stuVO;
    }

    @ResponseBody
    @PostMapping("/t4")
    public List<StuVO> t4(){
        System.out.println("t4 메소드 실행");

        List<StuVO> list = new ArrayList<>();

        for (int i = 1; i < 6; i++){
            StuVO stuVO = new StuVO();
            stuVO.setStuNum(i);
            stuVO.setStuName("자바_" + i);
            stuVO.setClassCode(1);
            stuVO.setClassName("자바반" + i);

            list.add(stuVO);
        }
        return list;

    }

}
