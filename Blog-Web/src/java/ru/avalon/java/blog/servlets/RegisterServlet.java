/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.blog.servlets;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.avalon.java.blog.exceptions.ValidationException;
import ru.avalon.java.blog.helpers.RedirectHelper;
import ru.avalon.java.blog.services.AuthService;

/**
 *
 * @author JAVA
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
    
    private static final String JSP = "/WEB-INF/pages/auth/register.jsp";
    
    @Inject AuthService authService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        if (authService.isSignedIn()){
            RedirectHelper.redirectBack(request, response);
        } else {
        request.getRequestDispatcher(JSP).forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                            throws ServletException, IOException{
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmation = request.getParameter("confirmation");
        try {
            authService.register(email, password, confirmation);
            RedirectHelper.localRedirect(request, response, "/sign-in");
        } catch (ValidationException e){
            request.setAttribute("exception", e);
            doGet(request, response);
        }
    }
    
}
