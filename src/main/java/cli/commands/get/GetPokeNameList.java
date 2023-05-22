package cli.commands.get;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class GetPokeNameList implements Runnable {
  private Number limit;

  public GetPokeNameList(Number limit) {
    this.limit = limit;
  }

  public void run() {
    try {
      // Make the API request
      URL url = new URL("https://pokeapi.co/api/v2/pokemon?limit=" + limit);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");

      // Check the response code
      int responseCode = connection.getResponseCode();

      if (responseCode == 200) {
        // Read the response
        BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        String jsonResponse = responseReader.lines().collect(Collectors.joining());
        responseReader.close();

        // Parse the JSON response
        String[] pokemonNames = jsonResponse.split("\"name\":\"");
        for (int i = 1; i < pokemonNames.length; i++) {
          String pokemonName = pokemonNames[i].split("\"")[0];
          System.out.println(pokemonName);
        }
      } else {
        System.out.println("Failed to fetch Pokemon data. Error code: " + responseCode);
      }

      connection.disconnect();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}