/*
ID: abhinav67
LANG: JAVA
TASK: palsquare
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class palsquare
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File("palsquare.in"));
        int base = scan.nextInt();
        scan.close();
        int last = Integer.valueOf(Integer.toString(300, base), base);
        System.out.println(last);
        PrintWriter pr = new PrintWriter(new File("palsquare.out"));
        for (int i = 1; i <= last; i++)
        {
            int square = i * i;
            if (checkPal(Integer.toString(square, base)))
                pr.println(Integer.toString(i, base).toUpperCase() + " "
                    + Integer.toString(square, base).toUpperCase());
        }
        pr.close();
    }

    private static boolean checkPal(String str)
    {
        String[] arr = str.split("");
        String reverse = "";
        for (int i = arr.length - 1; i >= 0; i--)
        {
            reverse += arr[i];
        }
        return str.equals(reverse);
    }
}
