package Challenge_Code;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Magicsquare {

	// Stores magic squares and returns them depending on index
   public static int[][] Squares(int k) {
        
        int[][] s0 = { {8, 1, 6},
                       {3, 5, 7}, 
                       {4, 9, 2},
               };
        int[][] s1 = { {6, 1, 8},
                       {7, 5, 3}, 
                       {2, 9, 4},
               };
        int[][] s2 = { {4, 9, 2},
                        {3, 5, 7}, 
                        {8, 1, 6},
               };
        int[][] s3 = { {2, 9, 4},
                        {7, 5, 3}, 
                        {6, 1, 8},
               };
        int[][] s4 = { {8, 3, 4},
                       {1, 5, 9}, 
                       {6, 7, 2},
               };
        int[][] s5 = { {4, 3, 8},
                        {9, 5, 1}, 
                        {2, 7, 6},
               };
        int[][] s6 = { {6, 7, 2},
                       {1, 5, 9}, 
                       {8, 3, 4},
               };
        int[][] s7 = { {2, 7, 6},
                        {9, 5, 1}, 
                        {4, 3, 8},
               };
               
        if (k == 0) {
            return(s0);

        } else if (k == 1) {
            return(s1);

        } else if (k == 2) {
            return(s2);

        } else if (k == 3) {
            return(s3);

        }  else if (k == 4) {   
            return(s4);

        } else if (k == 5) {
            return(s5);

        } else if (k == 6) {
            return(s6);

        } else {
            return(s7);
        }
    }
   
     // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {

        int[][] placeholder = new int[3][3];										// Holds value for the eight matrix's in the square method above
        int tempmin = 0; 															// Temporary minimum 
        int mincost = 0; 															// Final minimum returned 
        int var = 0; 																// Stores value of calculation for the converting the magic square

            for (int i = 0; i < 8; i++) { 											// Loops through the 8 matrix's  

                tempmin = 0;
                placeholder = Squares(i);											// Places value of a magic square into placeholder

                for (int j = 0; j < 3; j++) {										// Loops through the columns  

                    for (int k = 0; k < 3; k++) {									// Loops through the rows

                        if (s[j][k] != placeholder[j][k]) {							// When the index of matrix s is not equal to the matrix currently being referenced 
                            
                            var = Math.abs(placeholder[j][k] - s[j][k]); 			// Calculate cost of the operation 
                            tempmin = tempmin + var;								// Adding each value that has to be switched 
                        }
                    }
                }
                    if (i == 0) {													// If else places the min cost of a matrix's with the least swaps 
                        mincost = tempmin;

                    } else if (tempmin < mincost) {
                        mincost = tempmin;
                    }
            }

            return (mincost);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
