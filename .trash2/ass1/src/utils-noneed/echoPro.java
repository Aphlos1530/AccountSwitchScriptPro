package utils;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class echoPro {

    private static void test1(String str) throws IOException {
        Terminal terminal = TerminalBuilder.builder()
                .system(true)
                .build();

        terminal.writer().printf(str);
    }

    public static void main(String[] args) throws IOException {
        test1("hello world");
    }

}
