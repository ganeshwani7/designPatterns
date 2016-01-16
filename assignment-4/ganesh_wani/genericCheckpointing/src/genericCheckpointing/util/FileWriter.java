package genericCheckpointing.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by ganeshwani on 11/27/14.
 */
public class FileWriter {
    String fileName = "";
    PrintWriter writer = null;

    /**
     *
     * @param fileName
     */
    public FileWriter( String fileName){
        this.fileName = fileName;
        writer = null;
    }

    /**
     * Open a file in write mode
     */
    public void openFile(){
        try {
//            writer = new PrintWriter(new BufferedWriter( new java.io.FileWriter( fileName, true)));
            writer = new PrintWriter(fileName);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("File not found with name : " + fileName + " | IOException");
            System.exit(1);
        }
    }

    /**
     * Close a file which was opened in write mode
     */
    public void closeFile(){
        writer.close();
    }

    /**
     * Write line in a file
     * @param line
     */
    public void writeResults( String line){
        writer.print( line);
    }

}
