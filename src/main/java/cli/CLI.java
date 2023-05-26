package cli;

import cli.commands.get.GetPokeNameList;
import cli.commands.status.GetPokeStatus;
import cli.commands.hello.HelloCommand;

public class CLI implements Runnable {
  private String[] args;

  CLI(String[] args) {
    this.args = args;
  }

  @Override
  public void run() {
    try {
      // コマンドを格納(poke get なら get)
      String command = args[0];
      // オプション格納(poke get 10なら 10)
      String option = null;

      // オプションが存在する時だけ変数に入れる
      if (args.length == 2) {
        option = args[1];
      }

      // コマンドごとに処理を分岐
      if (option != null && command.equals("get")) {
        int limit = Integer.parseInt(option);
        new GetPokeNameList(limit).run();
      }
      
      if (option != null && command.equals("status")) {
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