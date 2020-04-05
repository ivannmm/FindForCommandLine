package javaTaskTwo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class findTest {

    @Test
    void getFile() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("C:\\Games\\Frostpunk");
    }
}