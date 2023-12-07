package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbHandler {
    
    static DbHandler dbHandler;

    final String CONNECTION_STRING="jdbc:mysql://localhost:3306/ecommerce";
    final String PASSWORD="";
    final String USER_ID="root";
    Connection connection;
    
    /**
     *
     */
    public DbHandler() {
        try {
            connection=DriverManager.getConnection(CONNECTION_STRING, USER_ID, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DbHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        if(connection.isClosed()){
            connection=DriverManager.getConnection(CONNECTION_STRING, USER_ID, PASSWORD);
        }
        return connection;
    }
    
    /**
     *
     * @return
     */
    public static DbHandler getInstance(){
        if(dbHandler==null){
            dbHandler=new DbHandler();
        }
        return dbHandler;
    }
    
    /**
     *
     * @throws SQLException
     */
    public void closeConnection() throws SQLException{
        if(connection!=null && !connection.isClosed()){
            connection.close();
        }
    }
    
    
}
