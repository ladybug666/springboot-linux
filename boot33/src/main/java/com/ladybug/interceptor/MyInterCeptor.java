package com.ladybug.interceptor;

import com.ladybug.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterCeptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        if(user==null){
            request.setAttribute("msg","请登录");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        return true;
    }
}
