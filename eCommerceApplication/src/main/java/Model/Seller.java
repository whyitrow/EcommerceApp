package Model;

public class Seller extends User{
    int id;
    String contact;
    double balance;

    /**
     *
     */
    public Seller() {
    }

    /**
     *
     * @param id
     * @param contact
     * @param balance
     */
    public Seller(int id, String contact, double balance) {
        this.id = id;
        this.contact = contact;
        this.balance = balance;
    }

    /**
     *
     * @param id
     * @param name
     * @param email
     * @param id1
     * @param contact
     * @param balance
     */
    public Seller(int id, String name, String email, int id1, String contact, double balance) {
        super(id, name, email);
        this.id = id1;
        this.contact = contact;
        this.balance = balance;
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
    public String getContact() {
        return contact;
    }

    /**
     *
     * @param contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     *
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /**
     *
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
