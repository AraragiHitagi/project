package com.how2java.mapper;

import com.how2java.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper {
    @Select("select * from order_")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "orderItems", javaType = List.class, column = "id",
                    many=@Many(select = "com.how2java.mapper.OrderItemMapper.listByOrderId"))
    })
    public List<Order> list();
}
