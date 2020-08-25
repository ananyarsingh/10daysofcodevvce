import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the sillyGame function below.
     */
    static String sillyGame(int n) {
        /*
         * Write your code here.
         */
         boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime , true);
        int count = 0;
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i*i <= n; i++)
        {
            for(int j = 2*i; j <= n; j += i)
            {
                isPrime[j] = false;
            }
        }
        for(int i = 0; i <= n; i++)
        {
            if(isPrime[i])
            {
                count++;
            }
        }
        if(count % 2 == 0)
        {
            return "Bob";
        }
        else
        {
            return "Alice";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            String result = sillyGame(n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
