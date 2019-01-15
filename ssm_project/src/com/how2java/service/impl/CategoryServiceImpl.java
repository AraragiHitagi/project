package com.how2java.service.impl;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//Spring CategoryService的业务实现类
@Service
public class CategoryServiceImpl implements CategoryService{
        //Spring Bean的注入
        @Autowired
        CategoryMapper categoryMapper;

        public List<Category> list(){
            return categoryMapper.list();
        }

        @Override
        public void deleteAll() {
                List<Category> cs = categoryMapper.list();
                for (Category c : cs){
                        categoryMapper.delete(c.getId());
                }
        }

        @Override
        public void addTwo() {
                Category c1 = new Category();
                c1.setName("可以添加");
                Category c2 = new Category();
                c2.setName("名字太长不能添加，名字太长不能添加，名字太长不能添加，名字太长不能添加，" +
                        "名字太长不能添加，名字太长不能添加，名字太长不能添加，名字太长不能添加，" +
                        "名字太长不能添加，名字太长不能添加，名字太长不能添加，名字太长不能添加，" +
                        "名字太长不能添加，名字太长不能添加，名字太长不能添加，名字太长不能添加，");
                categoryMapper.add(c1);
                categoryMapper.add(c2);
        }

}
