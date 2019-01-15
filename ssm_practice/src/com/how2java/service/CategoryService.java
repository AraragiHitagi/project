package com.how2java.service;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    List<Category> list();

}
