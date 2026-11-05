package unit06.skill;

/**
 * Hello world!
 */
public class App {

    public static BinaryNode pacticeTree() {
        BinaryNode node4 = new BinaryNode(4); 
        BinaryNode node7 = new BinaryNode(7); 
        BinaryNode node13 = new BinaryNode(13); 

        BinaryNode node6 = new BinaryNode(6, node4, node7);
        BinaryNode node14 = new BinaryNode(14, node13, null);
        BinaryNode node1 = new BinaryNode(1);

        BinaryNode node3 = new BinaryNode(3, node1, node6);
        BinaryNode node10 = new BinaryNode(10, null, node14);

        BinaryNode root = new BinaryNode(8, node3, node10);
        System.out.println(root.infixTraversal());

        int[] samples = {6, 13, 2, 20}; 
        for (int element : samples) {
            System.out.println(root.search(element) ? String.format("%s found: true", element) : String.format("%s found: false", element) );
        }

        return root; 
    }

    public static void practiceBST() {
        NodeBST grimoires = new NodeBST();
        int[] samples = {15, 42, 28, 113, 7, 60}; 
        for (int element : samples) {
            grimoires.insert(element); 
        }

        System.err.println(grimoires);

        int[] search = {28, 100}; 
        for (int element : search) {

            if(grimoires.search(element)) {
                System.out.println(String.format("\nGrimore with %s spells found: true", element) );
            }
        }
    }

    public static void BSTdescending() {
        NodeBST grimoires = new NodeBST(new DescendingComparator());

        int[] samples = {47, 17, 138, 72, 6, 23}; 
        for (int element : samples) {
            grimoires.insert(element); 
        }

        BinaryNode current = grimoires.
        while()
    }

    public static String traversalValuePractice() {
        String traversed = ""; 

        

        return traversed;
    }

    public static int traversalSmallestValuePractice(BinaryNode node) {
        if(node == null) {
            return 0; 
        }

        if(node.getLeft() == null) {
            return node.getValue();
        }
         
        return traversalSmallestValuePractice(node.getLeft());
    }

    public static int traversalLargestValuePractice(BinaryNode node) {
        if(node == null) {
            return 0; 
        }

        if(node.getRight() == null) {
            return node.getValue();
        }
         
        return traversalLargestValuePractice(node.getRight());
    }
    public static void main(String[] args) {
        System.out.println(traversalLargestValuePractice(pacticeTree()));
    }
} 
