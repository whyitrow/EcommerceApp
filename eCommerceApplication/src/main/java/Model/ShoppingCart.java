package Model;


public class ShoppingCart {
    int id;
    int productId;
    int buyerId;
    int quantity;
    String date;

    /**
     *
     * @param productId
     * @param buyerId
     * @param quantity
     * @param date
     */
    public ShoppingCart(int productId, int buyerId, int quantity, String date) {
        this.productId = productId;
        this.buyerId = buyerId;
        this.quantity = quantity;
        this.date = date;
    }

    /**
     *
     * @param id
     * @param productId
     * @param buyerId
     * @param quantity
     * @param date
     */
    public ShoppingCart(int id, int productId, int buyerId, int quantity, String date) {
        this.id = id;
        this.productId = productId;
        this.buyerId = buyerId;
        this.quantity = quantity;
        this.date = date;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public int getProductId() {
        return productId;
    }

    /**
     *
     * @param productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     *
     * @return
     */
    public int getBuyerId() {
        return buyerId;
    }

    /**
     *
     * @param buyerId
     */
    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }
}
