import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class post {

    public String POSTLoggin(String user, String password) throws IOException {

        
        URL postUrl = new URL("http://localhost:8080/loggin?userName="+ user + "&password=" + password);
        HttpURLConnection postConnection = (HttpURLConnection) postUrl.openConnection();
        postConnection.setRequestMethod("POST");

        BufferedReader inputStream = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
        String inputRespons;
        StringBuilder responseBuilder = new StringBuilder();
        while ((inputRespons = inputStream.readLine()) != null) {
            responseBuilder.append(inputRespons);
        }
        inputStream.close();

     
        System.out.println(responseBuilder.toString());
        String result = String.valueOf(responseBuilder);
        System.out.println(result);
        
        return result;

    }
    
}
