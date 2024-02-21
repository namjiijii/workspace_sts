package com.green.shop.buy.service;

import com.green.shop.buy.vo.BuyDetailVO;
import com.green.shop.buy.vo.BuyVO;
import com.green.shop.cart.VO.CartVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("buyService")
public class BuyServiceImpl implements BuyService{
    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public int selectNextBuyCode() {
        return sqlSession.selectOne("buyMapper.selectNextBuyCode");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertBuys(BuyVO buyVO, CartVO cartVO) {
        sqlSession.insert("buyMapper.insertBuy",buyVO);
        sqlSession.insert("buyMapper.insertDetailBuy",buyVO);
        sqlSession.delete("cartMapper.deleteCarts",cartVO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertBuy(BuyVO buyVO, BuyDetailVO buyDetailVO) {
        sqlSession.insert("buyMapper.insertBuy",buyVO);
        sqlSession.insert("buyMapper.buyDetail",buyDetailVO);
    }

    @Override
    public List<BuyVO> selectBuyList(String memberId) {
        return sqlSession.selectList("buyMapper.selectBuyList",memberId);
    }


}
