import java.io.*;
import java.util.*;

public class cownomics
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File("cownomics.in"));
        int n = scan.nextInt();
        int m = scan.nextInt();
        scan.nextLine();
        String[][] spot = new String[n][m];
        String[][] plain = new String[n][m];
        for (int r = 0; r < n; r++)
        {
            String line = scan.nextLine();
            for (int c = 0; c < m; c++)
            {
                spot[r][c] = line.substring(c, c + 1);
            }
        }
        for (int row = 0; row < n; row++)
        {
            String line = scan.nextLine();
            for (int col = 0; col < m; col++)
            {
                plain[row][col] = line.substring(col, col + 1);
            }
        }
        System.out.println(Arrays.deepToString(spot));
        System.out.println(Arrays.deepToString(plain));
        scan.close();

        int count = 0;
        for (int i = 0; i < m; i++)
        {
            Set<String> set = new TreeSet<>();
            for (int j = 0; j < n; j++)
            {
                set.add(spot[j][i]);
            }
            for (int k = 0; k < n; k++)
            {
                if (set.contains(plain[k][i]))
                    break;
                if (k == n - 1)
                    count++;
            }
        }

        PrintWriter pr = new PrintWriter(new File("cownomics.out"));
        pr.println(count);
        pr.close();
    }
}
