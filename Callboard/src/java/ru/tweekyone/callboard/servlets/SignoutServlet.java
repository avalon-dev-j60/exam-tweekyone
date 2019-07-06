package ru.tweekyone.callboard.servlets;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.tweekyone.callboard.helpers.RedirectHelper;
import ru.tweekyone.callboard.services.AuthService;

/**
 *
 * @author Пирожок
 */

@WebServlet("/sign-out")
public class SignoutServlet extends HttpServlet{
 
    @Inject AuthService authService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        authService.signOut();
        RedirectHelper.redirectBack(request, responce);
    }
    
    
    
}
