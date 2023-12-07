package Controller;

import Model.Product;
import View.MainFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CartController {

    Connection connection;

    /**
     *
     * @throws SQLException
     */
    public CartController() throws SQLException {
       connection= DbHandler.getInstance().getConnection();
                
    }

    /**
     *
     * @param product
     */
    public void addToCart(Product product) {
        String query = "INSERT INTO cart (buyer_id,product_id,seller_id,quantity) VALUES (?,?,?,1);";
        try {
            PreparedStatement statment=connection.prepareStatement(query);
            statment.setInt(1, MainFrame.customer.getId());
            statment.setInt(2, product.getId());
            statment.setInt(3, product.getSeller_id());
            
            boolean result= statment.execute();
            statment.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @throws SQLException
     */
    public static void clearCart() throws SQLException {
        String query = "delete from cart where buyer_id="+MainFrame.customer.getId()+";";
        Statement stat=DbHandler.getInstance().getConnection().createStatement();
        stat.execute(query);
        
    }


    
}

