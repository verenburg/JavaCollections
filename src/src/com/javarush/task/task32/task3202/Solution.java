package src.com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        
        StringWriter result = new StringWriter();
        if (is != null) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            while (is.available() > 0) {
                result.write(reader.readLine());
            }
           
        }

        return result;
    }
}
