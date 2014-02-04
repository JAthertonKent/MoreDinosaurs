package dinosaurs.io;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Console {

    private Scanner in;
    private PrintStream out;

    public Console(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public void print(String output) {
        out.println(output);
    }

    public int ask() {
        return in.nextInt();
    }

    public String prompt(String s) {
        out.println(s);
        return in.nextLine();
    }
}
