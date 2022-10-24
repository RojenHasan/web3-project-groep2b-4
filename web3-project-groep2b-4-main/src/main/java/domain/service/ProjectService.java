package domain.service;

import domain.model.Project;
import domain.model.User;

import java.util.ArrayList;

public interface ProjectService {
    ArrayList<Project> getAllProjects();
    User getProjectIfAuthenticated(String email, String password);
}
