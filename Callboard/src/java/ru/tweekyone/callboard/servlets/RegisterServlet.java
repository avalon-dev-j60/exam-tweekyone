package ru.tweekyone.callboard.servlets;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.tweekyone.callboard.exceptions.ValidationException;
import ru.tweekyone.callboard.helpers.RedirectHelper;
import ru.tweekyone.callboard.services.AuthService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
    
    private static final String JSP = "/WEB-INF/pages/register.jsp";
    
    @Inject AuthService authService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        if (authService.isSignedin()){
            RedirectHelper.redirectBack(request, responce);
        } else {
            request.getRequestDispatcher(JSP).forward(request, responce);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        String name = request.getParameter("name");
        String passwors = request.getParameter("password");
        String confirmation = request.getParameter("confirmation");
        try {authService.register(name, passwors, confirmation);
            RedirectHelper.localRedirect(request, responce, "/sign-in");
        } catch (ValidationException e) {
            request.setAttribute("exception", e);
            doGet(request, responce);
        }
    }
}
