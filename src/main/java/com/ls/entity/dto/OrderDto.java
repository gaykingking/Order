package com.ls.entity.dto;

import com.ls.entity.Order;

import java.util.Map;

public class OrderDto extends Order {
    private Map<Long,Long> productIdAndNum;

    public Map<Long, Long> getProductIdAndNum() {
        return productIdAndNum;
    }

    public void setProductIdAndNum(Map<Long, Long> productIdAndNum) {
        this.productIdAndNum = productIdAndNum;
    }
}
