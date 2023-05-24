package cli.commands.get;

import cli.utils.HttpRequest;
import cli.utils.Logger;

public class GetPokeNameList implements Runnable {
  private Number limit;

  public GetPokeNameList(Number limit) {
    this.limit = limit;
  }

  public void run() {
    // get pokemon data
    // reference: 
    HttpRequest fetcher = new HttpRequest("https://pokeapi.co/api/v2/pokemon?limit=" + limit);
    String res = fetcher.getResponse();
 
    // print pokemon name
    String[] pokemonNames = res.split("\"name\":\"");
    for (int i = 1; i < pokemonNames.length; i++) {
      String pokemonName = pokemonNames[i].split("\"")[0];
      Logger.success(pokemonName); 
      System.out.println();
    }
  }
}
