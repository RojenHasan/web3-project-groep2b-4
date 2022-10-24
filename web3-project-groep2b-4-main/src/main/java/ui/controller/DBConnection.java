package ui.controller;

import domain.model.User;
import domain.service.DbException;

import java.sql.*;

import java.util.List;
import java.util.Properties;

public class  DBConnection {
    private static final String HOST = "databanken.ucll.be";
    private static final int PORT = 52223;
    private static final String DB_NAME = "2TX35";
    private static final Properties properties = new Properties();
    private static final String SELECT_USER_BY_ID = "select id, email,password,firstname,lastname,team,role from user where id=?";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("ui.controller.Secret"); // check if Secret does exist
            Secret.setPass(properties);
        } catch (ClassNotFoundException e) {
            System.out.println("Class ui.view.Secret with credentials not found");
        }

        String url = String.format("jdbc:postgresql://%s:%d/%s",HOST,PORT,DB_NAME);

        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        properties.setProperty("sslmode", "prefer");
        return DriverManager.getConnection(url, properties);
    }
    //insert user
    public void insertUser(User user) throws DbException {
        String schema = "groep2b4";
        try (Connection connection = DBConnection.getConnection()) {

            String query = String.format("insert into %s.user (userid,email,password,firstname,lastname,team,role) values (?,?,?,?,?,?,?)",
                    schema);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 6666);
            preparedStatement.setString(2, "email@gmail.com");
            preparedStatement.setString(3,"pass");
            preparedStatement.setString(4,"first");
            preparedStatement.setString(5,"last");
            preparedStatement.setString(6,"alpha");
            preparedStatement.setString(7,"employee");

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Connection no succes");
        }

    }

    //select user by id
    public User selectUser(int id){
        User user = null;
        try(Connection connection= getConnection();
                PreparedStatement preparedStatement= connection.prepareStatement(SELECT_USER_BY_ID);){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet res=  preparedStatement.executeQuery();
            while(res.next()){
                String firstname = res.getString("firstname");
                String lastname = res.getString("lastname");
                String email =res.getString("email");
                String password = res.getString("password");
                String team = res.getString("team");
                String role = res.getString("role");
                user = new User(email,password,firstname, lastname,team,role);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Connection no succes");
        }
        return user;
    }
    
}
