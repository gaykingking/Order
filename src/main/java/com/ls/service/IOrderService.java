package com.ls.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ls.entity.Order;
import com.ls.entity.dto.OrderDto;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lingsheng
 * @since 2022-10-16
 */
public interface IOrderService extends IService<Order> {

    Boolean saveOrder(OrderDto order);
}
