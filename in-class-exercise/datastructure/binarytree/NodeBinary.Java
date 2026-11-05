package binarytree; 

public class NodeBinary{
    private int value; 

    private NodeBinary left; 
    private NodeBinary right; 

    public NodeBinary(int value) {
        this.value = value; 

        this.left = this.right = null; 
    }

    public int getValue() {
        return value; 
    }

    public NodeBinary getLeft() {
        return left; 
    }

    public void setLeft(NodeBinary left) {
        this.left = left; 
    }

    public NodeBinary getRight() {
        return right;
    }

    public void setRight(NodeBinary right) {
        this.right = right; 
    }

    public String infixTraversal() {
        String result = ""; 

        if(this.left != null) {
            result = result + this.left.infixTraversal(); 
            
        }

        result += this.value + " " ; 

        if(this.right != null) {
            result = result + this.right.infixTraversal(); 
        }

        return result; 
    }
 
    public boolean search(int target) {
        if(this.value == target) {
            return true; 
        }

        if(this.left != null) {
            if(this.left.search(target)) {
                return true; 
            }
        }

        if(this.right != null) {
            if(this.right.search(target)) {
                return true; 
            }
        }

        return false; 
    }

    @Override
    public String toString() {
        String res = "NodeBinary{value=" + this.value; 
 
        if(this.left!=null) {
            res =  res + "left" + this.left.toString(); 
        }

        if(this.right!=null) {
            res =  res + "right" + this.right.toString(); 
        }

        return res + "}" ;
    }
}