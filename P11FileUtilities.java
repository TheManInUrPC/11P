import javax.swing.*;
import java.io.*;


/** 
 * FileUtilities.java.
 * 
 * implements String getFileName()
 * @author cs415
 */


public  class P11FileUtilities 
{
    //-------------------- class variables -----------------------
    private static JFileChooser chooser = null;
    
    
    
    //---------------------- String getFileName() --------------------------
    /**
     * Use a JFileChooser dialog to get a valid file name from a user.
     *   Will not return the name unless the file exists.
     * Returns null if no valid file selected.
     * @return String
     */
    public static String getFileName()
    {
        String fileName = null;
        
        if ( chooser == null )
        {
            chooser = new JFileChooser();
            chooser.setCurrentDirectory( new File( "." ) );
        }
        
        
        int returnVal = chooser.showOpenDialog( null );
        while ( fileName == null && returnVal != JFileChooser.CANCEL_OPTION ) 
        {
            if ( returnVal == JFileChooser.APPROVE_OPTION )
            {
                File f = chooser.getSelectedFile();
                if ( f.isFile() )
                    fileName = f.getPath();
            }
        }
        return fileName;
    }
    
}