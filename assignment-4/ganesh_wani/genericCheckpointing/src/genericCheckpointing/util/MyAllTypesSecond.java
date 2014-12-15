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

    /**
     * Constructor which does nothing
     */
    public MyAllTypesSecond(){}

    /**
     * Constructor which initializes all its parameters
     * @param myIntS
     * @param myStringS
     * @param myFloatS
     * @param myShortS
     * @param myCharS
     */
    public MyAllTypesSecond(int myIntS, String myStringS, float myFloatS, short myShortS, char myCharS) {
        this.myIntS = myIntS;
        this.myStringS = myStringS;
        this.myFloatS = myFloatS;
        this.myShortS = myShortS;
        this.myCharS = myCharS;
    }

    /**
     *
     * @param myIntS
     */
    public void setMyIntS(int myIntS) {
        this.myIntS = myIntS;
    }

    /**
     * Equals method
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyAllTypesSecond that = (MyAllTypesSecond) o;

        if (myCharS != that.myCharS) return false;
        if (Float.compare(that.myFloatS, myFloatS) != 0) return false;
        if (myIntS != that.myIntS) return false;
        if (myShortS != that.myShortS) return false;
        if (myStringS != null ? !myStringS.equals(that.myStringS) : that.myStringS != null) return false;

        return true;
    }

    /**
     * Hashcode method
     * @return
     */
    @Override
    public int hashCode() {
        int result = myIntS;
        result = 31 * result + (myStringS != null ? myStringS.hashCode() : 0);
        result = 31 * result + (myFloatS != +0.0f ? Float.floatToIntBits(myFloatS) : 0);
        result = 31 * result + (int) myShortS;
        result = 31 * result + (int) myCharS;
        return result;
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
