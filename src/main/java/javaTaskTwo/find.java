package javaTaskTwo;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class find {
    private ArrayList<String> result = new ArrayList<String>();

    public ArrayList<String> getFile(boolean allDirectory, String way, String fileName) {
        Path path = Paths.get(way + "\\" + fileName);
        if (Files.exists(path))
            result.add(way + "\\" + fileName);
        if (allDirectory)
            ifAllDirTrue(way, fileName);
        return result;
    }

    private void ifAllDirTrue (String way, String fileName) {
        File forAllDirectory = new File(way);
        String[] arrayOfFiles = forAllDirectory.list();
        for (String elem : arrayOfFiles) {
            File forCheck = new File(way + "\\" + elem);
            if (forCheck.isDirectory()) {
                Path path = Paths.get(way + "\\" + elem + "\\" + fileName);
                if (Files.exists(path))
                    result.add(way + "\\" + elem + "\\" + fileName);
                ifAllDirTrue(way + "\\" + elem, fileName);
            }
        }
    }
}
