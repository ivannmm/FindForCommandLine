package javaTaskTwo;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindTest {

    @Test
    void getFile() {
        List<String> expected = new ArrayList<>();
        Find find = new Find();
        char separator = File.separatorChar;
        expected.add("." + separator + "src" + separator + "main" + separator + "resources" + separator + "text.txt");
        expected.add("." + separator + "src" + separator + "main" + separator + "resources" + separator + "forTests"
                + separator + "text.txt");
        expected.add("." + separator + "src" + separator + "main" + separator + "resources" + separator + "forTests"
                + separator + "qwerty" + separator + "text.txt");
        expected.add("." + separator + "src" + separator + "main" + separator + "resources" + separator + "forTests"
                + separator + "qwerty" + separator + "3" + separator + "text.txt");
        expected.add("." + separator + "src" + separator + "main" + separator + "resources" + separator + "forTests"
                + separator + "qwerty" + separator + "3" + separator + "1" + separator + "text.txt");
        assertEquals(expected, find.getFile(true, new File("." + separator + "src" + separator +
                "main" + separator + "resources"), "text.txt"));

        List<String> expectedTwo = new ArrayList<>();
        expectedTwo.add("." + separator + "src" + separator + "main" + separator + "resources" + separator + "text.txt");
        assertEquals(expectedTwo, find.getFile(false, new File("." + separator + "src" + separator +
                "main" + separator + "resources"), "text.txt"));
    }
}