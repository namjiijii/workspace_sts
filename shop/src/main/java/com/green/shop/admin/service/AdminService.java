package com.green.shop.admin.service;

import com.green.shop.admin.vo.SearchBuyVO;
import com.green.shop.buy.vo.BuyDetailVO;
import com.green.shop.buy.vo.BuyVO;
import com.green.shop.item.vo.ImgVO;
import com.green.shop.item.vo.ItemVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AdminService {

    //상품 등록 및 상품 이미지 등록
    void insertItem (ItemVO itemVO);



    //다음에 들어갈 item_code조회
    int selectNextItemCode();

    List<BuyVO> adminSelectBuyList(SearchBuyVO searchBuyVO);

    BuyVO adminSelectList(BuyVO buyVO);

    //상품 정보 변경 화면에서 상품 목록 조회
    List<ItemVO> selectItemList();

    //상품 상세 정보 조회
    ItemVO selectItemDetail(int itemCode);

    void updateItemDetail(ItemVO itemVO);



}
