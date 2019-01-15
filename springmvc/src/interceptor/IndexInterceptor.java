package interceptor;
//引用的包必须是servlet的！！！！！！！！
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.logging.Handler;

public class IndexInterceptor extends HandlerInterceptorAdapter {
    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回true
     *    执行下一个拦截器,直到所有的拦截器都执行完毕
     *    再执行被拦截的Controller
     *    然后进入拦截器链,
     *    从最后一个拦截器往回执行所有的postHandle()
     *    接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        System.out.println("preHandle(), 在访问Controller之前被调用");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response,Object handler, ModelAndView mav) {
        System.out.println("postHandle(), 在访问Controller之后，访问视图之前被调用,这里可以注入一个时间到modelAndView中，用于后续视图显示");
        mav.addObject("date","由拦截器生成的时间:" + new Date());
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,Object handler, Exception ex) {
        System.out.println("afterCompletion(), 在访问视图之后被调用");
    }

}
