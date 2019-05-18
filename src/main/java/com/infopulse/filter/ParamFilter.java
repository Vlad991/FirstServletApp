package com.infopulse.filter;

import javax.servlet.*;
import java.io.IOException;

public class ParamFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setAttribute("filter", "ok");
        chain.doFilter(request, response); //пробросили дальше запрос
    }

    @Override
    public void destroy() {

    }
}
