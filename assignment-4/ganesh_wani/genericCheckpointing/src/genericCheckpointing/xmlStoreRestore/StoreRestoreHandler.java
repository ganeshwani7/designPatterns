package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.*;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ganeshwani on 12/13/14.
 */
public class StoreRestoreHandler implements InvocationHandler{
    String fileName;
    FileProcessor fileProcessor = null;
    FileWriter fileWriter = null;

    /**
     * @param fileNameIn
     * Constructor
     */
    public StoreRestoreHandler(String fileNameIn){
        this.fileName = fileNameIn;
        fileProcessor = new FileProcessor(fileNameIn);
    }

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DeserializationStrategy deSerializationStrategy = null;
        SerializationStrategy serializationStrategy = null;
        if (method.getName().equals("writeObj")) {
            if( args[1].toString().toLowerCase().equals("xml")){
                serializationStrategy = new XMLSerializationStrategy( fileWriter);
                return serializationStrategy.serialize((SerializableObject)args[0]);
            }
        } else if (method.getName().equals("readObj") ) {
            if( args[0].toString().toLowerCase().equals("xml")){
                deSerializationStrategy = new XMLDeserializationStrategy( fileProcessor);
                return deSerializationStrategy.deSerialize();
            }
        }

//        System.out.println("Hi you are actually here");
        return null;
    }

    /**
     * Opens a file to read
     */
    public void openFile(){
        fileProcessor.openFile();
    }

    /**
     * Closes a file after reading
     */
    public void closeFile(){
        fileProcessor.closeFile();
    }

    /**
     * Opens a file to write
     */
    public void openWriteFile(){
        fileWriter = new FileWriter(fileName);
        fileWriter.openFile();
    }

    /**
     * Closes a file after writing
     */
    public void closeWriteFile(){
        fileWriter.closeFile();
    }


}
