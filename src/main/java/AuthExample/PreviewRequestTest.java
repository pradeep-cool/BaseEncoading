package AuthExample;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class PreviewRequestTest {

	    public static void main(String[] args) {

	        try {
	            URL url = new URL ("https://qa-testcloud.quinnox.info/login");
	            String encoding = Base64.getEncoder().encodeToString(("mobileapp:N@d@123").getBytes("UTF-8"));

	            System.out.println("data"+ encoding);
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//	            connection.setReadTimeout(5000);
//	            connection.setConnectTimeout(5000);
	            connection.setRequestMethod("POST");

//	            connection.setDoInput(true);
//	            connection.setDoOutput(true);
	            connection.setRequestProperty  ("Authorization", "Basic " + encoding);
	            InputStream content = (InputStream)connection.getInputStream();
	            BufferedReader in   =  new BufferedReader (new InputStreamReader (content));
	            String line;
	            while ((line = in.readLine()) != null) {
	                System.out.println(line);
	                connection.getOutputStream().close();
	            }
	        } catch(Exception e) {
	            e.printStackTrace();
	        }

	    }

	}
