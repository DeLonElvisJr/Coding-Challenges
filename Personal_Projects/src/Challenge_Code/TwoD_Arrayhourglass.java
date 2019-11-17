package Challenge_Code;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TwoD_Arrayhourglass {

	  // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int sum = 0;
        int size = 0;

        for (int i = 1; i < 5; i++) { 								// Rows 1 and 6 cannot contain an hourglass

            for (int j = 1; j < 5; j++) { 							// Columns 1 and 6 cannot have an hourglass

                size = arr[i][j] + arr[i-1][j] + 					// Adds the hourglass based on position	Ex:	a b c
                      arr[i+1][j] + arr[i-1][j-1] + 				//											  d
                      arr[i-1][j+1] + arr[i+1][j-1] +				//											e f g
                      arr[i+1][j+1];  

                if (i == 1 && j == 1) {								// Assigns the first hourglass as the largest, after if another hourglass is larger it will assign the size of the larger one to sum 
                    sum = size;

                } else if (size > sum) {
                    sum = size;
                }
            }
        }
        return(sum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
