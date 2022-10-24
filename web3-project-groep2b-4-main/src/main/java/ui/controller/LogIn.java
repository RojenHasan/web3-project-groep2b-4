package ui.controller;

import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class LogIn extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        ArrayList<String> errors = new ArrayList<>();
       try {
           User user = service.getUserIfAuthenticated(email,password);
           HttpSession session = request.getSession();
           session.setAttribute("loggedInUser", user);
           //System.out.println(request.getSession().getAttribute("loggedInUser"));
           return "index.jsp";

       }catch (IllegalArgumentException exception){
           errors.add(exception.getMessage());
           request.setAttribute("emailPreviousValue",email);
           request.setAttribute("emailClass", "hasError");
           request.setAttribute("errors",errors);
           return "index.jsp";
       }
    }
}
