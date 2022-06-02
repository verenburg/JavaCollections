package src.com.javarush.task.task31.task3106;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) {
        String resultFileName = args[0];
        List<Path> fileNames = new ArrayList<>();

        for (int i = 1; i < args.length; i++) {
            fileNames.add(Paths.get(args[i]));
        }





    }
}
