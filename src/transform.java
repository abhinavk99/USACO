/*
ID: abhinav67
LANG: JAVA
TASK: transform
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class transform
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File("transform.in"));
        // Scans in square length
        int n = scan.nextInt();
        scan.nextLine();
        // Scans in the before transformation square
        String[][] original = readBoard(scan, n);
        // Scans in the after transformation square
        String[][] modified = readBoard(scan, n);
        scan.close();
        System.out.println(Arrays.deepToString(original));
        System.out.println(Arrays.deepToString(modified));
        PrintWriter pr = new PrintWriter("transform.out");
        // Checks if the given after transformation square is equal to each of the
        // possible squares after the possible transformations are done to the
        // before transformation square
        if (compareArrays(modified, ninetyDeg(original))) pr.println(1);
        else if (compareArrays(modified, oneEightyDeg(original))) pr.println(2);
        else if (compareArrays(modified, twoSeventyDeg(original))) pr.println(3);
        else if (compareArrays(modified, reflect(original))) pr.println(4);
        else if (compareArrays(modified, combine1(original))) pr.println(5);
        else if (compareArrays(modified, combine2(original))) pr.println(5);
        else if (compareArrays(modified, combine3(original))) pr.println(5);
        else if (compareArrays(original, modified)) pr.println(6);
        else pr.println(7);
        pr.close();
    }

    // Reads in the square into a 2D array
    private static String[][] readBoard(Scanner scan, int n)
    {
        String[][] array = new String[n][n];
        for (int r = 0; r < n; r++)
        {
            String line = scan.nextLine();
            for (int c = 0; c < n; c++)
            {
                array[r][c] = line.substring(c, c + 1);
            }
        }
        return array;
    }

    // Returns a new array that is 90 degrees clockwise of the given array
    private static String[][] ninetyDeg(String[][] arr)
    {
        String[][] array = new String[arr.length][arr.length];
        int r, c;
        r = c = 0;
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = arr.length - 1; j >= 0; j--)
            {
                array[r][c] = arr[j][i];
                c++;
            }
            r++;
            c = 0;
        }
        return array;
    }

    // Returns a new array that is 180 degrees clockwise of the given array
    private static String[][] oneEightyDeg(String[][] arr)
    {
        String[][] array = new String[arr.length][arr.length];
        int r, c;
        r = c = 0;
        for (int i = arr.length - 1; i >= 0; i--)
        {
            for (int j = arr.length - 1; j >= 0; j--)
            {
                array[r][c] = arr[i][j];
                c++;
            }
            r++;
            c = 0;
        }
        return array;
    }

    // Returns a new array that is 270 degrees clockwise of the given array
    private static String[][] twoSeventyDeg(String[][] arr)
    {
        String[][] array = new String[arr.length][arr.length];
        int r, c;
        r = c = 0;
        for (int i = arr.length - 1; i >= 0; i--)
        {
            for (int j = 0; j < arr.length; j++)
            {
                array[r][c] = arr[j][i];
                c++;
            }
            r++;
            c = 0;
        }
        return array;
    }

    // Returns a new array that is a horizontal reflection of the given array
    private static String[][] reflect(String[][] arr)
    {
        String[][] array = new String[arr.length][arr.length];
        String[][] temp = twoSeventyDeg(arr);
        int r1 = 0;
        for (int r = temp.length - 1; r >= 0; r--)
        {
            array[r1] = temp[r];
            r1++;
        }
        return ninetyDeg(array);
    }

    // Returns a new array that is 90 degrees clockwise of the given array's reflection
    private static String[][] combine1(String[][] arr)
    {
        return ninetyDeg(reflect(arr));
    }

    // Returns a new array that is 180 degrees clockwise of the given array's reflection
    private static String[][] combine2(String[][] arr)
    {
        return oneEightyDeg(reflect(arr));
    }

    // Returns a new array that is 270 degrees clockwise of the given array's reflection
    private static String[][] combine3(String[][] arr)
    {
        return twoSeventyDeg(reflect(arr));
    }

    // Returns true if the two arrays are the same, otherwise false
    private static boolean compareArrays(String[][] original, String[][] modified)
    {
        for (int r = 0; r < original.length; r++)
        {
            for (int c = 0; c < original.length; c++)
            {
                if (!original[r][c].equals(modified[r][c]))
                    return false;
            }
        }
        return true;
    }
}
