package javaTaskTwo;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Find {
    public List<String> getFile(boolean allDirectory, String way, String fileName) {
        List<String> result = new ArrayList<>();
        File forAllDirectory = new File(way);
        String[] arrayOfFiles = forAllDirectory.list();
        assert arrayOfFiles != null;
        if (Files.exists(Paths.get(way + File.separator + fileName))) {
            result.add(way + File.separator + fileName);
        }
        if (allDirectory)
            for (String elem : arrayOfFiles) {
                File forCheck = new File(way + File.separator + elem);
                if (forCheck.isDirectory()) {
                result.addAll(getFile(true, way + File.separator + elem, fileName));
            }
        }
        return result;
    }
}
