package com.how2java.mapper;
import com.how2java.pojo.OrderItem;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderItemMapper {

    @Select("select * from order_item_ where oid=#{oid}")
    @Results({
            //这种情况下面输入的是pid 所以不需要 @Result(property = "id", column="id")
//            而是自动映射进OrderItem的id属性
            @Result(property = "product", column="pid",
                    one = @One(select="com.how2java.mapper.ProductMapper.get"))
    })
    public List<OrderItem> listByOrderId(int oid);
}
