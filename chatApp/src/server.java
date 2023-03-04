

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

 public class server {

     public void startServer (int port) throws IOException{
        
         try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket socket = serverSocket.accept();

                 InputStream inputStream = socket.getInputStream();
                 DataInputStream dataInputStream = new DataInputStream(inputStream);
                 
                String message = dataInputStream.readUTF();

                System.out.println(message);
        }
         }
         
     
     
 }
 
