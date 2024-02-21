package com.example.green.vm.sales.service;

import com.example.green.vm.car.vo.CarVO;
import com.example.green.vm.sales.vo.SalesVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("salesService")
public class SalesServiceImpl implements SalesService{
    @Autowired
    private SqlSessionTemplate sqlSession;




    @Override
    public List<SalesVO> selectBuyList() {
        return sqlSession.selectList("salesMapper.selectBuyList");
    }

    @Override
    public void insertSalesInfo(SalesVO salesVO) {
        sqlSession.insert("salesMapper.insertSalesInfo", salesVO);
    }

    @Override
    public List<CarVO> selectBuyInfoList() {
        return sqlSession.selectList("salesMapper.selectBuyInfoList");
    }
}
