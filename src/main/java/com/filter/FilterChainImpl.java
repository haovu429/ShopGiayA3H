package com.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class FilterChainImpl implements FilterChain {
    private Iterator<Filter> filters;

    public FilterChainImpl(Filter... filters) {
        this.filters = Arrays.asList(filters).iterator();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response) {
        if (filters.hasNext()) {
            Filter filter = filters.next();
            try {
                filter.doFilter(request, response, this);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
