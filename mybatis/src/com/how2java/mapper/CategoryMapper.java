package com.how2java.mapper;

import com.how2java.CategoryDynaSqlProvider;
import com.how2java.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

//mapper 是抽象类 interface
//对mybatis的注解方式
public interface CategoryMapper {
//    动态注解
/*
    @InsertProvider(type=CategoryDynaSqlProvider.class,method="add")
    public int add(Category category);

    @DeleteProvider(type=CategoryDynaSqlProvider.class,method="delete")
    public void delete(int id);

    @SelectProvider(type=CategoryDynaSqlProvider.class,method="get")
    public Category get(int id);

    @UpdateProvider(type=CategoryDynaSqlProvider.class,method="update")
    public int update(Category category);

    @SelectProvider(type=CategoryDynaSqlProvider.class,method="list")
    public List<Category> list();
*/


//    静态注解
    @Insert(" insert into category_ ( name ) values (#{name}) ")
    public int add(Category category);

    @Delete(" delete from category_ where id= #{id} ")
    public void delete(int id);

    @Select("select * from category_ where id= #{id} ")
    public Category get(int id);

    @Update("update category_ set name=#{name} where id=#{id} ")
    public int update(Category category);

    @Select(" select * from category_ ")
//    property是属性column是返回表的列的值
    @Results({
//            这个语句已经通过listByCategory方法把 category表的id字段映射到了products属性，
//            就不会再自动映射到自身的id属性了，所以查询出来自身的id为0；所以必须提前将id存储
//            OrderItemMapper里的情况就不用加
            @Result(property = "id", column = "id"),
//            column的值传入Many中的函数中作为形参，前两个是要赋值的名和类型
            @Result(property = "products", javaType = List.class, column = "id", many =
            @Many(select = "com.how2java.mapper.ProductMapper.listByCategory"))
    })
    public List<Category> list();

    @Select("select * from category_ limit #{start},#{count}")
//    设置形参并赋予注解别名
    public List<Category> listByPage(@Param("start")int start, @Param("count")int count);
}
