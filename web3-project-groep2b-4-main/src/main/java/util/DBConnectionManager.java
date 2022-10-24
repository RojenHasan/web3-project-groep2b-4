package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


//create and returns specific connection
public class DBConnectionManager {
    private static DBConnectionManager dbConnectionManagerInstance ;
    private static Connection connection;
    private static Properties properties;
    private static String url;

    private DBConnectionManager(String dbURL){
        Properties dbProperties = new Properties();
        try{
            Class.forName("util.Secret");
            Secret.setPass(dbProperties);
        } catch (ClassNotFoundException e) {
            System.out.println("Class Secret with credentials not found!");
            throw new ConnectionException(e);
        }

        dbProperties.setProperty("ssl", "true");
        dbProperties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        dbProperties.setProperty("sslmode", "prefer");

        properties = dbProperties;
        url = dbURL;
        setConnection();
    }

    private static void setConnection(){
        try {
            System.out.print("connecting to database ...");
            Class.forName("org.postgresql.Driver");
            System.out.println("url: "+ url);
            connection = DriverManager.getConnection(url, properties);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.print("connection troubles: \n"+e.getMessage()+"\n");
            System.out.println(e.getMessage());
            throw new ConnectionException(e);
        }
    }


    public Connection getConnection() {
        try {
            if(connection == null || connection.isClosed()){
                setConnection();
            }
        } catch (SQLException e) {
            throw new ConnectionException(e);
        }

        return connection;

    }

    public static DBConnectionManager getInstance(String dbURL){
        if(dbConnectionManagerInstance == null){
            dbConnectionManagerInstance = new DBConnectionManager(dbURL);
        }
        return dbConnectionManagerInstance;
    }
}
