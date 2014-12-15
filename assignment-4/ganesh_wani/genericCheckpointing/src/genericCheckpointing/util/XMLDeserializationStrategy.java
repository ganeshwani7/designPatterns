package genericCheckpointing.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ganeshwani on 12/14/14.
 */
public class XMLDeserializationStrategy implements DeserializationStrategy{
    FileProcessor fileProcessor = null;

    /**
     * Constructor which initializes FileProcessor
     * @param fileProcessorIn
     */
    public XMLDeserializationStrategy( FileProcessor fileProcessorIn){
        this.fileProcessor = fileProcessorIn;
    }

    /**
     * Fetches data from a file and returns a single object at a time
     * @return
     */
    @Override
    public Object deSerialize ( ) {
        Pattern typePattern = Pattern.compile("xsi:type=\"(.+?)\"");
        Pattern valuePattern = Pattern.compile(">(.+?)<");

        // Reflection class declaration
        Class cls = null;
        Object obj = null;
        SerializableObject serializableObject = null;
        while( true ){
            String line = fileProcessor.readLineFromFile();
            if( line == null)
                break;

            Matcher typeMatcher = typePattern.matcher(line);
            Matcher valueMatcher = null;

            // Set matcher for value
            valueMatcher = valuePattern.matcher(line);

            if( line.equals("<DPSerialization>") || line.contains("</complexType>") ){
                continue;
            }
            else if ( line.contains("<complexType") ){
                typeMatcher = typePattern.matcher(line);
                String className = "";
                if( typeMatcher.find())
                    className = typeMatcher.group(1);
                else
                    continue;
                try {
                    cls = Class.forName(className);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    obj = cls.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            else if( line.contains("</DPSerialization>")){
                break;
            }
            else {
                line = line.trim();
                String methodName = "set" + line.substring(1,2).toUpperCase() + line.substring(2, line.indexOf(" "));
                Method m = null;
                Class [] params = new Class[1];

                typeMatcher = typePattern.matcher(line);
                String type = "";
                if( typeMatcher.find())
                    type = typeMatcher.group(1);

                valueMatcher= valuePattern.matcher(line);
                Integer value = 0;

                try {
                    if (valueMatcher.find()) {
                        if (type.contains("int")) {
                            params[0] = Integer.TYPE;
                            m = cls.getDeclaredMethod(methodName, params);
                            m.invoke( obj, Integer.parseInt( valueMatcher.group(1)));
                        } else if (type.contains("string")) {
                            params[0] = String.class;
                            m = cls.getDeclaredMethod( methodName, params);
                            String temp = valueMatcher.group(1);
                            m.invoke( obj,  temp);
                        } else if (type.contains("float")) {
                            params[0] = Float.TYPE;
                            m = cls.getDeclaredMethod( methodName, params);
                            m.invoke( obj, Float.parseFloat(valueMatcher.group(1)));
                        } else if (type.contains("double")) {
                            params[0] = Double.TYPE;
                            m = cls.getDeclaredMethod( methodName, params);
                            m.invoke( obj, Double.parseDouble( valueMatcher.group(1)));
                        } else if (type.contains("short")) {
                            params[0] = Short.TYPE;
                            m = cls.getDeclaredMethod( methodName, params);
                            m.invoke( obj, Short.parseShort(valueMatcher.group(1)));
                        } else if (type.contains("long")) {
                            params[0] = Long.TYPE;
                            m = cls.getDeclaredMethod(methodName, params);
                            m.invoke( obj,  Long.parseLong(valueMatcher.group(1)));
                        } else if (type.contains("char")) {
                            params[0] = Character.TYPE;
                            m = cls.getDeclaredMethod(methodName, params);
                            m.invoke( obj,  valueMatcher.group(1).charAt(0));
                        }
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        serializableObject = (SerializableObject)obj;
        return serializableObject;
    }
}
