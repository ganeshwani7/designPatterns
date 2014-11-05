package studentRecordsBackup.bst;

/**
 * Created by GaneshMac on 11/2/14.
 */
public class BST implements BSTI{
    @Override
    public String toString() {
        return "BST{" +
                "root=" + root +
                ", nodeCount=" + nodeCount +
                '}';
    }

    private Node root;
    private int nodeCount = 0;

    public BST(){
        root = null;
    }

    /**
     * @param
     * @param node
     * @return Node
     * */
    @Override
    public Node insert( Node node){
        if( root == null){
            ++nodeCount;
            root = node;
            return root;
        }
        else if( node != null){
            ++nodeCount;
            root = recursiveInsert(root, node);
        }
        return root;
    }

    /**
     * @return Node
     * @param currentNode
     * @param node
     * */

    public Node recursiveInsert( Node currentNode, Node node){
        
        if( currentNode.getLeft() != null && currentNode.getbNumber() > node.getbNumber() )
            currentNode.setLeft( recursiveInsert( currentNode.getLeft(), node) );
        else if( currentNode.getRight() != null && currentNode.getbNumber() < node.getbNumber())
            currentNode.setRight( recursiveInsert( currentNode.getRight(), node) );
        else if( currentNode.getLeft() == null && currentNode.getbNumber() > node.getbNumber() )
            currentNode.setLeft( node);
        else if( currentNode.getRight() == null && currentNode.getbNumber() < node.getbNumber() )
            currentNode.setRight( node);
        return currentNode;
    }

    /**
     * 
     */
    @Override
    public void printInorder(){
        recursiveInorder( root);
    }

    private void recursiveInorder( Node node){
        if( node == null)
            return;
        recursiveInorder( node.getLeft());
        System.out.println( node.getbNumber());
        recursiveInorder( node.getRight());
    }

    @Override
    public void updateTree(int UPDATE_VALUE){
        recursiveUpdate(root, UPDATE_VALUE);
    }

    private void recursiveUpdate( Node node, int UPDATE_VALUE){
        if( node == null)
            return;
        recursiveUpdate(node.getLeft(), UPDATE_VALUE);
        node.updateNode( UPDATE_VALUE);
        recursiveUpdate(node.getRight(), UPDATE_VALUE);
    }

    public int getSum(){
        return recursiveGetSum( root);
    }

    private int recursiveGetSum(Node node) {
        if( node == null)
            return 0;
        return node.getbNumber() + recursiveGetSum(node.getLeft())
                + recursiveGetSum(node.getRight());
    }

    public int getNodeCount() {
        return nodeCount;
    }
}