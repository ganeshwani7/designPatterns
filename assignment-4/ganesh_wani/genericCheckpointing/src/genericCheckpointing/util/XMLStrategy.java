package genericCheckpointing.util;

/**
 * Created by ganeshwani on 12/13/14.
 */
public class XMLStrategy implements CheckStrategy {
    @Override
    public boolean check(String s) {
        if( s.toLowerCase().equals("xml"))
            return true;
        else
            return false;
    }
}
