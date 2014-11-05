package studentRecordsBackup.driver;

import java.util.Vector;

import studentRecordsBackup.bst.BST;
import studentRecordsBackup.bst.BSTI;
import studentRecordsBackup.util.Logger;
import studentRecordsBackup.util.bstBuilder.BSTBuilder;
import studentRecordsBackup.util.bstBuilder.Builder;
//import sun.jvm.hotspot.utilities.Assert;

public class Driver{
	
	/**
	* Main method
	*Returns void
	*/
	public static void main( String []args){
		if( args.length != 2){
            System.out.println( "Usage: ant <filename> <UPDATE_VALUE>");
			System.exit(1);
		}
		//Check for the null parameters
//		if( !args[1].matches("^\\d+$") ){
//			System.out.println(" Please enter the valid arguments");
//			System.exit(1);
//		}

        String filename = args[0];
		Logger logger = Logger.getInstance();
//		logger.setLoggerValue( Integer.parseInt( filename));

        BSTI bst= new BST();
        BSTI backupBst1 = new BST();
        BSTI backupBst2 = new BST();

        Builder bstBuilder = new BSTBuilder();
        bstBuilder.construct(bst, backupBst1, backupBst2, filename);

        bst.printInorder();
//        System.out.println("Node count is " + bst.getNodeCount() );
//        System.out.println("Node count is " + backupBst1.getNodeCount());
//        System.out.println("Node count is " + backupBst2.getNodeCount());

        try{
            bst.updateTree( Integer.valueOf( args[1]));
        }catch( Exception e){
            e.printStackTrace();
   }

        System.out.println("BST sum is : " + bst.getSum());
        System.out.println("Backup BST 1 sum is : " + backupBst1.getSum());
        System.out.println("Backup BST 2 sum is :  " + backupBst2.getSum());

//        Assert.ASSERTS_ENABLED;
//        Assert.that( bst.getSum() == backupBst1.getSum()," Assertion failed!" );
        assert bst.getSum() == backupBst1.getSum() && bst.getSum() == backupBst2.getSum();
        //System.out.println(realComponents);
	}
}
