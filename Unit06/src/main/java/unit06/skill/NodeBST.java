package unit06.skill;

import java.util.Comparator;

public class NodeBST implements BinarySearchTree {
    private BinaryNode root;
    private int size;
    private Comparator<Integer> comparator;

    public NodeBST() {
        this(null);
    }

    public NodeBST(Comparator<Integer> comparator) {
        this.root = null;
        this.size = 0;
        this.comparator = comparator != null ? comparator : Integer::compare;
    }

    @Override
    public void insert(int value) {
       if(root == null) {
            root = new BinaryNode(value);
       } else {
            binaryInsert(root, value);
       }
       size += 1;
    }

    @Override
    public boolean search(int target) {
        return this.root == null ? false : binarySearch(root, target);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return root != null ? root.infixTraversal() : "<empty>";
    }

    private void binaryInsert(BinaryNode node, int value) {
        int cmp = comparator.compare(value, node.getValue());
        if(cmp < 0) {
            BinaryNode left = node.getLeft();
            if(left != null) {
                binaryInsert(left, value);
            } else {
                left = new BinaryNode(value);
                node.setLeft(left);
            }
        } else {
            BinaryNode right = node.getRight();
            if(right != null) {
                binaryInsert(right, value);
            } else {
                right = new BinaryNode(value);
                node.setRight(right);
            }
        }
    }

    private boolean binarySearch(BinaryNode node, int target) {
        int cmp = comparator.compare(target, node.getValue());
        if(cmp == 0) {
            return true;
        } else if(cmp < 0) {
            BinaryNode left = node.getLeft();
            return left != null && binarySearch(left, target);
        } else {
            BinaryNode right = node.getRight();
            return right != null && binarySearch(right, target);
        }
    }
}
