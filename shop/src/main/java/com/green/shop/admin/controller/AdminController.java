package com.green.shop.admin.controller;

import com.green.shop.admin.service.AdminServiceImpl;
import com.green.shop.admin.vo.SearchBuyVO;
import com.green.shop.buy.service.BuyServiceImpl;
import com.green.shop.buy.vo.BuyVO;
import com.green.shop.item.service.ItemServiceImpl;
import com.green.shop.item.vo.CategoryVO;
import com.green.shop.item.vo.ImgVO;
import com.green.shop.item.vo.ItemVO;
import com.green.shop.member.vo.MemberVO;
import com.green.shop.util.ConstantVariable;
import com.green.shop.util.UploadUtil;
import jakarta.annotation.Priority;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource(name = "itemService")
    private ItemServiceImpl itemService;
    @Resource(name = "adminService")
    private AdminServiceImpl adminService;


    //상품 등록 페이지
    @GetMapping("/regItemForm")
    public String regItemForm(Model model) {
        //카테고리 목록 조회
        List<CategoryVO> categoryList = itemService.selectCategoryList();
        model.addAttribute("categoryList", categoryList);

        model.addAttribute("page",2);
        return "content/admin/reg_item_form";
    }

    //상품 등록
    @PostMapping("/regItem")
    public String regItem(ItemVO itemVO,
                          @RequestParam(name = "mainImg") MultipartFile mainImg,
                          @RequestParam(name = "subImgs") MultipartFile[] subImgs){
        //단일 파일 첨부 기능
        ImgVO mainImgVO = UploadUtil.uploadFile(mainImg);

        //다중 파일 첨부 기능
        List<ImgVO> imgList = UploadUtil.multiUploadFile(subImgs);

        //다음에 들어갈 ITEM_CODE 조회
        int itemCode = adminService.selectNextItemCode();

        //상품 등록 쿼리
        itemVO.setItemCode(itemCode); // itemCode의 빈값을 채워 줄 메소드
//        adminService.insertItem(itemVO);

        //상품 이미지 정보 등록 쿼리

        //현재 itemVO에는 상품명, 가격, 상품소개, cateCode
        //이미지 등록 시 채워줘야하는 모든 데이터를 갖는 리스트 생성
        mainImgVO.setItemCode(itemCode); // 하나의 이미지 데이터 ITEM_CODE
        for (ImgVO img : imgList){
            img.setItemCode(itemCode);
        }
        imgList.add(mainImgVO);
        itemVO.setImgList(imgList);

        System.out.println(itemVO);
        adminService.insertItem(itemVO);
        return "redirect:/admin/regItemForm";
    }

    //구매 이력 조회 페이지
    @RequestMapping("/adminHistory")
    public String adminHistory(Model model, SearchBuyVO searchBuyVO){
        List<BuyVO> voList = adminService.adminSelectBuyList(searchBuyVO);
        model.addAttribute("voList",voList);
        System.out.println(searchBuyVO);
        model.addAttribute("page",1);
        return "content/admin/admin_history";
    }


    //상세구매 내역 조회
    @ResponseBody
    @PostMapping("/adminDetailSelect")
    public BuyVO adminDetailSelect(BuyVO buyVO
                                  ){

        BuyVO buy = adminService.adminSelectList(buyVO);

        return buy;
    }
    //상품 정보 변경
    @GetMapping("/updateItem")
    public String updateItem(Model model,
                             @RequestParam(name = "itemCode", required = false, defaultValue = "0") int itemCode){


        model.addAttribute("itemList",adminService.selectItemList());
        model.addAttribute("page",4);
        model.addAttribute("updateItemCode", itemCode);
        return "content/admin/update_item";
    }

    //상품 정보 변경 화면의 상품 목록 테이블의 행 클릭시
    // 상품의 상세 정보를 조회하는 비동기
    @ResponseBody
    @PostMapping("/selectItemDetail")
    public Map<String,Object> selectItemDetail(@RequestParam(name = "itemCode") int itemCode){

        ItemVO itemDetail = adminService.selectItemDetail(itemCode);

        List<CategoryVO> cateList = itemService.selectCategoryList();

        //위 두 데이터를 담을 수 있는 map 객체 생성
        Map<String,Object> map = new HashMap<>();
        map.put("itemDetail", itemDetail);
        map.put("cateList", cateList);

        return map;
    }
    //상품 정보 변경
    @PostMapping("/updateItemDetail")
    public String updateItemDetail(ItemVO itemVO){
        adminService.updateItemDetail(itemVO);
        return "redirect:/admin/updateItem?itemCode=" + itemVO.getItemCode();
    }
}