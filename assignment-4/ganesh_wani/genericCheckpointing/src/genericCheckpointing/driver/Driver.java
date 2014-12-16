package genericCheckpointing.driver;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.*;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

import java.lang.reflect.InvocationHandler;
import java.util.Vector;

/**
 * Created by ganeshwani on 12/13/14.
 */
public class Driver {
    public static void main( String [] args){
// FIXME: read the value of checkpointFile from the command line
        int NUM_OF_OBJECTS = 0, mismatchCount = 0;
        String fileName = "";
        if( args.length != 3){
            System.out.println("Oops, format :java class <FILENAME> <no-of-objects> <ser|deser|serdeser>");
            System.exit(1);
        }
        fileName = args[0];
        try {
            NUM_OF_OBJECTS = Integer.parseInt(args[1]);
        }catch (NumberFormatException nfe) {
            System.out.println("Number of arguments is not a number");
            System.exit(1);
        }


        ProxyCreator pc = new ProxyCreator();
        // create an instance of StoreRestoreHandler (which implements
        // the InvocationHandler
        StoreRestoreHandler handler = new StoreRestoreHandler(fileName);

        // create a proxy
        StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
                new Class[] {
                        StoreI.class, RestoreI.class
                },
                handler
        );

        Vector<SerializableObject> vectorOld = new Vector<>();
        Vector<SerializableObject> vectorNew = new Vector<>();
        MyAllTypesFirst myFirst;
        MyAllTypesSecond  mySecond;


        for (int i=0; i< NUM_OF_OBJECTS; i++) {
            // FIXME: create these object instances correctly.
            myFirst = new MyAllTypesFirst(i + 1, "DP" + i, 24.35 + i, 24, 'p');
            mySecond = new MyAllTypesSecond(i + 2, "DP" + i, 48.35f + i, (short) (24 + i), 'p');

            vectorOld.add(myFirst);
            vectorOld.add(mySecond);
        }

        if( args[2].toLowerCase().equals("ser") ||
                args[2].toLowerCase().equals("serdeser")){
            handler.openWriteFile();
            for (int i=0; i< NUM_OF_OBJECTS ; i++) {
                // FIXME: create these object instances correctly.
                // FIXME: store myFirst and mySecond in the vector
                ((StoreI) cpointRef).writeObj( (MyAllTypesFirst)vectorOld.get(i*2), "XML");
                ((StoreI) cpointRef).writeObj((MyAllTypesSecond)vectorOld.get(i*2 +1), "XML");
            }
            handler.closeWriteFile();
        }

        if( args[2].toLowerCase().equals("deser") ||
                args[2].toLowerCase().equals("serdeser")){
            handler.openFile();
            for (int j=0; j < NUM_OF_OBJECTS * 2 ; j++) {
                SerializableObject myRecordRet = ((RestoreI) cpointRef).readObj("XML");
                vectorNew.add(myRecordRet);
                // FIXME: store myRecordRet in the vector
            }
//            System.out.println("Vector size is : " + vectorNew.size());
            handler.closeFile();
            mismatchCount = checkVectors( vectorOld, vectorNew);
//            System.out.println("Number of records mis-matched are : " + mismatchCount);
        }

        if( args[2].toLowerCase().equals("serdeser") ){
            mismatchCount = checkVectors(vectorOld, vectorNew);
        }
        System.out.println("Number of records mis-matched are : " + mismatchCount);
    }

    /**
     *
     * @param vectorOld
     * @param vectorNew
     * @return number of mismatches between two vectors
     */
    private static int checkVectors(Vector<SerializableObject> vectorOld, Vector<SerializableObject> vectorNew) {
        int mismatchedCount = 0;
        for( int i = 0; i< vectorOld.size() && i < vectorNew.size() ; i++){
            if(! vectorOld.get(i).equals(vectorNew.get(i))){
                ++mismatchedCount;
            }
        }
        return mismatchedCount;
    }

}