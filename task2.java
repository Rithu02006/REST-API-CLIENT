import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestApiClient {

    public static void main(String[] args) {
        try {
            // API URL
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");

            // Create connection
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Read response
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            // Output
            System.out.println("Response from REST API:");
            System.out.println(response.toString());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
