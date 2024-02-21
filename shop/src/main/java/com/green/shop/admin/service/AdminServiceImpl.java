package com.green.shop.admin.service;

import com.green.shop.admin.vo.SearchBuyVO;
import com.green.shop.buy.vo.BuyVO;
import com.green.shop.item.vo.ItemVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    @Transactional (rollbackFor = Exception.class)
    // Transactional : 어노테이션이 붙어 있는 메소드 내부의 쿼리 실행은
    // 모든 쿼리가 실행 성공 시 commit
    // 쿼리 중 하나라도 실패 시 rollback
    public void insertItem(ItemVO itemVO) {
        //상품을 등록하는 메소드
        sqlSession.insert("adminMapper.insertItem",itemVO);
        //이미지를 등록하는 메소드
        sqlSession.insert("adminMapper.insertImgs",itemVO);
    }

    @Override
    public int selectNextItemCode() {
        return sqlSession.selectOne("adminMapper.selectNextItemCode");
    }

    @Override
    public List<BuyVO> adminSelectBuyList(SearchBuyVO searchBuyVO) {
        return sqlSession.selectList("adminMapper.adminSelectBuyList", searchBuyVO);
    }

    @Override
    public BuyVO adminSelectList(BuyVO buyVO) {
        return sqlSession.selectOne("adminMapper.adminSelectList",buyVO);
    }

    @Override
    public List<ItemVO> selectItemList() {
        return sqlSession.selectList("adminMapper.selectItemList");
    }

    @Override
    public ItemVO selectItemDetail(int itemCode) {
        return sqlSession.selectOne("adminMapper.selectItemDetail", itemCode);
    }

    @Override
    public void updateItemDetail(ItemVO itemVO) {
        sqlSession.update("adminMapper.updateItemDetail",itemVO);
    }


}
