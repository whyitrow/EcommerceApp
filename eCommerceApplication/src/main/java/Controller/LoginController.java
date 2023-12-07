package Controller;

import Model.Admin;
import Model.Customer;
import Model.Seller;
import Model.User;
import View.MainFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginController {

    Connection connection;

    /**
     *
     * @throws SQLException
     */
    public LoginController() throws SQLException {
        connection = DbHandler.getInstance().getConnection();
    }

    /**
     *
     * @param email
     * @param password
     * @return
     * @throws SQLException
     */
    public User isValidUser(String email, String password) throws SQLException {
        String query = "select id,email, status from users where email=? and password=?;";
        System.out.println(password);
        PreparedStatement stat = connection.prepareStatement(query);
        PreparedStatement stat2 = null;
        stat.setString(1, email);
        stat.setString(2, password);
        ResultSet resultSet = stat.executeQuery();
        ResultSet resultSet2 = null;
        User user = null;
        if (resultSet.next()) {
            String detailsQuery = "";

            if (resultSet.getString("status").equals("S")) {
                detailsQuery = "select * from seller where userid=?;";
                stat2 = connection.prepareStatement(detailsQuery);
                stat2.setInt(1, resultSet.getInt("id"));
                resultSet2 = stat2.executeQuery();
                resultSet2.next();
                user = new Seller(resultSet.getInt("id"), resultSet2.getString("name"),
                        resultSet.getString("email"), resultSet2.getInt("id"),
                        resultSet2.getString("contact"), resultSet2.getDouble("balance"));

            } else if (resultSet.getString("status").equals("C")) {
                detailsQuery = "select * from buyer where userid=?;";
                stat2 = connection.prepareStatement(detailsQuery);
                stat2.setInt(1, resultSet.getInt("id"));
                resultSet2 = stat2.executeQuery();
                resultSet2.next();
                user = new Customer(resultSet.getInt("id"), resultSet2.getString("name"),
                        resultSet.getString("email"), resultSet2.getInt("id"),
                        resultSet2.getString("contact"), resultSet2.getString("c_address"));

            } else if (resultSet.getString("status").equals("A")) {
                detailsQuery = "select * from admin where userid=?;";
                stat2 = connection.prepareStatement(detailsQuery);
                stat2.setInt(1, resultSet.getInt("id"));
                 resultSet2 = stat2.executeQuery();
                resultSet2.next();
                user = new Admin(resultSet.getInt("id"), resultSet2.getString("name"),
                        resultSet.getString("email"));
            }

            stat2.close();
            resultSet2.close();

        }
        stat.close();
        resultSet.close();
        //connection.close();
        return user;
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    public int getUserId() throws SQLException{
        String query="select id from users order by id desc limit 1;";
        Statement stat=connection.createStatement();
        ResultSet result=stat.executeQuery(query);
        result.next();
        int id=result.getInt(1);
        stat.close();
        result.close();
        return id;
    }
    
    /**
     *
     * @param name
     * @param email
     * @param password
     * @param contact
     * @param address
     * @param isSeller
     */
    public void RegisterUser(String name,String email,String password,String contact,String address,boolean isSeller){
        String query = "INSERT INTO users (name,email,password,status) VALUES (?,?,?,?);";
        try {
            PreparedStatement statment=connection.prepareStatement(query);
            statment.setString(1, name);
            statment.setString(2, email);
            statment.setString(3, password);
            statment.setString(4,isSeller ? "S" : "C" );
            boolean result= statment.execute();
            statment.close();
            
            String query1="";
            if(isSeller){
                query1 = "INSERT INTO seller (userid,name,contact,address) VALUES (?,?,?,?);";
            }else{
                query1 = "INSERT INTO buyer (userid,name,contact,c_address) VALUES (?,?,?,?);";
            }
            PreparedStatement statment1=connection.prepareStatement(query1);
            statment1.setInt(1, getUserId());
            statment1.setString(2, name);
            statment1.setString(3, contact);
            statment1.setString(4, address);
            statment1.execute();
            statment1.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

}
