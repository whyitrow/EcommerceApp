package View;

import Controller.CustomActionListener;
import Controller.DbHandler;
import Controller.OrderController;
import Controller.ProductsController;
import Model.Cart;
import Model.Customer;
import Model.Order;
import Model.Product;
import Model.Seller;
import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainFrame extends javax.swing.JFrame {

    /**
     *
     */
    public static CustomActionListener customActionListener;

    /**
     *
     */
    public static OrderController orderController;
    
    /**
     *
     */
    public static LoginDialog loginDialog;

    /**
     *
     */
    public SellerDashboard sellerDashboard;
    
    /**
     *
     */
    public CardLayout cardLayout;
    
    /**
     *
     */
    public Seller seller;

    /**
     *
     */
    public static Customer customer;

    /**
     *
     */
    public ProductsDisplay productsDisplay,

    /**
     *
     */
    filteredProductsDisplay;

    /**
     *
     */
    public ArrayList<ProductView> productsView;

    /**
     *
     */
    public ArrayList<Product> products;

    /**
     *
     */
    public ProductsController productsController;

    /**
     *
     */
    public static ArrayList<Order> order;
    
    /**
     *
     */
    public static ArrayList<Cart> cart;

    /**
     *
     */
    public CartsView cartView;

    /**
     *
     */
    public OrderView orderView;
    /**
     * Creates new form MainFrame
     * @throws java.sql.SQLException
     */
    public MainFrame() throws SQLException {
        seller=null;
        customer=null;
        initComponents();
        
        setLocationRelativeTo(null);
        cardLayout=(CardLayout) pnlMainCard.getLayout();
        loginDialog=new LoginDialog(this, rootPaneCheckingEnabled);
        productsController=new ProductsController();
        
        orderController=new OrderController();
        productsView=new ArrayList<>();
        products=new ArrayList<>();
        order=new ArrayList<>();
        cart=new ArrayList<>();
        
        
        loadProductsFromDb();
        loadProductsToDisplay(products);
        productsDisplay=new ProductsDisplay(productsView);
        
        pnlMainCard.add(productsDisplay,"allProducts");
        
        
        initControllers();
        initActionCommands();
        DbHandler dbHandler= DbHandler.getInstance();
        loginDialog.setVisible(true);
    }
    
    /**
     *
     * @param search
     * @throws SQLException
     */
    public void LoadFilteredProducts(String search) throws SQLException{
        List<Product> filteredList = products.stream()
                .filter(s -> s.getName().contains(search))
                .collect(Collectors.toList());
        System.out.println(filteredList.size());
        loadProductsToDisplay((ArrayList<Product>) filteredList);
        filteredProductsDisplay=new ProductsDisplay(productsView);
        pnlMainCard.add(filteredProductsDisplay,"allfilterdProducts");
        cardLayout.show(pnlMainCard, "allfilterdProducts");
    }
    
    /**
     *
     * @throws SQLException
     */
    public void loadProductsFromDb() throws SQLException{
        products=productsController.loadProducts();
    }
    
    /**
     *
     * @param productToProcess
     * @throws SQLException
     */
    public void loadProductsToDisplay(ArrayList<Product> productToProcess) throws SQLException{
        if(!productsView.isEmpty()){
            productsView.clear();
        }
        for(int i=0;i<productToProcess.size();i++){
            productsView.add(new ProductView(productToProcess.get(i)));
        }
    }
    
    /**
     *
     */
    public void LoadCheckoutProducts() {
        cartView=new CartsView(cart);
        pnlMainCard.add(cartView,"showcart");
        pnlMainCard.revalidate();
    }
    
    /**
     *
     */
    public void LoadOrderdProducts() {
        orderView=new OrderView(order);
        pnlMainCard.add(orderView,"showorder");
        pnlMainCard.revalidate();
    }
    
    
    void initControllers() throws SQLException{
        customActionListener=new CustomActionListener(this);
    }
    
    void initActionCommands(){
        
        btnLogin.setActionCommand("SignIn");
        btnLogin.addActionListener(customActionListener);
        loginDialog.getBtnLogin().addActionListener(customActionListener);
        
        btnSearch.setActionCommand("Search");
        btnSearch.addActionListener(customActionListener);
        
        btnOrder.setActionCommand("Order");
        btnOrder.addActionListener(customActionListener);
        
        btnCheckout.setActionCommand("Checkout");
        btnCheckout.addActionListener(customActionListener);
    }

    /**
     *
     * @return
     */
    public JTextField getTxtSearch() {
        return jTextField1;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        mainPnl = new javax.swing.JPanel();
        pnlTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnCheckout = new javax.swing.JButton();
        btnOrder = new javax.swing.JButton();
        pnlSearch = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        label1 = new java.awt.Label();
        btnSearch = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        pnlMainCard = new javax.swing.JPanel();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        mainPnl.setBackground(new java.awt.Color(255, 255, 255));

        pnlTitle.setBackground(new java.awt.Color(255, 255, 255));
        pnlTitle.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Shopping Cart Application");

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/loginLogo.png"))); // NOI18N
        btnLogin.setBorder(null);

        btnCheckout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/addCart.png"))); // NOI18N
        btnCheckout.setBorder(null);

        btnOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/order.png"))); // NOI18N
        btnOrder.setBorder(null);

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOrder)
                .addGap(60, 60, 60)
                .addComponent(btnCheckout)
                .addGap(47, 47, 47)
                .addComponent(btnLogin)
                .addContainerGap())
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btnLogin)
                        .addComponent(btnOrder)))
                .addContainerGap())
        );

        pnlSearch.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setToolTipText("");
        jTextField1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Category", "Price Min-Max", "Price Max-Min" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label1.setText("Filter By: ");

        btnSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSearch.setText("Serach");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/home.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField1.getAccessibleContext().setAccessibleName("");

        pnlMainCard.setBackground(new java.awt.Color(255, 255, 255));
        pnlMainCard.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout mainPnlLayout = new javax.swing.GroupLayout(mainPnl);
        mainPnl.setLayout(mainPnlLayout);
        mainPnlLayout.setHorizontalGroup(
            mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMainCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPnlLayout.createSequentialGroup()
                        .addGroup(mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPnlLayout.setVerticalGroup(
            mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMainCard, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            LoadFilteredProducts("");
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     *
     * @return
     */
    public JPanel getPnlMainCard() {
        return pnlMainCard;
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckout;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private javax.swing.JPanel mainPnl;
    private javax.swing.JPanel pnlMainCard;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlTitle;
    // End of variables declaration//GEN-END:variables

    
}
