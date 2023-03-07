import java.io.IOException;

public class miniChatApp {

    public static void main(String[] args) throws IOException, InterruptedException {
        int portServer = 77; // TODO get from api
        int portClient = 88; // TODO get from  api
        String user = "Jack"; // TODO get from api and implement
        post post = new post();
        // server server = new server();
        // client client = new client();
        // server.startServer(portServer);
        // client.runClient(portClient , user);
        //post.POSTLoggin("Jack", "pass1");
        // boolean isLoggedIn = post.POSTUserLoggedIn(user);
        // System.out.println(isLoggedIn);
        post.POSTuserPort("Tess");
    }

}