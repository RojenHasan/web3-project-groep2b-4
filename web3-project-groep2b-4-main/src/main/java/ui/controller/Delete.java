package ui.controller;

import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends RequestHandler  implements AuthenticatedUser {


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        if(isLoggedIn(request)){
            int id = Integer.parseInt(request.getParameter("id"));
            User user = service.getUserFromID(id);
            request.setAttribute("UserToDelete", user);
            return "deleteConfirmation.jsp";
        }

        return "index.jsp";

    }


}