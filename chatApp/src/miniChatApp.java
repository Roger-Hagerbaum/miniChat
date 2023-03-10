import java.io.IOException;
import java.util.Scanner;

public class miniChatApp {

    public static void main(String[] args) throws IOException, InterruptedException {
        int portServer;
        int portClient;
        String password;
        String user;
        String clientUser;
        post post = new post();
        server server = new server();
        client client = new client();
        Scanner loggin = new Scanner(System.in);
        System.out.println("Enter username");
        user = loggin.nextLine();
        System.out.println("Enter password");
        password = loggin.nextLine();
        portServer = post.loggin(user, password);
        System.out.println("Enter the user name to other client");
        clientUser = loggin.nextLine();
        portClient = post.userPort(clientUser);
        server.startServer(portServer,clientUser);
        client.runClient(portClient , clientUser); 
        loggin.close();
    }

}