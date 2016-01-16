package genericCheckpointing.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileProcessor{
	BufferedReader in;
	String fileName = "";
/**
 * FileProcessor : Takes the filename and initializes the file handle
 * Return Type: 
 */
	public FileProcessor( String fileNameIn){
//		Logger.write(4, "FileProcessor's constructor is called");
		this.fileName = fileNameIn;
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
		//	ioe.printStackTrace();
			System.out.println("File not found with name : " + fileName + "  |  IOException");
			System.exit(1);
		}

		return line;
	}

	public void openFile(){
		try{
			in = new BufferedReader( new FileReader( fileName ));
		}catch( FileNotFoundException fex){
			//fex.printStackTrace();
			System.out.println("File not found with name : " + fileName + " |  IOException");
			System.exit(1);
		}
	}

	public void closeFile(){
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

/**                        
* toString : 
* Return Type : String
*/                  
	public String toString(){
		return  "FileProcessor  " ;
	}    
}
