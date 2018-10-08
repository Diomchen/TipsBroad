package com.TipsBorad.filter;

import com.TipsBorad.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "UserFilter")
public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        User user = (User)((HttpServletRequest)request).getSession().getAttribute("user");
        request.setAttribute("user",user);
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
