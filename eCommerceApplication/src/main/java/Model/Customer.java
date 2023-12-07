package Model;


public class Customer extends User{
    int id;
    String contactNo;
    String address;

    /**
     *
     */
    public Customer() {
    }

    /**
     *
     * @param id
     * @param contactNo
     * @param address
     */
    public Customer(int id, String contactNo, String address) {
        this.id = id;
        this.contactNo = contactNo;
        this.address = address;
    }

    /**
     *
     * @param id
     * @param name
     * @param email
     * @param id1
     * @param contactNo
     * @param address
     */
    public Customer(int id, String name, String email, int id1, String contactNo, String address) {
        super(id, name, email);
        this.id = id1;
        this.contactNo = contactNo;
        this.address = address;
    }

    /**
     *
     * @return
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getContactNo() {
        return contactNo;
    }

    /**
     *
     * @param contactNo
     */
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
