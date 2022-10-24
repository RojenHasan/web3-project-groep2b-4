package domain.service;

import domain.model.Project;
import domain.model.User;

import java.util.ArrayList;

public interface UserService {
    void addUser(User user);
    ArrayList<User>getAll();

    void delete(int id);
    void edit (User user);
    User getUserIfAuthenticated(String email, String password);
    User getUserFromId(int id);
}
