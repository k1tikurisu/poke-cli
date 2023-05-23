package cli.commands.hello;

public class HelloCommand implements Runnable {
  @Override
  public void run() {
    System.out.println("Hello, Poke CLI!");
  }
}
