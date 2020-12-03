package Models;

public class User {
    private int id;
    private String identification, firstName, lastName, userName, password;

    public User() {}

    public User(int id, String identification, String firstName, String lastName, String userName) {
        this.id = id;
        this.identification = identification;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public String getIdentification() { return this.identification = identification; }
    public void setIdentification(String identification) { this.identification = identification; }

    public String getFirstName() { return this.firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return this.lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getUserName() { return this.userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return this.password; }
    public void setPassword(String password) { this.password = password; }

}
