import java.io.IOException;
import java.util.Scanner;

public class miniChatApp {

    public static void main(String[] args) throws IOException, InterruptedException {
        int portServer;
        int portClient;
        String userDetails;
        String password;
        String user;
        String jwt;
        String clientUser;
        int port;
        post post = new post();
        server server = new server();
        client client = new client();
        Scanner loggin = new Scanner(System.in);
        System.out.println("Enter username");
        user = loggin.nextLine();
        System.out.println("Enter password");
        password = loggin.nextLine();
        userDetails = post.loggin(user,password);
        String[] split = userDetails.split(";;");
        jwt= split[0];
        port = Integer.parseInt(split[1]);
        portServer = port;
        System.out.println("Enter the user name to other client");
        clientUser = loggin.nextLine();
        portClient = post.userPort(clientUser ,jwt);
        server.startServer(portServer,clientUser);
        client.runClient(portClient , clientUser , user, jwt);
        loggin.close();
    }

}