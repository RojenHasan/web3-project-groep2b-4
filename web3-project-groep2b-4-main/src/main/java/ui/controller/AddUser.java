package ui.controller;

import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class AddUser extends Insert implements AuthenticatedUser {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        setNewUser(request);
        setPassword(newUser, request, errors);
        if(errors.size() == 0){
            try {
                service.addUser(newUser);
                if(!isLoggedIn(request)){
                    /*We give the user the possibility to make a user even if he is not logged in if he was non authenticated
                    user then the website will automatically log him in and takes him to the overview page*/
                    request.getSession().setAttribute("loggedInUser",newUser);
                }
                return "Controller?command=Overview";

            }catch (IllegalArgumentException exception){
                errors.add(exception.getMessage());
                request.setAttribute("errors", errors);
                return "addUser.jsp";
            }

        }else {
            request.setAttribute("errors", errors);
            return "addUser.jsp";


        }
    }

    private void setPassword(User user, HttpServletRequest request, ArrayList<String> errors) {
        String password = request.getParameter("password");
        try {
            user.setPassword(password);
        }catch (IllegalArgumentException exception){
            errors.add(exception.getMessage());
            request.setAttribute("passwordClass", "hasError");
        }
    }

}
