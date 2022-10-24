package ui.controller;

import domain.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditConfirmation extends Insert {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        User oldUser = service.getUserFromID(Integer.parseInt(request.getParameter("editedUserId")));
        setNewUser(request);

        if(errors.size() == 0){
            try {
                newUser.setUserid(oldUser.getUserid());
                service.edit(newUser);

                return "Controller?command=Overview";

            }catch (Exception exception){
                errors.add(exception.getMessage());
                request.setAttribute("errors", errors);
                request.setAttribute("editedUser", oldUser);
                return "edit.jsp";
            }

        }else {
            request.setAttribute("errors", errors);
            request.setAttribute("editedUser", oldUser);
            return "edit.jsp";
        }

    }

}