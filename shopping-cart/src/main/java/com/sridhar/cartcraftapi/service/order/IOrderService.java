package com.sridhar.cartcraftapi.service.order;

import com.sridhar.cartcraftapi.dto.OrderDto;
import com.sridhar.cartcraftapi.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);

    OrderDto getOrder(Long orderId);

    List<OrderDto> getUserOrders(Long userId);
}
