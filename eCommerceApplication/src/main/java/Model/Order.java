package Model;

/**
 *
 * @author Muhammad Rizwan
 */
public class Order {
    int id;
    int productId;
    int buyerId;
    int SellerId;
    int quantity;
    String date;
    String name;
    Double price;

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Double getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     *
     * @param productId
     * @param buyerId
     * @param SellerId
     * @param name
     * @param price
     * @param quantity
     * @param date
     */
    public Order(int productId, int buyerId, int SellerId, String name, Double price, int quantity, String date) {
        this.productId = productId;
        this.buyerId = buyerId;
        this.SellerId = SellerId;
        this.quantity = quantity;
        this.date = date;
        this.name = name;
        this.price = price;
    }

    /**
     *
     * @param productId
     * @param buyerId
     * @param sellerId
     * @param quantity
     * @param date
     */
    public Order(int productId, int buyerId, int sellerId, int quantity, String date) {
        this.productId = productId;
        this.buyerId = buyerId;
        SellerId = sellerId;
        this.quantity = quantity;
        this.date = date;
    }

    /**
     *
     * @param id
     * @param productId
     * @param buyerId
     * @param sellerId
     * @param quantity
     * @param date
     */
    public Order(int id, int productId, int buyerId, int sellerId, int quantity, String date) {
        this.id = id;
        this.productId = productId;
        this.buyerId = buyerId;
        SellerId = sellerId;
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
    public int getSellerId() {
        return SellerId;
    }

    /**
     *
     * @param sellerId
     */
    public void setSellerId(int sellerId) {
        SellerId = sellerId;
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
