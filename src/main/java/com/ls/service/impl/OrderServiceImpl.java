package com.ls.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ls.entity.Inventory;
import com.ls.entity.Order;
import com.ls.entity.dto.OrderDto;
import com.ls.exception.BusinessException;
import com.ls.exception.ErrorEnum;
import com.ls.mapper.OrderMapper;
import com.ls.service.IInventoryService;
import com.ls.service.IOrderService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lingsheng
 * @since 2022-10-16
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @DubboReference
    private IInventoryService inventoryService;
    @Override
    public Boolean saveOrder(OrderDto order) {
        Map<Long, Long> productIdAndNum = order.getProductIdAndNum();
        inventoryService.subInventoryNumByProductId(productIdAndNum);
        boolean save;
        try{
            Order order1 = new Order();
            order1.setOrderNo(order.getOrderNo());
            order1.setAddress(order.getAddress());
            order1.setCusId(order.getCusId());
            order1.setTelephone(order.getTelephone());
            order1.setTotalAmount(order.getTotalAmount());
            save = save(order1);
        }catch (Exception e){
            throw new BusinessException(ErrorEnum.E_20011);
        }
        return save;
    }
}
