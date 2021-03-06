import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;
import javax.swing.*;
import java.io.*;


/**
 * DNASequence - a class to represent a DNA sequence from a FASTA format
 * file. It includes header and sequence information.
 * 
 * @author rdb
 * 
 */
public class DNASequence
{
    //----------------------- Instance variables ---------------------------
    private String        dnaString;
    private String        seqId;
    private String        seqHeader, header1, dna1;
    private int           seqLineLen = 50;
    private int           endSeq;
    private String        toString1;
    private DNASequenceException exception1, exception2, exception3, exception4, exception5;
    //------------------------- DNASequence( String ) -------------------------
    /**
     * Constructor takes the sequence header and the DNA sequence as Strings.
     * 
     * @param header String
     * @param  dna  String
     * 
     */
    public DNASequence( String header, String dna ) throws DNASequenceException
    {  
        dnaString = dna;
        
        endSeq = header.indexOf(" ");
        
        seqId = header.substring( 1 , endSeq );
        
        seqHeader = header.substring( endSeq );
        
        
        
    }
    
    
    //----------------------------- getDNASequence ---------------------------
    /**
     * return the full dna sequence data as a String.
     * 
     * @return String
     */
    public String getDNASequence()
    {
        return this.dnaString;
    }
    //----------------------------- getHeader() -----------------------------
    /**
     * return the full dna sequence data as a String.
     * 
     * @return String
     */
    public String getHeader()
    {
        return this.seqHeader;
    }
    //----------------------------- getId -------------------------------
    /**
     * return the identifying "name" of the sequence.
     * 
     * @return String
     */
    public String getId()
    {
        return this.seqId;
    }
    
    //--------------------------- indexOf( String, int ) --------------------
    /**
     * find the next occurrence the search string in the sequence and
     * return its position. Return -1 if not found. This is a a case
     * sensitive search.
     * 
     * @param search String
     * @param start int
     * 
     * @return int
     */
    public int indexOf( String search, int start )
    {
        if( dnaString.indexOf( search, start ) != -1 )
        {
            
            return dnaString.indexOf(search, start );
        }
        else
        {
            return -1;
        }
    }   
    
    //-------------------------------- toString() -----------------------------
    /**
     * Returns a single string that reproduces an approximation to the input 
     * format for the sequence. In other words, the returned string must start 
     * with a header line that looks like the original header in the input file 
     * and includes the line feed character (\n). 
     * 
     * The header information is followed (in the same String object being 
     * returned) by the sequence data that is broken up into sections that will 
     * print nicely. In other words, you should copy the sequence data to the 
     * output string in groups of 50 characters followed by a line feed. 
     * The line 
     * length should be an instance variable so that it can be easily changed.
     * 
     * 
     * @return String
     */
    public String toString()
    {
        toString1 = new String();
        
        for( int i = 1; i < dnaString.length(); i++ )
        {
            toString1 += dnaString.substring( i-1, i );
            
            if( i % seqLineLen == 0 )
            {
                toString1 += " \n ";
            }
        }
        
        return seqHeader + "\n " + toString1;
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
        String dna = "ACXGAACCCTGACXGACGTACXGAACCCTGACXGACGTACXGAACCCTGACXGACGT"
            + "ACXGAACCCTGACXGACGTACXGAACCCTGACXGACGTACXGAACCCTGACXGACGT"
            + "ACXGAACCCTGACXGACGTACXGAACCCTGACXGACGTACXGAACCCTGACXGACGT"
            + "ACXGAACCCTGACXGACGTACXGAACCCTGACXGACGTACXGAACCCTGACXGACGT"
            + "ACXGAACCCTGACXGACGTACXGAACCCTGACXGACGTACXGAACCCTGACXGACGT";
        
        String header = ">testId other stuff of unknown format";
        
        DNASequence s = new DNASequence( header, dna );
        
        System.out.println( "Sequence: \n" + s );
        
        //---------------------- add more test code!!!! -----------------------
        // add tests indexOf.
        
        System.out.println( s.indexOf( "CCC", 0 ) );
    }
}
