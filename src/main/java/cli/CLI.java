package cli;

import cli.commands.get.GetPokeNameList;
import cli.commands.status.GetPokeStatus;

import java.util.HashMap;
import java.util.Map;

import cli.commands.HelloCommand;

public class CLI implements Runnable {
  private String[] args;

  CLI(String[] args) {
    this.args = args;
  }

  @Override
  public void run() {
    try {
      // Parse the command line arguments
      Map < String, String > options = parseCommandLineOptions(args);

      // Check the command
      String command = options.get("command");
      if (command != null && command.equals("get")) {
        String limitStr = options.get("limit");

        if (limitStr != null) {
          int limit = Integer.parseInt(limitStr);
          new GetPokeNameList(limit).run();
        } else if (limitStr == null) {
          new GetPokeNameList(50).run();
        }
      } else if (command != null && command.equals("status")) {
        String name = options.get("name");
        if (name != null) {
          new GetPokeStatus(name).run();
        } else if (name == null) {
          System.out.println("Invalid options. Please specify --name.");
        }
      } else if (command != null && command.equals("hello")) {
        new HelloCommand().run();
      } else {
        System.out.println("Invalid command. Please use 'get' command.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private static Map < String, String > parseCommandLineOptions(String[] args) {
    Map < String, String > options = new HashMap < > ();
    String command = args[0];
    options.put("command", command);

    for (int i = 1; i < args.length; i++) {
      String option = args[i];
      String[] optionParts = option.split("=");
      if (optionParts.length == 2) {
        String key = optionParts[0].replace("--", "");
        String value = optionParts[1];
        options.put(key, value);
      }
    }

    return options;
  }
}