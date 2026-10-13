public class Node{
    private int value; 

    private Node left; 
    private Node right; 

    public Node(int value) {
        this.value = value; 

        this.left = this.right = null; 
    }

    public int getValue() {
        return value; 
    }

    public Node getLeft() {
        return left; 
    }

    public void setLeft(Node left) {
        this.left = left; 
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right; 
    }

    @Override
    public String toString() {
        String res - "BinaryNode{value="+ this.value; 
 
        if(this.left!=null) {
            res =  res + "left" + this.left.toString(); 
        }

        if(this.right!=null) {
            res =  res + "right" + this.right.toString(); 
        }

        return res + "}" ;z
    }
}