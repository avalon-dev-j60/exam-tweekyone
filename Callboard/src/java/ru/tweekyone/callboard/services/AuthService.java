
package ru.tweekyone.callboard.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import ru.tweekyone.callboard.entities.User;
import ru.tweekyone.callboard.exceptions.ValidationException;
import static ru.tweekyone.callboard.helpers.Validation.*;

@Stateless
public class AuthService {
    
    @EJB UserService userService;
    @Inject HttpSession session;
    
    public void signIn(String name, String password) throws ValidationException{
        require(name, "Name is required!");
        require(password, "Password is required!");
        User user = userService.findByName(name);
        requireNonNull(user, "User does not exist!");
        requireEquals(user.getPassword(), password, "Invalid password!");
        session.setAttribute("user", name);
    }
    
    public void signOut(){
        session.invalidate();
    }
    
    public boolean isSignedin(){
        return session.getAttribute("user") != null;
    }
    
    public void register(String name, String password, String passwordConfirmation) 
            throws ValidationException{
        require(name, "Name is required!");
        require(password, "Password is required!");
        require(passwordConfirmation, "Password confirmation is required!");
        requireEquals(password, passwordConfirmation, "Password does not match confirmation!");
        User user = userService.findByName(name);
        requireNull(user, "User with same name already exists!");
    }
}
