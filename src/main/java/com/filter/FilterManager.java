package com.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterManager {
    public static void process(HttpServletRequest request,
                               HttpServletResponse response) throws ServletException, IOException {
        FilterChain filterChain = new FilterChainImpl(
                new ClickjackingFilter());
        filterChain.doFilter(request, response);
    }
}
