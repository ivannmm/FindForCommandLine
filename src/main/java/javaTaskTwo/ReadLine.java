package javaTaskTwo;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;

public class ReadLine {
    @Option(name = "-r")
    private boolean allDirectory;
    @Option(name = "-d", required = true)
    private File file;
    @Argument(required = true)
    private String filename;

    public static void main(String[] args) {
        new ReadLine().launch(args);
    }

    public void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.out.println(e.getMessage());
            System.out.println("java -jar find.jar [-r] [-d directory] filename.txt");
            parser.printUsage(System.out);
            return;
        }

        System.out.println(Find.getFile(allDirectory, file, filename));
    }
}
