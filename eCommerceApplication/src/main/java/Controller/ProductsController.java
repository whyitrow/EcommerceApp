package Controller;

import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProductsController {
    Connection connection;

    /**
     *
     * @throws SQLException
     */
    public ProductsController() throws SQLException {
        connection=DbHandler.getInstance().getConnection();
    }
    
    /**
     *
     * @param product
     * @return
     */
    public boolean addProduct(Product product){
        String query = "INSERT INTO product (name, price, discription, catagory, seller_id, quantity, image, shipement_charges) VALUES (?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement statment=connection.prepareStatement(query);
            statment.setString(1, product.getName());
            statment.setDouble(2, product.getPrice());
            statment.setString(3, product.getDescription());
            statment.setString(4, product.getCategory());
            statment.setInt(5, product.getSeller_id());
            statment.setInt(6, product.getQuantity());
            statment.setString(7, product.getPictureFile());
            statment.setDouble(8, product.getShipmentCharges());
            
            boolean result= statment.execute();
            statment.close();
            //connection.close();
            System.out.println(result);
            return result;
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public String getTotalProducts(int id) throws SQLException{
        String query = "select COUNT(*) from `product` where seller_id="+String.valueOf(id);
        Statement stat=connection.createStatement();
        ResultSet result=stat.executeQuery(query);
        result.next();
        String products=result.getString(1);
        stat.close();
        result.close();
        return products;

    }
    
    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public String getOrders(int id) throws SQLException{
        String query="select COUNT(*) from `order` where seller_id="+String.valueOf(id)+";";
        Statement stat=connection.createStatement();
        ResultSet result=stat.executeQuery(query);
        result.next();
        String orders=result.getString(1);
        stat.close();
        result.close();
        return orders;
    }
    
    /**
     *
     * @param id
     * @return
     */
    public boolean deleteProduct(int id){
        return true;
    }
    
    /**
     *
     * @param id
     * @param product
     * @return
     */
    public boolean updateProduct(int id,Product product){
        return true;
    }
    
    /**
     *
     * @param id
     * @param quantity
     */
    public void updateQuantity(int id, int quantity){
        
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<Product> loadProducts() throws SQLException{
        String query="select * from `product`;";
        Statement stat=connection.createStatement();
        ResultSet result=stat.executeQuery(query);
        ArrayList<Product> products=new ArrayList<>();
                
        while (result.next()) {
            products.add(new Product(result.getInt("id"),result.getInt("seller_id"), result.getString("name"), result.getString("discription"),
                    result.getDouble("price"), result.getDouble("shipement_charges"), result.getString("image"), 
                    result.getString("catagory"),result.getInt("quantity")));
        }
        
        stat.close();
        result.close();
        
        return products;
    }
    
    /**
     *
     * @param seller_id
     * @return
     * @throws SQLException
     */
    public ArrayList<Product> loadProducts(int seller_id) throws SQLException{
        String query="select * from `product` where seller_id="+String.valueOf(seller_id)+";";
        Statement stat=connection.createStatement();
        ResultSet result=stat.executeQuery(query);
        ArrayList<Product> products=new ArrayList<>();
                
        while (result.next()) {
            products.add(new Product(result.getInt("id"),seller_id, result.getString("name"), result.getString("discription"),
                    result.getDouble("price"), result.getDouble("shipement_charges"), result.getString("image"), 
                    result.getString("catagory"),result.getInt("quantity")));
        }
        
        stat.close();
        result.close();
        
        return products;
    }
    
}
