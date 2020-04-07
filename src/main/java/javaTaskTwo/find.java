package javaTaskTwo;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class find {
    private List<String> result = new ArrayList<>();

    public List<String> getFile(boolean allDirectory, String way, String fileName) {
        Path path = Paths.get(way + File.separator + fileName);
        if (Files.exists(path))
            result.add(way + File.separator + fileName);
        if (allDirectory)
            ifAllDirTrue(way, fileName);
        return result;
    }

    private void ifAllDirTrue (String way, String fileName) {
        File forAllDirectory = new File(way);
        String[] arrayOfFiles = forAllDirectory.list();
        assert arrayOfFiles != null;
        for (String elem : arrayOfFiles) {
            File forCheck = new File(way + File.separator + elem);
            if (forCheck.isDirectory()) {
                Path path = Paths.get(way + File.separator + elem + File.separator + fileName);
                if (Files.exists(path))
                    result.add(way + File.separator + elem + File.separator + fileName);
                ifAllDirTrue(way + File.separator + elem, fileName);
            }
        }
    }
}
