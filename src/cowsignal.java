import java.io.*;
import java.util.*;

public class cowsignal
{

    public static void main(String[] args) throws IOException
    {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(new File("cowsignal.in"));
        int m = scan.nextInt();
        int n = scan.nextInt();
        int k = scan.nextInt();
        scan.nextLine();
        String[][] arr = new String[m][n];
        for (int r1 = 0; r1 < m; r1++)
        {
            String line = scan.nextLine();
            for (int c1 = 0; c1 < n; c1++)
            {
                arr[r1][c1] = line.substring(c1, c1 + 1);
            }
        }
        scan.close();
        String[][] arr2 = new String[m * k][n * k];
        for (int r = 0; r < m; r++)
        {
            for (int c = 0; c < n; c++)
            {
                String s = arr[r][c];
                int rFin = r * k + k;
                int cFin = c * k + k;
                for (int row = r * k; row < rFin; row++)
                {
                    for (int col = c * k ; col < cFin; col++)
                    {
                        arr2[row][col] = s;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(arr2));
        PrintWriter pr = new PrintWriter(new File("cowsignal.out"));
        for (int r2 = 0; r2 < m * k; r2++)
        {
            for (int c2 = 0; c2 < n * k; c2++)
            {
                pr.print(arr2[r2][c2]);
            }
            pr.print("\n");
        }
        pr.close();
    }

}
