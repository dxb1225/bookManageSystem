package cn.kgc.ssm.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author:邓湘标
 * @Package:cn.kgc.ssm.interceptor
 * @DESCRIPTION:
 * @DATE: 2023/2/27 22:16
 * @Version:1.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        String newURI = requestURI.substring(requestURI.lastIndexOf("/"));
        System.out.println("newURI = " + newURI);
        System.out.println("拦截到的请求是:"+requestURI);
        HttpSession session = request.getSession();

        Object user = session.getAttribute("user");
        if (user!=null){
            return true;
        }
        request.getRequestDispatcher("/").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
