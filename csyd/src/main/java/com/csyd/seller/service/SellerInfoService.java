package com.csyd.seller.service;

import com.csyd.pojo.Seller;
import com.csyd.seller.dao.SellerInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("sellerInfoService")
@Transactional(readOnly = true,propagation = Propagation.NOT_SUPPORTED)
public class SellerInfoService {
    @Resource(name = "sellerInfoMapper")
    private SellerInfoMapper sellerInfoMapper;

    public Seller findById(Integer userId){
        return sellerInfoMapper.findById(userId);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int modify(Seller seller){
        return sellerInfoMapper.mofidy(seller);
    }
}
