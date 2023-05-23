package cli;

import cli.commands.get.GetPokeNameList;
import cli.commands.status.GetPokeStatus;

import cli.commands.HelloCommand;

public class CLI implements Runnable {
  private String[] args;

  CLI(String[] args) {
    this.args = args;
  }

  @Override
  public void run() {
    try {
      // Check the command
      String command = args[0];
      String option = args[1];

      if (command.equals("get")) {
        int limit = Integer.parseInt(option);
        new GetPokeNameList(limit).run();
      }
      
      if (command.equals("status")) {
        String name = option;
        new GetPokeStatus(name).run();
      }
      
      if (command.equals("hello")) {
        new HelloCommand().run();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}