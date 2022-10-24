package domain.service;

import domain.model.Project;
import domain.model.User;

import java.util.ArrayList;


public class AppService {
    private UserService users = new UserServiceDBSQL();
    private ProjectService projects = new ProjectServiceDBSQL();

    public void addUser(User user){
        users.addUser(user);
    }

    public ArrayList<User> getAll(){
        return users.getAll();
    }
    public ArrayList<Project> getAllprojects(){
        return projects.getAllProjects();
    }

    public void edit(User newUser) {
        users.edit(newUser);
    }

    public User getUserFromID(int id) {
        return users.getUserFromId(id);
    }

    public User getUserIfAuthenticated(String email, String password) {
        return users.getUserIfAuthenticated(email, password);
    }

    public void delete(int id) {
        users.delete(id);
    }
}
