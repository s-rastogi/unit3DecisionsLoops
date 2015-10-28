

/**
 * Write a description of class CountMatches here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CountMatches
{   
    public static int countSpaces ( String str)
    {
        int spaces = 0;
        
        for (     int i =0;
                  i<str.length();
                  i++ )
        {
            char ch = str.charAt( i ) ;
            if ( ch == ' ' )
            {
                spaces++;
            }
        }
        return spaces;
    }
}
