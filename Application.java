public class Application {
    private static int count=1;
    private int id;
    private String name;
    private String descp;
    private String owner;
    private String category;
    private int cid;
    public Application(String name, String descp, String owner, String category, int cid) {
        this.name = name;
        this.descp = descp;
        this.owner = owner;
        this.category = category;
        this.cid = cid;
        this.id = Application.count++;
    }
    public int getId() {
        return id;
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
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
