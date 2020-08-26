import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    static int solve(int a, int b, int x) {
        if(a==0) return 0;
        BigInteger aa = new BigInteger(""+a);
        BigInteger bb = new BigInteger(""+b);
        BigInteger xx = new BigInteger(""+x);
 
 
        
      return aa.modPow(bb, xx).intValue();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] abx = scanner.nextLine().split(" ");

            int a = Integer.parseInt(abx[0]);

            int b = Integer.parseInt(abx[1]);

            int x = Integer.parseInt(abx[2]);

            int result = solve(a, b, x);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
