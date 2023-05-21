package poke;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "poke", mixinStandardHelpOptions = true, version = "1.0",
        description = "Prints a poke message")
public class App implements Runnable {

    @Parameters(paramLabel = "<message>", description = "The message to poke")
    private String message;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        if ("hello".equals(message)) {
            System.out.println("Hello, Poke");
        } else {
            System.out.println("Unknown command: " + message);
        }
    }
}
