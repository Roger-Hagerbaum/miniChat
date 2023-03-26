import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class post {

    public String  loggin(String user, String password) throws IOException {
        String userDetails;
        int i = 0;
        URL postUrl = new URL("http://localhost:8080/api/auth/token");
        HttpURLConnection postConnection = (HttpURLConnection) postUrl.openConnection();
        String auth = user + ":" + password;
        String basicAuth = "Basic " + new String(Base64.getEncoder().encode(auth.getBytes()));
        postConnection.setRequestMethod("POST");
        postConnection.setRequestProperty("Authorization", basicAuth);

        BufferedReader inputStream = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
        String inputRespons;
        StringBuilder responseBuilder = new StringBuilder();
        while ((inputRespons = inputStream.readLine()) != null) {
            responseBuilder.append(inputRespons);
        }
        inputStream.close();
        userDetails = String.valueOf(responseBuilder);

        return userDetails;

    }
    public String userLoggedIn(String user, String jwt) throws IOException {

        URL postUrl = new URL("http://localhost:8080/api/closed/userloggedin?userName="+ user);
        HttpURLConnection postConnection = (HttpURLConnection) postUrl.openConnection();
        postConnection.setRequestMethod("POST");
        postConnection.setRequestProperty("Authorization","Bearer "+ jwt);
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
        String inputRespons;
        StringBuilder responseBuilder = new StringBuilder();
        while ((inputRespons = inputStream.readLine()) != null) {
            responseBuilder.append(inputRespons);
        }
        inputStream.close();

        String isUserLoggedIn = String.valueOf(responseBuilder);


        return isUserLoggedIn;
    }
    public int userPort(String user , String jwt) throws IOException {

        URL postUrl = new URL("http://localhost:8080/api/closed/userport?userName=" +user);
        HttpURLConnection postConnection = (HttpURLConnection) postUrl.openConnection();
        postConnection.setRequestMethod("POST");
        postConnection.setRequestProperty("Authorization","Bearer "+ jwt);

        BufferedReader inputStream = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
        String inputRespons;
        StringBuilder responseBuilder = new StringBuilder();
        while ((inputRespons = inputStream.readLine()) != null) {
            responseBuilder.append(inputRespons);
        }
        inputStream.close();

        int port = Integer.parseInt(String.valueOf(responseBuilder));
        System.out.println(responseBuilder.toString());
        System.out.println(port);
        return port;

    }

}
