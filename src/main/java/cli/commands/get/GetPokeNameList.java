package cli.commands.get;

import cli.utils.HttpRequest;

public class GetPokeNameList implements Runnable {
  private Number limit;

  public GetPokeNameList(Number limit) {
    this.limit = limit;
  }

  public void run() {
      // Make the API request
      HttpRequest fetcher = new HttpRequest("https://pokeapi.co/api/v2/pokemon?limit=" + limit);
      String res = fetcher.getResponse();

      // Parse the JSON response
      String[] pokemonNames = res.split("\"name\":\"");
      for (int i = 1; i < pokemonNames.length; i++) {
        String pokemonName = pokemonNames[i].split("\"")[0];
        System.out.println(pokemonName);
      }
  }
}
