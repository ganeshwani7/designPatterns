package genericCheckpointing.util;

/**
 * Created by ganeshwani on 12/13/14.
 */
public class MyAllTypesFirst extends SerializableObject{
    private int myInt;
    private String myString;
    private double myDouble;
    private long myLong;
    private char myChar;

    public int getMyInt() {
        return myInt;
    }

    public String getMyString() {
        return myString;
    }

    public double getMyDouble() {
        return myDouble;
    }

    public char getMyChar() {
        return myChar;
    }

    public long getMyLong() {
        return myLong;
    }

    public void setMyInt(int myInt) {
        this.myInt = myInt;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public void setMyDouble(double myDouble) {
        this.myDouble = myDouble;
    }

    public void setMyLong(long myLong) {
        this.myLong = myLong;
    }

    public void setMyChar(char myChar) {
        this.myChar = myChar;
    }
}
