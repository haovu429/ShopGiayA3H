package com.controller;

import com.dao.ProductDao;
import com.entities.ProductEntity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CartController", urlPatterns = "/CartController")
public class CartController extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws SecurityException, IOException{
        //response.addHeader("X-Frame-Options", "DENY");
        //response.addHeader("Content-Security-Policy", "frame-ancestors 'none'");
        String iAction = request.getParameter("action");

        if (iAction != null && !iAction.equals("")) {
            if (iAction.equals("Add To Cart")) {
                addToCart(request);
            } else if (iAction.equals("Update")) {
                updateCart(request);
            } else if (iAction.equals("Delete")) {
                deleteCart(request);
            }
        }
        response.sendRedirect("cart.jsp");
    }
    protected void deleteCart(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String iSTT = request.getParameter("stt");
        CartBean cartBean = null;

        Object iObject = session.getAttribute("cart");
        if (iObject != null) {
            cartBean = (CartBean) iObject;
        } else {
            cartBean = new CartBean();
        }
        cartBean.deleteCart(iSTT);
    }

    protected void updateCart(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String iQuantity = request.getParameter("quantity");
        String iSTT = request.getParameter("stt");

        CartBean cartBean = null;

        Object objCartBean = session.getAttribute("cart");
        if (objCartBean != null) {
            cartBean = (CartBean) objCartBean;
        } else {
            cartBean = new CartBean();
        }
        cartBean.updateCart(iSTT, iQuantity);
    }

    protected void addToCart(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String iDescription = request.getParameter("description");
        String iPrice = request.getParameter("price");
        String iQuantity = request.getParameter("quantity");
        String productId = request.getParameter("productId");
        String image = request.getParameter("image");
        System.out.println("product id: " + productId);

        ProductDao productDao = new ProductDao();
        ProductEntity productEntity = productDao.getProductById(productId);

        CartBean cartBean = null;

        Object objCartBean = session.getAttribute("cart");

        if (objCartBean != null) {
            cartBean = (CartBean) objCartBean;
        } else {
            cartBean = new CartBean();
            session.setAttribute("cart", cartBean);
        }

        cartBean.addCart(iDescription, iPrice, iQuantity, productEntity, image);
    }
}
