package com.green.shop.study.fetch.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Getter
@Setter
@ToString
public class MapDataVO {
    private int cartCode;
    private MapDataMember memberInfo;
    private mapDataItem itemInfo;
}

@Getter
@Setter
@ToString
class MapDataMember{
    private String memberId;
    private String memberName;

}
@Getter
@Setter
@ToString
class mapDataItem{
    private int itemCode;
    private String itemName;
    private int itemPrice;
    private List<imgInfo> imgList;
}
@Getter
@Setter
@ToString
class imgInfo{
    private String imgName;
    private int imgCode;
}
