package com.green.shop.admin.service;

import com.green.shop.item.vo.ImgVO;
import com.green.shop.item.vo.ItemVO;

import java.util.List;

public interface AdminService {

    //상품 등록 및 상품 이미지 등록
    void insertItem (ItemVO itemVO);



    //다음에 들어갈 item_code조회
    int selectNextItemCode();
}
