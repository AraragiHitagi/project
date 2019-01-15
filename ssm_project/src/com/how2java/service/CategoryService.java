package com.how2java.service;

import java.util.List;
import com.how2java.pojo.Category;
//SpringMVC 核心业务类
public interface CategoryService {

    List<Category> list();
    void deleteAll();
    void addTwo();

}
