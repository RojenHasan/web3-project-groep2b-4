package domain.service;

import domain.model.Project;
import domain.model.User;
import util.DbConnectionService;

import java.sql.*;
import java.util.ArrayList;


public class UserServiceDBSQL implements UserService{
    private final Connection connection;
    private final String schema;

    public UserServiceDBSQL() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
        System.out.println(this.connection);
    }

    public void addUser(User user) {
        if (findUserWithEmail(user.getEmail())){
            throw new IllegalArgumentException("User already exists");
        }else{
            String query = String.format
                    ("insert into %s.user(email, \"password\",firstname, lastname, \"role\", team) values(?,?,?,?,?,?)", schema);
            try {
                PreparedStatement preparedStatement = getConnection().prepareStatement(query);
                preparedStatement.setString(1, user.getEmail());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getFirstname());
                preparedStatement.setString(4, user.getLastName());
                preparedStatement.setString(5, user.getRole());
                preparedStatement.setString(6, user.getTeam());

                preparedStatement.execute();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    /**
     * Check the connection and reconnect when necessery
     * @return the connection with the db, if there is one
     */
    private Connection getConnection() {
        return this.connection;
    }


    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        String query = String.format("SELECT * from %s.user", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                users.add(getUserFromResult(result));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return users;
    }

    public User getUserIfAuthenticated(String email, String password) {
        String query = String.format("SELECT * from %s.user where \"email\" = ? and \"password\" = ?", schema);
        User user = null;
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                user = getUserFromResult(result);
            }else {
                throw new IllegalArgumentException("email or password is not correct");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

    private User getUserFromResult(ResultSet result){
        try {
            int id = result.getInt("userid");
            String emailDb = result.getString("email");
            String passwordDb = result.getString("password");
            String firstname = result.getString("firstname");
            String lastname = result.getString("lastname");
            String role = result.getString("role");
            String team = result.getString("team");
            return  new User(id,emailDb,passwordDb,firstname,lastname,role,team);
        }catch (SQLException exception){
            throw new DbException(exception.getMessage());
        }
    }

    public void delete(int id) {
        String query = String.format("delete from %s.user where userid = ?",schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1,id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void edit(User user) {
        User u = getUserFromId(user.getUserid());
        u.update(user);

        String query = String.format("update %s.user set " +
                "email = ? , firstname = ?,lastname = ?,\"role\"= ?,team = ?;", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setString(1, u.getEmail());
            statement.setString(2, u.getFirstname());
            statement.setString(3, u.getLastName());
            statement.setString(4, u.getRole());
            statement.setString(5, u.getTeam());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserFromId(int id) {
        String query = String.format("SELECT * from %s.user where \"userid\" = ?", schema);
        User user = null;
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                user = getUserFromResult(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private  boolean findUserWithEmail(String email){
        String query = String.format("SELECT * from %s.user where lower(\"email\") = ?", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setString(1, email.toLowerCase());
            ResultSet result = statement.executeQuery();
            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



}