package domain.service;

import domain.model.Project;
import domain.model.User;
import util.DbConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static ui.controller.DBConnection.getConnection;

public class ProjectServiceDBSQL implements ProjectService {

    private final Connection connection;
    private final String schema;


    public ProjectServiceDBSQL() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
        System.out.println(this.connection);
    }


    public ArrayList<Project> getAllProjects(){
        ArrayList<Project> projects = new ArrayList<>();
        String query = String.format("SELECT * from %s.project", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                projects.add(getProjectFromResult(result));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return projects;
    }

    @Override
    public User getProjectIfAuthenticated(String email, String password) {
        return null;
    }

    private Project getProjectFromResult(ResultSet result){
        try {
            int id = result.getInt("userid");
            String name = result.getString("email");
            String team = result.getString("password");
            String start = result.getString("firstname");
            String end = result.getString("lastname");
            return  new Project(id,name,team,start,end);
        }catch (SQLException exception){
            throw new DbException(exception.getMessage());
        }
    }
}
