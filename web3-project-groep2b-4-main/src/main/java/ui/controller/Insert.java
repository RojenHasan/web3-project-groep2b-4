package ui.controller;

import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public  abstract class Insert extends RequestHandler{
    protected User newUser = new User();
    protected ArrayList<String> errors = new ArrayList<>();


    protected void setNewUser(HttpServletRequest request){
        setEmail(newUser, request, errors);
        setFirstName(newUser, request, errors);
        setLastName(newUser, request, errors);
        setTeam(newUser, request, errors);
        setRole(newUser, request, errors);
    }
    private void setFirstName(User user, HttpServletRequest request, ArrayList<String> errors) {
        String firstname = request.getParameter("firstname");
        try {
            request.setAttribute("firstnamePreviousValue", firstname);
            user.setFirstname(firstname);
        }catch (IllegalArgumentException exception){
            errors.add(exception.getMessage());
            request.setAttribute("firstnameClass", "hasError");

        }

    }

    private void setLastName(User user, HttpServletRequest request, ArrayList<String> errors) {
        String lastname = request.getParameter("lastname");
        try {
            request.setAttribute("lastnamePreviousValue", lastname);
            user.setLastName(lastname);
        }catch (IllegalArgumentException exception){
            errors.add(exception.getMessage());
            request.setAttribute("lastnameClass", "hasError");
        }
    }



    private void setEmail(User user, HttpServletRequest request, ArrayList<String> errors) {
        String email = request.getParameter("email");
        try {
            request.setAttribute("emailPreviousValue", email);
            user.setEmail(email);
        }catch (IllegalArgumentException exception){
            errors.add(exception.getMessage());
            request.setAttribute("emailClass", "hasError");
        }
    }

    private void setTeam(User user, HttpServletRequest request, ArrayList<String> errors) {
        String team = request.getParameter("team");
        try {
            user.setTeam(team);
        }catch (IllegalArgumentException exception){
            errors.add(exception.getMessage());
        }
    }

    private void setRole(User user, HttpServletRequest request, ArrayList<String> errors) {

        try {
            user.setRole("employee");
        }catch (IllegalArgumentException exception){
            errors.add(exception.getMessage());
        }
    }
}
