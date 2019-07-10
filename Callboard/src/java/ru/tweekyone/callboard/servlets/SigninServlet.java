package ru.tweekyone.callboard.servlets;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.tweekyone.callboard.exceptions.ValidationException;
import ru.tweekyone.callboard.services.AuthService;
import ru.tweekyone.callboard.helpers.RedirectHelper;

@WebServlet ("/sign-in")
public class SigninServlet extends HttpServlet{
    
    private static final String JSP = "/WEB-INF/pages/login.jsp";
    
    @Inject AuthService authService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                    throws ServletException, IOException{
        if(authService.isSignedin()){
            RedirectHelper.redirectBack(request, response);
        } else {
            request.getRequestDispatcher(JSP).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
                                    throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        try {authService.signIn(name, password);
            RedirectHelper.localRedirect(request, response, "/");
        } catch (ValidationException e){
            request.setAttribute("exception", e);
            doGet(request, response);
        }
    }    
}
