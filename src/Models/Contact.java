package Models;

public class Contact {
    private int id;
    private String name, phone, operator;
    public Contact() {}
    public Contact(int id, String name, String phone, String operator) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.operator = operator;
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return this.phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getOperator() { return this.operator; }
    public void setOperator(String operator) { this.operator = operator; }
}
