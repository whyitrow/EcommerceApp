package Model;


public class Cart {
    int id;
    int seller_id;
    String name;
    Double price;
    String category;
    int quantity;

    /**
     *
     * @param product
     */
    public Cart(Product product) {
        this.id = product.getId();
        this.seller_id = product.getSeller_id();
        this.name = product.getName();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.quantity = 1;
    }

    /**
     *
     * @param id
     * @param seller_id
     * @param name
     * @param price
     * @param category
     * @param quantity
     */
    public Cart(int id, int seller_id, String name, Double price, String category, int quantity) {
        this.id = id;
        this.seller_id = seller_id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    /**
     *
     * @param seller_id
     * @param name
     * @param price
     * @param category
     * @param quantity
     */
    public Cart(int seller_id, String name, Double price, String category, int quantity) {
        this.seller_id = seller_id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
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
    public int getSeller_id() {
        return seller_id;
    }

    /**
     *
     * @param seller_id
     */
    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

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
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
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
    
    
}
