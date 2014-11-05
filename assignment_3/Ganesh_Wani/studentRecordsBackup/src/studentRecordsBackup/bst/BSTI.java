package studentRecordsBackup.bst;

/**
 * Created by GaneshMac on 11/2/14.
 */
public interface BSTI {
    public void printInorder();
    public Node insert( Node node);

    void updateTree(int UPDATE_VALUE);

    public int getNodeCount();

    public int getSum();
}
