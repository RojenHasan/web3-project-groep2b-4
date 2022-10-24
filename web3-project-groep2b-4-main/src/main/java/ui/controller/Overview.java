package ui.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Overview extends RequestHandler implements AuthenticatedUser {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        if(isLoggedIn(request)){
            request.setAttribute("allUsers", service.getAll());
            return "overview.jsp";
        }
        return "index.jsp";
    }
}