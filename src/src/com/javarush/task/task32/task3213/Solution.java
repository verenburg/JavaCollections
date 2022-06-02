package src.com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        /*StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(reader);
        int intSymbol;
        if (reader != null){
            while ((intSymbol = reader.read()) != -1) {
                char symbol = (char) (intSymbol + key);
                result.append(symbol);
            }

        }

        return result.toString();*/

        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(reader);
        String line = br.readLine();
        char[] chars = line.toCharArray();
        for (char c : chars) {
            result.append((char)(c + key));
        }
        return result.toString();
    }
}
