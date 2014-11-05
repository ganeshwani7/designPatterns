package studentRecordsBackup.util;

import studentRecordsBackup.util.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileProcessor{
	BufferedReader in;

/**
 * FileProcessor : Takes the filename and initializes the file handle
 * Return Type: 
 */
	public FileProcessor( String fileName){
//		Logger.write(4, "FileProcessor's constructor is called");
		try{
			in = new BufferedReader( new FileReader( fileName ));
		}catch( FileNotFoundException fex){
			fex.printStackTrace();
		}
	}

/**
 * readLineFromFile : Reads the file until end of the file is reached
 * Return Type: String
 */
	public String readLineFromFile( ){
		String line = null;//= in.readLine();
//		if( line !=null)
		try{
			line = in.readLine();
		}catch( IOException ioe){
			ioe.printStackTrace();
		}

		return line;
	}

/**                        
* toString : 
* Return Type : String
*/                  
	public String toString(){
		return  "FileProcessor  " ;
	}    
}
