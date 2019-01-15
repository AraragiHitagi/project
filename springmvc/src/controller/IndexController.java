package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//之前把 IndexController implements Controller 了，
// 导致错误的Controller类被注解，导致出现重定向页面不跳转的问题
@Controller
public class IndexController {
    @RequestMapping("/index")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        跳转到web目录下的 index.jsp
//        ModelAndView mav = new ModelAndView("index.jsp");

//        视图定位——》跳转到 /WEB-INF/page/index.jsp
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Hello Spring MVC (视图)");
        return mav;
    }

    @RequestMapping("/jump")
    public ModelAndView jump(){
        //        实现客户端跳转 由 /jump 转到 /index 对应的方法里
        ModelAndView mav = new ModelAndView("redirect:/index");
        return mav;
    }

    @RequestMapping("/check")
    public ModelAndView check(HttpSession session){
        Integer i = (Integer) session.getAttribute("count");
        if (i==null)
            i=0;
        i++;
        session.setAttribute("count",i);
        ModelAndView mav = new ModelAndView("check");
        return mav;
    }

    @RequestMapping("/clear")
    public ModelAndView clear(HttpSession session){
        session.setAttribute("count",0);
        ModelAndView mav = new ModelAndView("redirect:/check");
        return mav;
    }



}