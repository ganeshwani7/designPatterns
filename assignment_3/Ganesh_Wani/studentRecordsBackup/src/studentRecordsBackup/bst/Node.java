package studentRecordsBackup.bst;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by GaneshMac on 11/2/14.
 */
public class Node extends Observable implements Observer{
    private int bNumber;
    private String description;

//    private List<Observer> observers;

    private Node left, right;

    public Node( int inBNumner, String inDescription){
        bNumber = inBNumner;
        description = inDescription;
        left = null;
        right = null;
    }

    public Node getRight() {
        return right;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setbNumber(int bNumber) {
        this.bNumber = bNumber;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getbNumber(){

        return bNumber;
    }

    public Node getLeft() {
        return left;
    }

    @Override
    public String toString() {
        return "Node{" +
                "bNumber=" + bNumber +
                ", description='" + description + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public String getDescription(){

        return description;
    }

   /**
    * @param inValue
    * */
    public void updateNode( int inValue){
        bNumber += inValue;
        setChanged();
        notifyObservers(inValue);
    }

//    @Override
//    public void addObserver( Observer observer){
//        observers.add(observer);
//    }

//    @Override
//    public void notifyObservers(){
//        for( Observer n: observers){
//            n.update(this, n);
//        }
//    }

    /**@param
     * @see java.util.Observable
     */
    @Override
    public void update(Observable observable, Object o) {
//        System.out.println("Inside update method object class is: "+o.getClass());
        int number = (Integer)o;
        this.bNumber += number;
    }
}
