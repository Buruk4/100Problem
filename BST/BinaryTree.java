package BST;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // util
    boolean isRootNull() {
        return root == null ? true : false;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {

        // if root is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // else

        if (key < root.key) {
            root.left = insertRec(root.left, key);
            System.out.println("inserted to left " + key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
            System.out.println("inserted to right " + key);
        }
        return root;
    }

    // print

    public void inorder() {
        inorderRec(root);
    }

    // util
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key + "  ");
            inorderRec(root.right);

        }
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {

        if (root == null)
            return false;

        if (root.key == key)
            return true;
        else if (key < root.key)
            searchRec(root.left, key);
        else if (key > root.key)
            searchRec(root.right, key);
        return false;
    }

    public int findmin() {
        return findMinRec(root);
    }

    private int findMinRec(Node root) {

        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        if (root.left == null)
            return root.key;

        return findMinRec(root.left);
    }

    public int findMax() {
        return findMaxRec(root);
    }

    private int findMaxRec(Node root) {

        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        if (root.right == null)
            return root.key;

        return findMaxRec(root.right);
    }

    // check if tree is balanced or not

    // calculate the height og a tree

    private static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static boolean isBalanced(Node root) {

        // empty tree is always balanced
        if (root == null) {
            return true;
        }

        // height of left and right

        int leftH = height(root.left);
        int rightH = height(root.right);

        if (Math.abs(leftH - rightH) > 1) {
            return false;
        }

        // Recursively check the left and right subtrees

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right = new Node(30);
        root.right = new Node(30);
        root.right = new Node(30);
        root.right = new Node(30);

        System.out.println(isBalanced(root));

    }
}
