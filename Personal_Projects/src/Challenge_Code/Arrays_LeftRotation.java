package Challenge_Code;

import java.io.*;
import java.util.*;


public class Arrays_LeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {

        int temp = 0; 
        
        for (int j = 0; j < d; j++) {							//Number of left rotations d
            for (int i = a.length -1; i >= 0; i--) {			//Rotation of matrix a

                if (i == a.length - 1) {						//If the loop is currently at index a[n] the max index
                    temp = a[i-1]; 
                    a[i-1] = a[i]; 

                } else if (i == 0) {							//If the loop is at the last element n - (n-1)
                	a[a.length - 1] = temp;

                } else {										//All other cases between the two other statements 
                    a[a.length - 1] = temp;
                    temp = a[i-1]; 
                    a[i-1] = a[a.length - 1];
                }
            }
        }
        
        return(a); 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}