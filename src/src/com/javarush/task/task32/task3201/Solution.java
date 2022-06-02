package src.com.javarush.task.task32.task3201;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {

        String filename = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(filename, "rw");
        if (raf.length() < number) {
            raf.seek(raf.length());
        } else {
            raf.seek(number);
        }
        raf.write(text.getBytes());

        raf.close();
    }


}
