package genericCheckpointing.util;

import genericCheckpointing.server.StoreRestoreI;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by ganeshwani on 12/13/14.
 */

public class ProxyCreator {
    /**
     * method which creates a proxy and returns proxy
     * @param interfaceArray
     * @param handler
     * @return
     */
    public StoreRestoreI createProxy(Class<?>[] interfaceArray, InvocationHandler handler){
        StoreRestoreI storeRestoreRef =
                (StoreRestoreI)
                        Proxy.newProxyInstance(
                                getClass().getClassLoader(),
                                interfaceArray,
                                handler
                        );

        return storeRestoreRef;
    }

}
