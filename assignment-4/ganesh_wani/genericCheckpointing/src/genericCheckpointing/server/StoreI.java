package genericCheckpointing.server;

import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;

/**
 * Created by ganeshwani on 12/13/14.
 */
public interface StoreI extends StoreRestoreI{
    void writeObj( MyAllTypesFirst aRecord, String wireFormat);
    void writeObj( MyAllTypesSecond aRecords, String wireFormat);
}
