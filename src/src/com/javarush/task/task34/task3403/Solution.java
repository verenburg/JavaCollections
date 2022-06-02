package src.com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {

    /*public void recurse(int n) {
        if (n <= 1) return;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                recurse(n / i);
                break;
            }
        }
    }*/
    public void recurse(int n) {
        if (n <= 1) return;
       int remainder = n;
       int result = nextSimpleNumber(1);
       while (remainder % result != 0) {
           result = nextSimpleNumber(result);
       }
       System.out.print(result + " ");
       remainder /= result;
       if (remainder == 1)
           return;
       else
           recurse(remainder);
    }

    public static int nextSimpleNumber(int n) {
        int result = n+1;
        boolean isSimple;
        while (true) {
            isSimple = true;
            for (int i = 2; i < result; i++) {
                if (result % i == 0)
                    isSimple = false;
            }
            if (isSimple)
                return result;
            else
                result++;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.recurse(18888);
    }
}
