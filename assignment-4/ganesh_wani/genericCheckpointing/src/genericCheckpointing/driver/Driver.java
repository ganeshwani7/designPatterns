package genericCheckpointing.driver;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

import java.lang.reflect.InvocationHandler;
import java.util.Vector;

/**
 * Created by ganeshwani on 12/13/14.
 */
public class Driver {
    public static void main( String [] args){
// FIXME: read the value of checkpointFile from the command line
        int NUM_OF_OBJECTS = 0;
        String fileName = "";
        if( args.length != 2){
            System.out.println("Oops, format :java class <FILENAME> <no-of-arguments>");
            System.exit(1);
        }
        fileName = args[0];
        try {
            NUM_OF_OBJECTS = Integer.parseInt(args[1]);
        }catch (NumberFormatException nfe) {
            System.out.println("input is not a number");
            System.exit(1);
        }

        ProxyCreator pc = new ProxyCreator();
        // create an instance of StoreRestoreHandler (which implements
        // the InvocationHandler
        StoreRestoreHandler handler = new StoreRestoreHandler(fileName);
        Vector<SerializableObject> vectorOld = new Vector<SerializableObject>();
        Vector<SerializableObject> vectorNew = new Vector<SerializableObject>();

        // create a proxy
        StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
                new Class[] {
                        StoreI.class, RestoreI.class
                },
                handler
        );

        // FIXME: invoke a method on the handler instance to set the file name for checkpointFile and open the file

        MyAllTypesFirst myFirst;
        MyAllTypesSecond  mySecond;

        // create a vector to store the objects being serialized
        for (int i=0; i< NUM_OF_OBJECTS; i++) {
            // FIXME: create these object instances correctly.
            myFirst = new MyAllTypesFirst( );
            mySecond = new MyAllTypesSecond();

            // FIXME: store myFirst and mySecond in the vector
            ((StoreI) cpointRef).writeObj(myFirst, "XML");
            ((StoreI) cpointRef).writeObj(mySecond, "XML");
        }

        SerializableObject myRecordRet;

        // create a vector to store the returned objects
        handler.openFile();
        for (int j=0; j < NUM_OF_OBJECTS; j++) {

            myRecordRet = ((RestoreI) cpointRef).readObj("XML");
            // FIXME: store myRecordRet in the vector
        }
        handler.closeFile();
        // FIXME: invoke a method on the handler to close the file (if it hasn't already been closed

        // FIXME: compare and confirm that the serialized and deserialzed objects are equal

    }
}