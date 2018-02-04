import java.io.*;
import java.util.*;

public class lostcow
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File("lostcow.in"));
        int x = scan.nextInt();
        int y = scan.nextInt();
        scan.close();
        int d = Math.abs(x - y);

        int loc = x;
        int loc2 = 0;
        int dist = 0;
        int chg = 1;
        int n = 1;

        while (true)
        {
            if (n % 2 != 0)
            {
                loc2 = x + chg;
                if (loc <= y && y <= loc2)
                {
                    dist += Math.abs(loc - y);
                    break;
                }
            }
            else
            {
                loc2 = x - chg;
                if (loc2 <= y && y <= loc)
                {
                    dist += Math.abs(loc - y);
                    break;
                }
            }
            dist += Math.abs(loc - loc2);
            loc = loc2;
            chg *= 2;
            n++;
        }

        PrintWriter pr = new PrintWriter(new File("lostcow.out"));
        pr.println(dist);
        pr.close();
    }
}
