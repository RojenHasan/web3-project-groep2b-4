package ui.controller;

import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Edit extends RequestHandler implements AuthenticatedUser {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        if(isLoggedIn(request)){
            int id = Integer.parseInt(request.getParameter("id"));
            User user = service.getUserFromID(id);
            request.setAttribute("editedUser", user);
            return "edit.jsp";
        }
        return "index.html";

    }
}