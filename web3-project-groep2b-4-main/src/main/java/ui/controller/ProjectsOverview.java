package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectsOverview extends RequestHandler implements AuthenticatedUser {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        if(isLoggedIn(request)){
            request.setAttribute("allProjects", service.getAllprojects());
            return "projectOverview.jsp";
        }
        return "index.jsp";
    }
}
