package cli.commands.hello;

import cli.utils.Logger;

public class HelloCommand implements Runnable {
  @Override
  public void run() {
    Logger.success("Hello, Poke CLI!");
    System.out.println();
  }
}
