package com.how2java.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.pojo.Category;
import com.how2java.pojo.Page;
import com.how2java.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//Spring + SpringMVC + Mybatis
//控制类Controller 用于对指定网页路径接收参数处理并跳转到指定视图
@Controller
@RequestMapping("") //若里面是abc，则访问方法的路径是 /abc/listCategory
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("listCategory")
    public ModelAndView listCategory(Page page){
        ModelAndView mav = new ModelAndView();
        //        PageHelper方式分页
        PageHelper.offsetPage(page.getStart(),5);

//      这里也用到了Spring的注入
//      控制为了方便以后 autowired是自动找实现类的
//      所以你直接调接口他就自动找这个impl了
//      以后如果要修改CategoryService的内容，就不用改这里了！
        List<Category> cs = categoryService.list();
        int total = (int) new PageInfo<>(cs).getTotal();
        page.calculateLast(total);

        mav.addObject("cs",cs);
        //指定跳转视图的名称 (视图定位的 jsp路径)
        mav.setViewName("listCategory");
        return mav;
    }

//    JSON报错？？？？ AJAX+JSON+SSM -> bean 与 json 的转换
    /*@ResponseBody
    @RequestMapping("/submitCategory")
    public String submitCategory(@RequestBody Category category) {
        System.out.println("SSM接受到浏览器提交的json，并转换为Category对象:"+category);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/getOneCategory")
    public String getOneCategory() {
        Category c = new Category();
        c.setId(100);
        c.setName("第100个分类");
        JSONObject json= new JSONObject();
        json.put("category", JSONObject.toJSON(c));
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/getManyCategory")
    public String getManyCategory() {
        List<Category> cs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category c = new Category();
            c.setId(i);
            c.setName("分类名称:"+i);
            cs.add(c);
        }
        return JSONObject.toJSON(cs).toString();
    }
*/
}
