package genericCheckpointing.server;

import genericCheckpointing.util.SerializableObject;

/**
 * Created by ganeshwani on 12/13/14.
 */
public interface RestoreI extends StoreRestoreI{
    SerializableObject readObj(String wireFormat);
}
