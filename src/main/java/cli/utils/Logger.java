package cli.utils;

public class Logger {
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_RESET = "\u001B[0m";

  public static void error(String msg) {
    System.err.print(ANSI_RED + msg + ANSI_RESET);
  }

  public static void success(String msg) {
    System.out.print(ANSI_GREEN + msg + ANSI_RESET);
  }

  public static void log(String msg) {
    System.out.print(msg);
  }

  public static void attention(String msg) {
    System.out.print(ANSI_YELLOW + msg + ANSI_RESET);
  }
}
