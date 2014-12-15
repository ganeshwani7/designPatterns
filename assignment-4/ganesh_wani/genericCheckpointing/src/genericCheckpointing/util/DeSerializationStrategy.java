package genericCheckpointing.util;

import java.io.File;
import java.util.Objects;

/**
 * Created by ganeshwani on 12/14/14.
 */
public interface DeserializationStrategy {
    Object deSerialize( );
}
