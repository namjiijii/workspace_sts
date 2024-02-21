package com.green.shop.study.fetch.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fetch")
public class FetchController {

    @GetMapping("/main")
    public String main(){
        return "test/fetch/main";
    }


    // 넘어오는 데이터를 받을 때 사용하는 어노테이션에는 두 종류가 있다
    //@RequestParam : url에 데이터가 함께 넘어올 때 사용
    // ex) localhost:8081/aaa?a=b
    // form tag를 사용할 때도 포함

    //@RequestBody : url이 아닌 body 영역에 데이터가 담겨서 올 때
    //비동기 통신을 쓸 때는 @RequestBody을 쓴다
    @ResponseBody
    @PostMapping("/fetch1")
    public void fetch1(@RequestBody MemberVO memberVO){
        System.out.println("fetch1 메소드 실행");
        System.out.println(memberVO);
    }


    @ResponseBody
    @PostMapping("/fetch2")
    public void fetch2(@RequestBody HashMap<String, String> data){

        System.out.println("fetch2 메소드 실행");
        System.out.println(data);
        System.out.println(data.get("age"));
    }

    @ResponseBody
    @PostMapping("/fetch3")
    //자바스크립트에서 배열이 넘어오면 ArrayList로 받을 수 있다
    public void fetch3(@RequestBody ArrayList<MemberVO> list){

        System.out.println("fetch3 메소드 실행");
        System.out.println(list.get(0));
    }

    @ResponseBody
    @PostMapping("/fetch4")
    public void fetch4(@RequestBody HashMap<String, Object> map){

        System.out.println("fetch4 메소드 실행");
//        System.out.println(map);
        //카트코드
        int cartCode = (int) map.get("cartCode");
        //멤버아이디
        HashMap<String, String> memberInfo =(HashMap<java.lang.String, java.lang.String>) map.get("memberInfo");

        HashMap<String, Object> itemInfo = (HashMap<String, Object>)  map.get("itemInfo");

        List<Object> imgList = (List<Object>) itemInfo.get("imgList");

        Map<String,Integer> img = (Map<String, Integer>)imgList.get(1);

        System.out.println(img.get("imgCode"));

        //map 데이터를 vo객체에 매핑하기
        ObjectMapper mapper = new ObjectMapper();
        MapDataVO data = mapper.convertValue(map,MapDataVO.class);

        System.out.println(data.getItemInfo().getImgList().get(1).getImgCode());
    }
}
