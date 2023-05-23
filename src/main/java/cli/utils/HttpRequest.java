package cli.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class HttpRequest {
  private String url;

  public HttpRequest(String url) {
    this.url = url;
  }

  public String getResponse() {
    try {
      URL urlObj = new URL(this.url);
      HttpURLConnection connection;
      connection = (HttpURLConnection) urlObj.openConnection();
      connection.setRequestMethod("GET");
      int responseCode = connection.getResponseCode();
      
      if (responseCode == 200) {
        BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        String jsonResponse = responseReader.lines().collect(Collectors.joining());
        responseReader.close();

        return jsonResponse;
      }
      
      return "404";
    } catch (IOException e) {
      e.printStackTrace();
      return e.getMessage();
    }
  }
}
