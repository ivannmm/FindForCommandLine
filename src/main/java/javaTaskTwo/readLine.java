package javaTaskTwo;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class readLine {
    @Option(name = "-r")
    private boolean allDirectory;
    @Option(name = "-d")
    private String way;
    @Argument()
    private String filename;

    public static void main(String[] args) {
        new readLine().launch(args);
    }

    public void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.out.println(e.getMessage());
            parser.printUsage(System.out);
            return;
        }

        if (filename == null){
            System.out.println("Нe указано название файла");
            return;
        }

        try {
            find find = new find();
            System.out.println(find.getFile(allDirectory, way, filename));
        } catch (java.lang.NullPointerException e) {
            System.out.println("Не указан путь к файлу");
        }
    }
}
