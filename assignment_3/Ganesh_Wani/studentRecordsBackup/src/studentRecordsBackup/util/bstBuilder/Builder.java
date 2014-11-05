package studentRecordsBackup.util.bstBuilder;

import studentRecordsBackup.bst.BST;
import studentRecordsBackup.bst.BSTI;

/**
 * Created by GaneshMac on 11/2/14.
 */
public interface Builder {
    public void construct( BSTI tree, BSTI backupBst1, BSTI backupBst2, String filename);
}
