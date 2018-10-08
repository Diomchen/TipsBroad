package com.TipsBorad.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "CharSetFilter")
public class CharSetFilter implements Filter {
    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        this.encoding = config.getInitParameter("encode");
    }

    public void doFilter(ServletRequest request, ServletResponse respponse, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, respponse);
    }

    public void destroy() {

    }

}
