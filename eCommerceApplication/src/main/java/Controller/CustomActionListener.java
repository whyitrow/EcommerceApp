package Controller;

import Model.Admin;
import Model.Customer;
import Model.Seller;
import Model.User;
import View.LoginDialog;
import View.MainFrame;
import View.SellerDashboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CustomActionListener implements ActionListener {

    /**
     *
     */
    public static MainFrame refgMainFrame;
    LoginController loginController;

    /**
     *
     * @param mainFrame
     * @throws SQLException
     */
    public CustomActionListener(MainFrame mainFrame) throws SQLException {
        this.refgMainFrame = mainFrame;
        loginController = new LoginController();
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("SignIn")) {
            refgMainFrame.loginDialog.setVisible(true);

        } else if (actionCommand.equals("LogIn")) {

            try {
                User user;
                
                user = loginController.isValidUser(refgMainFrame.loginDialog.getTxtEmail().getText(),
                        hashPassword(refgMainFrame.loginDialog.getTxtPassword().getPassword()));
                if (user != null) {
                    if (user instanceof Seller) {
                        refgMainFrame.seller=(Seller)user;
                        refgMainFrame.sellerDashboard=new SellerDashboard(refgMainFrame.seller);
                       
                        refgMainFrame.getPnlMainCard().add(refgMainFrame.sellerDashboard, "SellerDashboard");
                        refgMainFrame.cardLayout.show(refgMainFrame.getPnlMainCard(),"SellerDashboard");
                        
                        
                    }
                    else if (user instanceof Customer) {
                        refgMainFrame.customer=(Customer)user;
                        refgMainFrame.cardLayout.show(refgMainFrame.getPnlMainCard(), "allProducts");
                    }else if(user instanceof Admin){
                        
                    }else{
                        
                    }
                    
                    
                    refgMainFrame.loginDialog.dispose();
                    
                } else {
                    refgMainFrame.loginDialog.getLblWarning().setVisible(true);
                }
                refgMainFrame.loginDialog.getTxtEmail().setText("");
                refgMainFrame.loginDialog.getTxtPassword().setText("");

            } catch (SQLException ex) {
                Logger.getLogger(CustomActionListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(actionCommand.equals("Search")){
            System.out.println("Search");
            String search=refgMainFrame.getTxtSearch().getText();
            try {
                refgMainFrame.LoadFilteredProducts(search);
            } catch (SQLException ex) {
                Logger.getLogger(CustomActionListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        else if(actionCommand.equals("Checkout")){
            refgMainFrame.LoadCheckoutProducts();
            refgMainFrame.cardLayout.show(refgMainFrame.getPnlMainCard(), "showcart");
            
        }else if(actionCommand.equals("Order")){
            refgMainFrame.LoadOrderdProducts();
            refgMainFrame.cardLayout.show(refgMainFrame.getPnlMainCard(), "showorder");
        }
        
        
        
        
        

    }

    
    private String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
    
    private String hashPassword(char[] password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(new String(password).getBytes());
            return bytesToHex(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
}
