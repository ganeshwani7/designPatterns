package genericCheckpointing.util;

/**
 * Created by ganeshwani on 12/13/14.
 */
public class MyAllTypesSecond extends SerializableObject {
    private int myIntS;
    private String myStringS;
    private float myFloatS;
    private short myShortS;
    private char myCharS;

    public void setMyIntS(int myIntS) {
        this.myIntS = myIntS;
    }

    public void setMyStringS(String myStringS) {
        this.myStringS = myStringS;
    }

    public void setMyFloatS(float myFloatS) {
        this.myFloatS = myFloatS;
    }

    public void setMyShortS(short myShortS) {
        this.myShortS = myShortS;
    }

    public void setMyCharS(char myCharS) {
        this.myCharS = myCharS;
    }

    public int getMyIntS() {

        return myIntS;
    }

    public String getMyStringS() {
        return myStringS;
    }

    public float getMyFloatS() {
        return myFloatS;
    }

    public short getMyShortS() {
        return myShortS;
    }

    public char getMyCharS() {
        return myCharS;
    }
}
