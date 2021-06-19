public class Company {
    private static int count =0;

    private int id;
    private String name;
    private String descp;
    private String email;
    private String phone;
    private int userid;
 
    public Company(String name, String descp, String email, String phone, int userid) {
        this.name = name;
        this.descp = descp;
        this.email = email;
        this.phone = phone;
        this.userid = userid;
        this.id = Company.count++;
    }

    public int getId(){
        return this.id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescp() {
        return descp;
    }
    public void setDescp(String descp) {
        this.descp = descp;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
}
