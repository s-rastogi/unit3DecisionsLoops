import java.util.Scanner; 

/**
 * Write a description of class SumAndAverage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SumAndAverage
{
    /** description of instance variable x (add comment for each instance variable) */
    private int x;
        public static double averageOfVAlues()
        {
            Scanner scan = new Scanner (System.in);
            double sum = 0;
            int count = 0;
            System.out.println( "Enter a series of double or a character to quit." );
           
            while( scan.hasNextDouble())
            {
                double input = scan.nextDouble();
                sum += input;
                count++;
            }
            double average = 0;
            if(count >0)
            {
                average = sum/count;
            }
            return average;
        
        }
}

