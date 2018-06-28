import java.io.*;
import java.net.*;


public class API {

    public static String getHTML(String urlToRead) throws Exception {

        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        String newLine = System.getProperty("line.separator");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder result = new StringBuilder();
        String line;boolean flag = false;
        while ((line = rd.readLine()) != null) {
            result.append(flag? newLine: "").append(line);
            flag = true;
        }
        rd.close();



        return result.toString();
    }

    public static void main(String[] args) throws Exception
    {
        System.out.println(getHTML("https://jsonplaceholder.typicode.com/comments"));

    }
}