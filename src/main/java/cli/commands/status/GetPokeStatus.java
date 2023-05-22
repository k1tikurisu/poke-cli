package cli.commands.status;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class GetPokeStatus implements Runnable {
  private String name;

  public GetPokeStatus(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    try {
      // Make the API request
      URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + name);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      int responseCode = connection.getResponseCode();

      // Check if the request was successful
      if (responseCode == 200) {
        // Read the response
        BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        String jsonResponse = responseReader.lines().collect(Collectors.joining());
        responseReader.close();

        // Parse the JSON response
        String[] stats = jsonResponse.split("\"stats\":\\[")[1].split("\\]")[0].split("\\},\\{");

        // Print the status of the Pokemon
        System.out.println("Pokemon status for " + name + ":");
        for (String stat: stats) {
          String statName = stat.split("\"name\":\"")[1].split("\"")[0];
          int baseStat = Integer.parseInt(stat.split("\"base_stat\":")[1].split(",")[0]);
          System.out.println(statName + ": " + baseStat);
        }
      } else if (responseCode == 404) {
        System.out.println(name + " does not exists");
        System.out.println("you can use all option. ex, poke get -all");
      } else {
        System.out.println("Failed to fetch Pokemon data. Error code: " + connection.getResponseCode());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}