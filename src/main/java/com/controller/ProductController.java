package com.controller;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.entities.CategoryEntity;
import com.entities.ProductEntity;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", urlPatterns = {"/Product", "/product"})
public class ProductController extends HttpServlet {
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
        //((HttpServletResponse) response).setHeader("x-frame-options", "ALLOW");
        //chain.doFilter(request, response);
        //response.addHeader("Content-Security-Policy", "frame-ancestors 'none'");
        //response.addHeader("X-Frame-Options", "DENY");
        //response.addHeader("Content-Security-Policy", "frame-ancestors 'none'");


        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url;
        url = "/product.jsp";
        ProductDao productDao = new ProductDao();
        List<ProductEntity> product = productDao.getListProduct();
        CategoryDao categoryDao = new CategoryDao();
        List<CategoryEntity> category = categoryDao.getListCategory();
        request.setAttribute("product", product);
        request.setAttribute("category", category);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
