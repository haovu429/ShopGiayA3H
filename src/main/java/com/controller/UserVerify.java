package com.controller;

import com.mvc.utility.SendEmail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Servlet", value = "/UserVerify")
public class UserVerify extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.addHeader("X-Frame-Options", "DENY");
        //response.addHeader("Content-Security-Policy", "frame-ancestors 'none'");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //feth form value
            String name = request.getParameter("username");
            String email = request.getParameter("useremail");
//            String email = "thaihai1004@gmail.com";
            //create instance object of the SendEmail Class
            SendEmail sm = new SendEmail();
            //get the 6-digit code
            String code = sm.getRandom();

            //craete new user using all information
            User user = new User(name,email,code);

            //call the send email method
//            boolean test = sm.sendEmail(user, email, String name, String phone, String address, String total);

            //check if the email send successfully
//            if(test){
//                HttpSession session  = request.getSession();
//                session.setAttribute("authcode", user);
//                response.sendRedirect("verify.jsp");
//            }else{
//                out.println("Failed to send verification email");
//            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
