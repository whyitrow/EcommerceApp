package Model;


public class Product {
    int id;
    int seller_id;
    String name;
    String description;
    Double price;
    Double shipmentCharges;
    String pictureFile;
    String category;
    int quantity;

    /**
     *
     * @param seller_id
     * @param name
     * @param description
     * @param price
     * @param shipmentCharges
     * @param pictureFile
     * @param category
     * @param quantity
     */
    public Product(int seller_id, String name, String description, Double price, Double shipmentCharges, String pictureFile, String category, int quantity) {
        this.seller_id = seller_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.shipmentCharges = shipmentCharges;
        this.pictureFile = pictureFile;
        this.category = category;
        this.quantity = quantity;
    }

    /**
     *
     * @param id
     * @param seller_id
     * @param name
     * @param description
     * @param price
     * @param shipmentCharges
     * @param pictureFile
     * @param category
     * @param quantity
     */
    public Product(int id, int seller_id, String name, String description, Double price, Double shipmentCharges, String pictureFile, String category, int quantity) {
        this.id = id;
        this.seller_id = seller_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.shipmentCharges = shipmentCharges;
        this.pictureFile = pictureFile;
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
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
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
    public Double getShipmentCharges() {
        return shipmentCharges;
    }

    /**
     *
     * @param shipmentCharges
     */
    public void setShipmentCharges(Double shipmentCharges) {
        this.shipmentCharges = shipmentCharges;
    }

    /**
     *
     * @return
     */
    public String getPictureFile() {
        return pictureFile;
    }

    /**
     *
     * @param pictureFile
     */
    public void setPictureFile(String pictureFile) {
        this.pictureFile = pictureFile;
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
