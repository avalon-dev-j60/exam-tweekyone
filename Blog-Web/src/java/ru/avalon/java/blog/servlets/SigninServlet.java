package ru.avalon.java.blog.servlets;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.avalon.java.blog.helpers.RedirectHelper;
import ru.avalon.java.blog.services.AuthService;
import ru.avalon.java.blog.exceptions.ValidationException;

@WebServlet("/sign-in")
public class SigninServlet extends HttpServlet{
    
    private static final String JSP = "/WEB-INF/pages/auth/login.jsp";

    @Inject AuthService authSertvice;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                                        throws ServletException, IOException{
        if (authSertvice.isSignedIn()){
            RedirectHelper.redirectBack(request, response);
        } else {
            request.getRequestDispatcher(JSP)
                    .forward(request, response);
        }
    }
    
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                        throws ServletException, IOException{
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {authSertvice.signIn(email, password);
                RedirectHelper.localRedirect(request, response, "/");
        } catch (ValidationException e){
                request.setAttribute("exception", e);
                doGet(request, response);
        }
    }
}
