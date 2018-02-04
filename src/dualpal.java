/*
ID: abhinav67
LANG: JAVA
TASK: dualpal
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class dualpal
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File("dualpal.in"));
        int n = scan.nextInt();
        int s = scan.nextInt();
        scan.close();
        PrintWriter writer = new PrintWriter(new File("dualpal.out"));
        int i = s + 1;
        int count = 0;
        while (count < n)
        {
            int num = 0;
            for (int j = 2; j <= 10; j++)
            {
                if (checkPal(Integer.toString(i, j))) num++;
                if (num == 2) break;
            }
            if (num == 2)
            {
                writer.println(i);
                count++;
            }
            i++;
        }
        writer.close();
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

