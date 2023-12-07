package Model;


public class User {
    int id;
    String name;
    String email;
    String password;
    char type;

    /**
     *
     */
    public User() {

    }
    
    /**
     *
     * @param id
     * @param name
     * @param email
     */
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    /**
     *
     * @param id
     * @param name
     * @param email
     * @param password
     * @param type
     */
    public User(int id, String name, String email, String password, char type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
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
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public char getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(char type) {
        this.type = type;
    }
}
