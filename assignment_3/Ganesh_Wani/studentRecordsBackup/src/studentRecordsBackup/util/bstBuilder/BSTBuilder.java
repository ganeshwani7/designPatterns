package studentRecordsBackup.util.bstBuilder;

import studentRecordsBackup.bst.BST;
import studentRecordsBackup.bst.BSTI;
import studentRecordsBackup.bst.Node;
import studentRecordsBackup.util.FileProcessor;

/**
 * Created by GaneshMac on 11/2/14.
 */
//implements Builder
public class BSTBuilder implements Builder{
    @Override
    public void construct(BSTI tree, BSTI backupTree1, BSTI backupTree2, String filename) {
        FileProcessor fileProcessor = new FileProcessor(filename);
        String line = "";
        while( true){
            line = fileProcessor.readLineFromFile();
            if( line == null)
                break;

            String[] parts = line.split(" ");
            Node originalNode = new Node( Integer.valueOf(parts[0]), parts[1] );

//            tree.insert( new Node( Integer.valueOf(parts[0]), parts[1] ));

            Node node1= new Node( Integer.valueOf(parts[0]), parts[1]);
            Node node2= new Node( Integer.valueOf(parts[0]), parts[1]);

            originalNode.addObserver( node1);
            originalNode.addObserver( node2);
            tree.insert( originalNode);

            backupTree1.insert( node1);
            backupTree2.insert( node2);
        }
    }

    @Override
    public String toString(){
        return "BSTBuilder";
    }
}
