package src.com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Что внутри папки?
*/

public class Solution {

    public static int dirCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dir = reader.readLine();
        
        File directory = new File(dir);

        if (directory.isDirectory()) {
            dirCount++;
            List<File> dirContent = dirInformation(directory);
            int filesCount = dirContent.size();
            long sizeOfDir = 0;
            for (File file : dirContent) {
                sizeOfDir += file.length();
            }
            
            System.out.println("Параметры папки " + directory.toString() + ":");
            System.out.println("Всего папок - " + dirCount);
            System.out.println("Всего файлов - " + filesCount);
            System.out.println("Общий размер - " + sizeOfDir);
        } else {
            System.out.println( dir  + "не папка");
        }


    }

    public static List<File> dirInformation(File dir){
        List<File> result = new ArrayList<>();

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                dirCount++;
                result.addAll(dirInformation(file));
            } else {
                result.add(file);
            }
        }
        return result;
    }
}
