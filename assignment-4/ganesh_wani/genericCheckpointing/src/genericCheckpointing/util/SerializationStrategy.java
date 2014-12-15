package genericCheckpointing.util;

/**
 * Created by ganeshwani on 12/14/14.
 */
public interface SerializationStrategy {
    Object serialize( SerializableObject object);
}
