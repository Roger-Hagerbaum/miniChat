import java.io.IOException;
import java.util.Scanner;

public class miniChatApp {

    public static void main(String[] args) throws IOException, InterruptedException {
        int portServer;
        int portClient;
        String userDetails = null;
        String password;
        String user = null;
        String jwt;
        String responsCode = "";
        String clientUser;
        String loginStatus = "Trying to login";
        String answer;
        boolean tryLogIn = true;
        boolean register = false;
        int port;
        post post = new post();
        server server = new server();
        client client = new client();
        miniChatApp miniChatApp = new miniChatApp();
        Scanner login = new Scanner(System.in);
        while (tryLogIn) {
            tryLogIn = false;
            System.out.println("To login pleas enter the information required!");
            System.out.println("Enter username:");
            user = login.nextLine();
            System.out.println("Enter password:");
            password = login.nextLine();
            try {
                loginStatus = post.login(user,password);
            }catch (IOException e){
               if(e.getMessage().contains("401")) {
                   responsCode = "401";
               }
            }
            if(responsCode.equals("401")){
                System.out.println("Password incorrect");
                System.out.println("Please try again!!");
                tryLogIn = true;
            }

            String[] split = loginStatus.split(";;");
            responsCode = split[0];
            if(responsCode.equals("false")){
                System.out.println("User not found");
                System.out.println("To try a new user name enter 1 to register a new user enter 2");
                tryLogIn = true;
                answer = login.nextLine();
                if(answer.equals("2")){
                    System.out.println("Pleas enter new user information");
                    System.out.println("Enter username:");
                    user = login.nextLine();
                    System.out.println("Enter password:");
                    password = login.nextLine();
                    String createUser = post.registerNewUser(user,password);
                    System.out.println(createUser);
                    System.out.println("Pleas login whit the new user!");
                }
            }

        }
        String[] split = loginStatus.split(";;");
        jwt= split[0];
        port = Integer.parseInt(split[1]);

        portServer = port;
        System.out.println("Enter the user name to other client");
        clientUser = login.nextLine();
        portClient = post.userPort(clientUser ,jwt);
        server.startServer(portServer,clientUser);
        client.runClient(portClient , clientUser , user, jwt);
        login.close();
    }





}