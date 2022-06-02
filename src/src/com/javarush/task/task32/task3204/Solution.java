package src.com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        int core;
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            core = (byte) (Math.random() * 9 + 48);
            list.add((byte) core);
            core = (byte) (Math.random() * 25 + 65);
            list.add((byte) core);
            core = (byte) (Math.random() * 25 + 97);
            list.add((byte) core);
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] password = new byte[8];
        int i = 0;
        for (byte b : list){
            if (i == 8) break;
            password[i] = b;
            i++;

        }
        try {
            byteArrayOutputStream.write(password);
        } catch (IOException e) {
        }
        return byteArrayOutputStream;
    }
}
