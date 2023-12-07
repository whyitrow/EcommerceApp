package Controller;

import Model.Order;
import Model.Product;
import View.MainFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OrderController {
    
    
    Connection connection;

    /**
     *
     * @throws SQLException
     */
    public OrderController() throws SQLException {
       connection= DbHandler.getInstance().getConnection();
    }

    /**
     *
     */
    public void checkoutCart() {
        
        try {
            ArrayList<Order> orders=new ArrayList<>();
           
           String query = "INSERT INTO `order` (`product_id`, `buyer_id`, `seller_id`,`name`,`price`,`quantity`) VALUES (?,?,?,?,?,1);";
            for(int i=0;i<MainFrame.cart.size();i++){
            PreparedStatement statment=connection.prepareStatement(query);
            statment.setInt(1, MainFrame.cart.get(i).getId());
            statment.setInt(2, MainFrame.customer.getId());
            statment.setInt(3, MainFrame.cart.get(i).getSeller_id());
            statment.setString(4, MainFrame.cart.get(i).getName());
            statment.setDouble(5, MainFrame.cart.get(i).getPrice());
            statment.execute();
            statment.close();
            statment.close();
            }
            MainFrame.cart.clear();
            MainFrame.order=getOrders();
       
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<Order> getOrders() throws SQLException{
        String query="select * from `order` where buyer_id="+MainFrame.customer.getId()+";";
        Statement stat=connection.createStatement();
        ResultSet result=stat.executeQuery(query);
        ArrayList<Order> orders=new ArrayList<>();
                
        while (result.next()) {
            orders.add(new Order(result.getInt("product_id"),result.getInt("buyer_id"),result.getInt("seller_id"), result.getString("name"), result.getDouble("price"), result.getInt("quantity"), result.getString("order_date")));
        }
        
        stat.close();
        result.close();
        
        return orders;
    }
    
    
    
    
    
    
}
