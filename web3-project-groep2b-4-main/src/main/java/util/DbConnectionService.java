package util;
import java.sql.Connection;
import java.sql.SQLException;

//service class (strategy)
//Hides details about connection
//Called by UserServiceDBSQL
public class DbConnectionService {
    private static Connection dbConnection;
    private static String schema, path;

    public static String getSchema() {
        return schema;
    }

    public static Connection getDbConnection() {
        return dbConnection;
    }

    public static void disconnect(){
        try {
            dbConnection.close();
        }catch (SQLException e){
            throw new ConnectionException(e);
        }
    }
    //Singleton pattern restricts the instantiation
    //of a class and ensures that only one
    //instance of the class exist
    public static void connect (String dbURL, String  searchPath){
        schema = searchPath;
        path = dbURL;
        DBConnectionManager connectionManager = DBConnectionManager.getInstance(dbURL);
        dbConnection = connectionManager.getConnection();
    }


}
