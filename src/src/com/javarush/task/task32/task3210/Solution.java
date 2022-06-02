package src.com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String filename = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(filename, "rw");
        raf.seek(number);
        byte[] buffer = new byte[text.length()];
        raf.read(buffer,0, text.length());

        String line = new String(buffer);
        //System.out.println(line);

        raf.seek(raf.length());
        if (line.equals(text)) {
            raf.write("true".getBytes());
        } else {
            raf.write("false".getBytes());
        }
        raf.close();
    }
}
