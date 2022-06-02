package src.com.javarush.task.task34.task3411;

/* 
Ханойские башни
*/

public class Solution {
    public static void main(String[] args) {
        int numRings = 4;
        moveRing('A', 'B', 'C', numRings);
    }

    public static void moveRing(char a, char b, char c, int numRings) {
        char from = a;
        char to = b;
        char tmp = c;
        if (numRings > 1) {
            moveRing(from, tmp, to, numRings - 1);
            System.out.println("from " + from + " to " + to);
            moveRing(tmp, to, from, numRings - 1);
        } else {
            System.out.println("from " + from + " to " + to);
        }
    }
}