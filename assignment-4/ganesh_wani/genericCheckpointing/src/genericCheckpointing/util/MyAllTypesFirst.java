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

    /**
     * Constructor which does nothing
     */
    public MyAllTypesFirst () {}

    /**
     * Constructor which initializes all its fields
     * @param myInt
     * @param myString
     * @param myDouble
     * @param myLong
     * @param myChar
     */
    public MyAllTypesFirst(int myInt, String myString, double myDouble, long myLong, char myChar) {
        this.myInt = myInt;
        this.myString = myString;
        this.myDouble = myDouble;
        this.myLong = myLong;
        this.myChar = myChar;
    }

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

    /**
     * Method which takes an object and checks its equality
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyAllTypesFirst that = (MyAllTypesFirst) o;

        if (myChar != that.myChar) return false;
        if (Double.compare(that.myDouble, myDouble) != 0) return false;
        if (myInt != that.myInt) return false;
        if (myLong != that.myLong) return false;
        if (myString != null ? !myString.equals(that.myString) : that.myString != null) return false;

        return true;
    }

    /**
     * Method to generate the hashCode
     * @return
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = myInt;
        result = 31 * result + (myString != null ? myString.hashCode() : 0);
        temp = Double.doubleToLongBits(myDouble);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (myLong ^ (myLong >>> 32));
        result = 31 * result + (int) myChar;
        return result;
    }
}
