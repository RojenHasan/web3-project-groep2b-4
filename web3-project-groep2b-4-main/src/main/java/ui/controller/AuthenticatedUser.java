package ui.controller;


import javax.servlet.http.HttpServletRequest;

public interface AuthenticatedUser {
   default boolean isLoggedIn(HttpServletRequest request){
       return request.getSession().getAttribute("loggedInUser") != null;
   }


}
