import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.*;

public class Main {

    static void addCompany(List<Company> companies, int userid){

        Scanner sc = new Scanner(System.in);
        sc.next();
        System.out.print("Name : ");
        String name = sc.nextLine();
        System.out.print("Description : ");
        String des = sc.nextLine();
        System.out.print("Email : ");
        String email = sc.nextLine();
        System.out.print("Phone : ");
        String phone =sc.nextLine();
        companies.add(new Company(name, des, email, phone, userid));

        sc.close();
    }

    static void deleteCompany(List<Company> companies){

    }
    static void editCompany(List<Company> companies){

    }

    static void addApplication(List<Application> applications){

    }

    static void deleteApplication(List<Application> applications){

    }
    static void editApplication(List<Application> applications){

    }

    static void companyMenu(List<User> users,List<Company> companies, List<Application> applications, int userId) throws Exception{
        System.out.println("1. Add\n2. Edit\n3. Delete\n4. View Applications\n5. Previous Menu\n6. Main Menu\n");
        System.out.print("\nEnter Option : ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        System.out.println(choice);
        sc.close();
        switch(choice){
            case 1:
                addCompany(companies,userId);
                break;
            case 2:
                editCompany(companies);
                break;
            case 3:
                deleteCompany(companies);
            case 4:
                return;
            case 5:
                mainMenu(users, companies, applications);
                break;
        }
    }
    static void addUser(List<User> users){

        Scanner sc = new Scanner(System.in);
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
        sc.close();
    }
    static void adminMenu(List<User> users,List<Company> companies, List<Application> applications)throws Exception{

        Scanner sc = new Scanner(System.in);
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
            int op = sc.nextInt();
            sc.close();
            switch(op){
                case 1:
                    System.out.println("\nID\tUsername\tEmail\tAddress\tPhone");
                    if(users.size()==0){
                        System.out.println("No User Found!");
                    }else{
                        for(User u:users){
                            System.out.printf("%d\t%s\t%s\t%s\n", u.getId(),u.getUsername(),u.getEmail(),u.getAddress(),u.getPhone());
                        }
                    }
                    
                    break;
                case 2:
                    System.out.println("\nID\tName\tDescription\tEmail\tPhone\\n");
                    if(users.size()==0){
                        System.out.println("No Company Found!");
                    }else{
                        for(Company c:companies){
                            System.out.printf("%d\t%s\t%s\t%s\t%s\n",c.getId(),c.getName(),c.getDescp(),c.getEmail(),c.getEmail());
                        }
                    }
                    companyMenu(users,companies,applications,0);
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
                    mainMenu(users,companies,applications);
                    break;   
            }
        }else{
            System.out.println("\nInvalid Credentials \n");
            mainMenu(users,companies,applications);
        }
    }
    static void userMenu(){
        System.out.println("User Menu");
    }
    static void mainMenu(List<User> users,List<Company> companies, List<Application> applications) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("\n ------ Main Menu ---------\n1.Admin\n2.User\n3.Exit\n");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                adminMenu(users,companies,applications);
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
        sc.close();
    }
    public static void main(String[] args) throws Exception{

        List<User> users = new ArrayList<>();
        List<Company> companies = new ArrayList<>();
        List<Application> applications = new ArrayList<>();
        mainMenu(users,companies,applications);
    }
}
