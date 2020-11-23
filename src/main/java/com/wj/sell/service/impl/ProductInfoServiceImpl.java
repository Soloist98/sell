package com.wj.sell.service.impl;

import com.wj.sell.dataobject.ProductInfo;
import com.wj.sell.dto.CartDTO;
import com.wj.sell.enums.ProductStatusEnum;
import com.wj.sell.enums.ResultEnum;
import com.wj.sell.exception.SellException;
import com.wj.sell.repository.ProductInfoRepository;
import com.wj.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).orElse(null);
            if(productInfo == null)
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).orElse(null);
            if(productInfo == null)
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = repository.findById(productId).orElse(null);
        if(productInfo == null)
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        if (productInfo.getProductStatus() == ProductStatusEnum.UP.getCode())
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        //修改状态
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        ProductInfo result = repository.save(productInfo);
        return result;
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = repository.findById(productId).orElse(null);
        if(productInfo == null)
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        if (productInfo.getProductStatus() == ProductStatusEnum.DOWN.getCode())
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        //修改状态
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        ProductInfo result = repository.save(productInfo);
        return result;
    }
}
