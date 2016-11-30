import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;
import javax.swing.*;
import java.io.*;

/**
 * FastaApp.
 * 
 * 
 * @author Darien A. Blow rdb
 * 
 */
public class FastaApp
{
    //----------------------- Instance variables ---------------------------
    private String header = "";
    private String dnaString, seqId, dnaSequence;
    private String input, input1, input2, input3, input4;
    private Scanner fileInput;
    private DNASequence sequence;
    private Vector <DNASequence> dnaSeqVect;
    private boolean active = true;
    private static JFileChooser chooser = null;
    
    //------------------------- FastaApp( String ) -------------------------
    /**
     * Constructor.
     * 
     *
     * 
     * 
     */
    public FastaApp( )
    {  
        dnaSeqVect = new Vector <DNASequence>();
     
        fileInput = getFileScanner();
        
        generateSequence( fileInput );
        
        
        for( int i = 0; i < dnaSeqVect.size(); i++ )
        {
            System.out.println( dnaSeqVect.get( i ) );
        }
        
        run();
    }
     
  public void generateSequence(Scanner s)
  {

    header = s.nextLine();
    dnaString = s.nextLine();
    

    while(s.hasNextLine())
    {
     
      String line = s.nextLine();
      

      if( line.contains( " > " ) )
      {
          
          
        dnaString = " ";
        sequence = new DNASequence( header, dnaString );
        
        header = line;
        dnaSeqVect.add( sequence );
      }
      else
      {

        dnaString += line;
      }
    }

    sequence = new DNASequence( header , dnaString );

    dnaSeqVect.add( sequence );
  }
    //----------------------run() method------------------------
    public void run()
    {
        while( active == true )
        {
            String a = JOptionPane.showInputDialog( null, input1 );
            
            if( a == null )
            {
                active = false;
                break;
            }
            
            String[] input1 = a.split(" ");
            
            if( input1[ 0 ].equalsIgnoreCase( "display" ) )
            {
                for( int i = 0; i <dnaSeqVect.size(); i++ )
                {

                    if( dnaSeqVect.get( i ).getId().equals( input1[ 1 ] ) )
                    {
                        System.out.println( "Searching " );
                        input2 = dnaSeqVect.get( i ).getDNASequence();
                        input2.toString();
                        
                    }
                }
                
                JOptionPane.showMessageDialog( null, input2 );
                break;
                
            }
            
            if( input1[ 0 ].equalsIgnoreCase( "search" ) )
            {
                for( int i = 0; i < dnaSeqVect.size(); i++ )
                {
                     input3 = "Found: " + "\n" + dnaSeqVect.get( i ).getId()
                            + " at " + dnaSeqVect.get(i).indexOf(input1[ 1 ], 0) + "\n";  
                     
                    if( dnaSeqVect.get( i ).getId().equals( input1[ 1 ] ) )
                    {
                        
                        input3 = "Found: " + "\n" + dnaSeqVect.get( i ).getId()
                            + " at " + dnaSeqVect.get(i).indexOf(input1[ 1 ], 0) + "\n";  
                        
                        System.out.println( "Searching " );
                        
                    }
                    
                }    
                
                input = "Enter commands here";
                JOptionPane.showMessageDialog( null, input3 );
                
            }
            
            
            
        }
    }   
    //---------------------- Scanner getFileScanner() ------------------
    /**
     * Use a JFileChooser dialog to get a valid file name from a user.
     *   Will not return the name unless the file exists.
     * Returns null if no valid file selected.
     * 
     * @return Scanner
     */
     public static Scanner getFileScanner( )
    {
        String fileName = null;
        Scanner reader;
        
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
        try
        {
            reader = new Scanner( new FileInputStream( fileName ) );
        }
        catch( IOException e )
        {
            System.err.println( e.getMessage() );
            return null;
        }
        return reader;
    }  
   
        
        
    
    

    
    
    // Think about defining useful utility methods that will simplify the code 
    // in the public methods.
    
    
    
    //-------------------------- main ----------------------------------------
    /**
     * Simple test main.
     * 
     * @param  args String
     */
    
    public static void main( String[] args )
    {
        new FastaApp();
    }
}
