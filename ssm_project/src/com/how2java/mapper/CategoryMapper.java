package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.Category;
//Mybatis的Mapper, 由Spring和其对应的XML文件对方法进行注解SQL配置
public interface CategoryMapper {

    public int add(Category category);

    public void delete(int id);

    public Category get(int id);

    public int update(Category category);

    public List<Category> list();

    public int count();

}