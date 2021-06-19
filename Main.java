import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.*;

public class Main {
    static Scanner sc;
    static List<User> users;
    static List<Application> applications;
    static List<Company> companies;

    static void addCompany(int userid){
        System.out.print("Name : ");
        String name = sc.nextLine();
        System.out.print("Description : ");
        String des = sc.nextLine();
        System.out.print("Email : ");
        String email = sc.nextLine();
        System.out.print("Phone : ");
        String phone =sc.nextLine();
        companies.add(new Company(name, des, email, phone, userid));
        
    }

    static void deleteCompany(){
        System.out.println("\nID\tName\tDescription\tEmail\tPhone\n");
                    if(users.size()==0){
                        System.out.println("No Company Found!");
                    }else{
                        int i=0;
                        for(Company c:companies){
                            System.out.printf("%d\t%s\t%s\t%s\t%s\n",i++,c.getName(),c.getDescp(),c.getEmail(),c.getEmail());
                        }
                        System.out.println("Enter id to delete : ");
                        companies.remove(Integer.parseInt(sc.nextLine()));
                    }
    }
    static void editCompany(){
        
    }

    static void addApplication(){

    }

    static void deleteApplication(){

    }
    static void editApplication(){

    }

    static void companyMenu(int userId) throws Exception{
        System.out.println("1. Add\n2. Edit\n3. Delete\n4. View Applications\n5. Previous Menu\n6. Main Menu\n");
        System.out.print("\nEnter Option : ");
        
        int choice = Integer.parseInt(sc.nextLine());
        System.out.println(choice);
        
        switch(choice){
            case 1:
                addCompany(userId);
                break;
            case 2:
                editCompany();
                break;
            case 3:
                deleteCompany();
            case 4:
                return;
            case 5:
                mainMenu();
                break;
        }
    }
    static void userOptions() throws Exception{
        System.out.println("1. Add\n2.Delete\n3.Previous Menu\n4. Main Menu\n");
        System.out.print("\nEnter Option : ");
        
        int choice = Integer.parseInt(sc.nextLine());
        System.out.println(choice);
        
        switch(choice){
            case 1:
                addUser();
                break;
            case 2:
                deleteUser();
                break;
            case 3:
                return;
            case 4:
                mainMenu();
                break;
        }
    }
    static void deleteUser(){
        System.out.println("\nID\tUsername\tEmail\tAddress\tPhone");
        if(users.size()==0){
        System.out.println("No User Found!");
        }else{
            int i=0;
            for(User u:users){
                System.out.printf("%d\t%s\t%s\t%s\n", i,u.getUsername(),u.getEmail(),u.getAddress(),u.getPhone());
                i++;
            }
            
            System.out.println("Enter id to delete : ");
            users.remove(sc.nextInt());

        }
    }
    static void addUser(){

        
        System.out.println("---- Add User ----\n");
        System.out.print("Username : ");
        String username = sc.nextLine().trim();
        System.out.print("Password : ");
        String pass = sc.nextLine().trim();
        System.out.print("Email : ");
        String email = sc.nextLine().trim();
        System.out.print("Address : ");
        String add = sc.nextLine().trim();
        System.out.print("Phone : ");
        String phone = sc.nextLine().trim();
        users.add(new User(username,pass,email,add,phone));
        
    }
    static void adminMenu()throws Exception{

        
        System.out.println("Admin Menu");

        File file = new File("db.txt");
        if(!file.exists()){
            System.out.println("\nCreate Admin User ----\n");
            System.out.print("Username : ");
            String username = sc.nextLine().trim();
            System.out.print("Password : ");
            String password = sc.nextLine().trim();
            FileWriter writer = new FileWriter("db.txt");
            writer.write(username+" "+password);
            writer.close();
        }
        Scanner ip = new Scanner(new FileInputStream("db.txt"));
        String s[] = ip.nextLine().split(" ");
        System.out.print("Username : ");
        String username = sc.nextLine().trim();
        System.out.print("Password : ");
        String password = sc.nextLine().trim();
        ip.close();
        if(s[0].equals(username) && s[1].equals(password)){
            System.out.println("Login Success!\n");
            System.out.println("1.Users\n2.Companies\n3.Applications\4.Main Menu\n\n");
            System.out.print("Enter Option : ");
            int op = Integer.parseInt(sc.nextLine());
            
            switch(op){
                case 1:
                    System.out.println("\nID\tUsername\tEmail\tAddress\tPhone\n");
                    if(users.size()==0){
                        System.out.println("No User Found!");
                    }else{
                        for(User u:users){
                            System.out.printf("%d\t%s\t%s\t%s\n", u.getId(),u.getUsername(),u.getEmail(),u.getAddress(),u.getPhone());
                        }
                    }
                    userOptions();
                    break;
                case 2:
                    System.out.println("\nID\tName\tDescription\tEmail\tPhone\n");
                    if(users.size()==0){
                        System.out.println("No Company Found!");
                    }else{
                        for(Company c:companies){
                            System.out.printf("%d\t%s\t%s\t%s\t%s\n",c.getId(),c.getName(),c.getDescp(),c.getEmail(),c.getEmail());
                        }
                    }
                    companyMenu(0);
                    break;
                case 3:
                    System.out.println("\nID\tName\tDescription\tOwner\tCategory\n");
                    if(users.size()==0){
                        System.out.println("No Application Found!");
                    }else{
                        for(Application a:applications){
                            System.out.printf("%d\t%s\t%s\t%s\t%s\n",a.getId(),a.getName(),a.getOwner(),a.getCategory());
                        }
                    }
                    break;
                case 4:
                    mainMenu();
                    break;   
            }
        }else{
            System.out.println("\nInvalid Credentials \n");
            mainMenu();
        }
    }
    static void userMenu(){
        System.out.println("User Menu");
    }
    static void mainMenu() throws Exception{
        
        System.out.println("\n ------ Main Menu ---------\n1.Admin\n2.User\n3.Exit\n");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                adminMenu();
                break;
            
            case 2:
                userMenu();
                break;
            case 3:
                System.out.println("Exiting program .... \n");
                System.exit(0);
            default:
                System.out.println("\n\n------ Invalid Input ------------ \n\n");
        }
        
    }
    public static void main(String[] args) throws Exception{

        users = new ArrayList<>();
        companies = new ArrayList<>();
        applications = new ArrayList<>();
        sc = new Scanner(System.in);
        mainMenu();
    }
}
