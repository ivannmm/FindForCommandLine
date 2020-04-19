package javaTaskTwo;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Find {
    public static List<String> getFile(boolean allDirectory, File file, String fileName) {
        List<String> result = new ArrayList<>();
        String[] arrayOfFiles = file.list();
        if (arrayOfFiles != null)
            if (Files.exists(Paths.get(file.getPath(), fileName))) {
            result.add(file.getPath() + File.separator + fileName);
            }
        if (allDirectory)
            for (String elem : arrayOfFiles) {
                File forCheck = new File(file.getPath(), elem);
                if (forCheck.isDirectory()) {
                result.addAll(getFile(true, new File(file.getPath(), elem), fileName));
            }
        }
        return result;
    }
}
