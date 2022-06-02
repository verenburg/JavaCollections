package src.com.javarush.task.task31.task3103;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/* 
Своя реализация
*/

public class Solution {
    public static byte[] readBytes(String fileName) throws IOException {
        /*FileInputStream fis = new FileInputStream(fileName);
        byte[] result = new byte[fis.available()];
        fis.read(result);
        fis.close();
        return result;*/
        return Files.readAllBytes(Paths.get(fileName));
    }

    public static List<String> readLines(String fileName) throws IOException {
        /*List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                result.add(reader.readLine());
            }
            reader.close();
        }
        return result;*/
        return Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
    }

    public static void writeBytes(String fileName, byte[] bytes) throws IOException {
        /*FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(bytes);*/
        Files.write(Paths.get(fileName), bytes);
    }

    public static void copy(String resourceFileName, String destinationFileName) throws IOException {
        Files.copy(Paths.get(resourceFileName), Paths.get(destinationFileName));
    }
}
