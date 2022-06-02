package src.com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        try {
            File resultFile = new File(resultFileAbsolutePath);
            File dest = new File(resultFile.getParentFile() + "/allFilesContent.txt");
            if (FileUtils.isExist(dest)) {
                FileUtils.deleteFile(dest);
            }
            FileUtils.renameFile(resultFile, dest);

            OutputStream out = new FileOutputStream(dest);
            List<File> files = new ArrayList<>();
            for (File file : getFileList(new File(path), files)){
                InputStream is = new FileInputStream(file);
                while (is.available() > 0) {
                    out.write(is.read());
                }
                out.write('\n');
            };
            out.close();

        }catch (Exception e) {
        }
    }

    public static List<File> getFileList(File dir, List<File> files) {
        for (File file:dir.listFiles()) {
            if (file.isFile() && file.length() <= 50) {
                files.add(file);
            }
            if (file.isDirectory()) getFileList(file, files);
        }
        return files;
    }
}
