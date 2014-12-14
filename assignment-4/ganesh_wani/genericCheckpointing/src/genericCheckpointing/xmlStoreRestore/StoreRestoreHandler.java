package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.SerializableObject;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ganeshwani on 12/13/14.
 */
public class StoreRestoreHandler implements InvocationHandler{
    String fileName;
    FileProcessor fileProcessor = null;


    public StoreRestoreHandler( String fileNameIn){
        this.fileName = fileNameIn;
        fileProcessor = new FileProcessor(fileNameIn);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        try {
            if (method.getName().equals("writeObj")) {
            } else if (method.getName().equals("readObj") && args[0].toString().toLowerCase().equals("xml")) {
                return deSerialize();
            }
        } catch ( Exception e){
            e.printStackTrace();
        }

//        System.out.println("Hi you are actually here");
        return null;
    }

    public void openFile(){
        fileProcessor.openFile();
    }

    public void closeFile(){
        fileProcessor.closeFile();
    }

    public SerializableObject deSerialize() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InstantiationException {
        // Pattern declaration to extract data
        Pattern typePattern = Pattern.compile("xsi:type=\"(.+?)\"");
        Pattern valuePattern = Pattern.compile(">(.+?)<");

        // Reflection class declaration
        Class cls = null;
        Object obj = null;
        SerializableObject serializableObject = new MyAllTypesFirst();
        while( true ){
            String line = fileProcessor.readLineFromFile();
            if( line == null)
                break;

            Matcher matcher = typePattern.matcher(line);
            // Set matcher for value
            matcher = valuePattern.matcher(line);

            if( line.equals("<DPSerialization>")){
                continue;
            }
            else if ( line.contains("<complexType") ){
                matcher = typePattern.matcher(line);
                String className = "";
                if( matcher.find())
                    className = matcher.group(1);
                else
                    continue;
                cls = Class.forName(className);
                obj = cls.newInstance();
            }
            else if( line.equals("</complexType>") || line.equals("</DPSerialization>")){
                break;
            }
            else {
                line = line.trim();
                String methodName = "set" + line.substring(1,2).toUpperCase() + line.substring(2, line.indexOf(" "));
                Method m = null;
                Method[] allMethods = cls.getDeclaredMethods();
                Class [] paramInt = new Class[1];
                paramInt[0] = Integer.TYPE;
                m = cls.getDeclaredMethod( methodName, paramInt);

                matcher = valuePattern.matcher(line);
                Integer value = 0;
                if(matcher.find())
                    value = Integer.parseInt( matcher.group(1));
                    obj = m.invoke(obj, value);
            }
        }
        return serializableObject;
    }
}
