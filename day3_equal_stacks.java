import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        int sum1=0, sum2=0, sum3=0;
        int end = Math.max(Math.max(h1.length, h2.length), h3.length);
        for(int i=0; i<end; i++) {
            if(i<h1.length) {
                sum1 += h1[i];
            }
            if(i<h2.length) {
                sum2 += h2[i];
            }
            if(i<h3.length) {
                sum3 += h3[i];
            }
        }
        boolean flag = true;
        int min = 0;
        int i=0,j=0,k=0;
        while(flag) {
            min = Math.min(Math.min(sum1, sum2), sum3);
            if(sum1 == min && sum2 == min && sum3 == min) {
                flag = false;
                break;
            } else {
                if(sum1 > min) {
                    sum1 -= h1[i++];
                }
                if(sum2 > min) {
                    sum2 -= h2[j++];
                }
                if(sum3 > min) {
                    sum3 -= h3[k++];
                }
            }
        }
        return sum1;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
