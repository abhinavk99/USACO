import java.io.*;
import java.util.*;
import java.awt.geom.Rectangle2D;

public class square
{

    public static void main(String[] args) throws IOException
    {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(new File("square.in"));
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();
        Rectangle2D.Double r1 = new Rectangle2D.Double(x1, y1, x2 - x1, y2 - y1);
        //System.out.println(r1);
        
        int x21 = scan.nextInt();
        int y21 = scan.nextInt();
        int x22 = scan.nextInt();
        int y22 = scan.nextInt();
        Rectangle2D.Double r2 = new Rectangle2D.Double(x21, y21, x22 - x21, y22 - y21);
        //System.out.println(r2);
        
        int xLowest = Math.min(x1, x21);
        int yLowest = Math.min(y1, y21);
        
        int xHighest = Math.max(x2, x22);
        int yHighest = Math.max(y2, y22);
        
        int rWidth = xHighest - xLowest;
        int rHeight = yHighest - yLowest;
        
        int sq = Math.max(rWidth, rHeight);
        //System.out.println(sq * sq);
        PrintWriter pr = new PrintWriter(new File("square.out"));
        pr.print(sq * sq);
        scan.close();
        pr.close();
    }

}
