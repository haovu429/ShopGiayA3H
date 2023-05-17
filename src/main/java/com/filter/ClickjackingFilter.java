package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ClickjackingFilter implements Filter {
    @Override
    public void doFilter (
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        HttpSession session = httpServletRequest.getSession(false);
        /*if (session == null || session.getAttribute("username") == null) {
            FrontCommand command = new LoginCommand();
            command.init(httpServletRequest, httpServletResponse);
            command.process();
        } else {
            chain.doFilter(request, response);
        }*/
    }


}
