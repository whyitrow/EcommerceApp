package Model;


public class Admin extends User{

    String position;

    /**
     *
     */
    public Admin() {
    }

    /**
     *
     * @param id
     * @param name
     * @param email
     */
    public Admin(int id, String name, String email) {
        super(id, name, email);
    }

    /**
     *
     * @return
     */
    public String getPosition() {
        return position;
    }

    /**
     *
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }
}
