package genericCheckpointing.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ganeshwani on 12/14/14.
 */
public class XMLSerializationStrategy implements SerializationStrategy{
    Map<String, String> typeMap = new HashMap<>();
    FileWriter fileWriter= null;

    /**
     * Initializes FileWriter
     * @param fileWriterIn
     */
    public XMLSerializationStrategy( FileWriter fileWriterIn){
        this.fileWriter = fileWriterIn;
    }

    /**
     * Takes an object, serializes it and write into the file
     * @param object
     * @return
     */
    @Override
    public Object serialize( SerializableObject object) {
        initializeMap();
        if(object == null)
            return null;

        Class cls = object.getClass();
       // System.out.println("Class name is " + cls.getName());
        startDpSerialization();
        startComplexType( cls.getName());
        Field[] fields = cls.getDeclaredFields();
        for( Field field : fields){
            try {
                field.setAccessible(true);
                field.get(object);
                writeField(field.getName(),
                        typeMap.get(field.getType().toString()),    //This will give you actual type of a field to be
                        //serialized
                        field.get(object).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        closeComplexType();
        closeDpSerialization();
        return null;
    }

    /**
     *
     * @param fieldName
     * @param typeName
     * @param value
     */
    private void writeField( String fieldName, String typeName, String value){
        String line = "";
        line += "\t\t<" + fieldName + " xsi:type=\"xsd:"+ typeName + "\">" +
                value +
                "</" + fieldName + ">\n";
        fileWriter.writeResults(line);
    }

    private void startComplexType(String typeName){
        String line = "";
        line += "\t<complexType xsi:type=\""+ typeName + "\">\n" ;
        fileWriter.writeResults( line);
    }

    private void closeComplexType(){
        fileWriter.writeResults("\t</complexType>\n");
    }

    private void startDpSerialization(){
        fileWriter.writeResults("<DPSerialization>\n");
    }

    private void closeDpSerialization(){
        fileWriter.writeResults("</DPSerialization>\n");
    }

    private void initializeMap() {
        typeMap.put("class java.lang.String","string");
        typeMap.put("int","int");
        typeMap.put("double","double");
        typeMap.put("long","long");
        typeMap.put("char","char");
        typeMap.put("short","short");
        typeMap.put("float","float");
    }
}
