package com.green.shop.item.controller;

import com.green.shop.item.service.ItemServiceImpl;
import com.green.shop.item.vo.ItemVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//상품과 관련된 모든 페이지 이동 처리 Controller
@Controller
@RequestMapping("/item")
public class ItemController {
    @Resource(name = "itemService")
    private ItemServiceImpl itemService;

    //상품 목록 페이지
    @GetMapping("/list")
    public String list(Model model){
        //상품 목록 조회
        List<ItemVO> itemList = itemService.selectItemList();
        model.addAttribute("itemList",itemList);
        return "content/item/item_list";
    }

    @GetMapping("/itemDetail")
    public String detail(Model model, @RequestParam(name="itemCode") int itemCode){
        //상세 목록 조회
        ItemVO itemDetail = itemService.selectItemDetail(itemCode);
        model.addAttribute("detail", itemDetail);
        return "content/item/item_detail";
    }
}
