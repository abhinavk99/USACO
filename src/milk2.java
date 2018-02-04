/*
ID: abhinav67
LANG: JAVA
TASK: milk2
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class milk2
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File("milk2.in"));
        int lines = scan.nextInt();
        int[] starts = new int[lines];
        int[] ends = new int[lines];
        for (int i = 0; i < lines; i++)
        {
            starts[i] = scan.nextInt();
            ends[i] = scan.nextInt();
        }
        //int[] starts = {100, 64100, 128100};
        //int[] ends = {102, 64102, 128102};
        System.out.println(Arrays.toString(starts));
        System.out.println(Arrays.toString(ends));
        scan.close();
        PrintWriter pr = new PrintWriter("milk2.out");
        boolean[] time = new boolean[1000000];
        for (int k = 0; k < lines; k++)
        {
            for (int l = starts[k]; l < ends[k]; l++)
            {
                time[l] = true;
            }
        }
        Arrays.sort(starts);
        int milked, noMilked;
        milked = noMilked = 0;
        for (int j = starts[0]; j <= starts[lines - 1]; j++)
        {
            int m = j;
            while (time[m] == time[j])
                m++;
            if (time[j]) milked = Math.max(milked, m - j);
            else noMilked = Math.max(noMilked, m - j);
            j = m - 1;
        }
        pr.println(milked + " " + noMilked);
        pr.close();
    }
}
