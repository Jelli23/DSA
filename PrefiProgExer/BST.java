/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PrefiProgExer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 *
 * @author jbjco
 */
public class BST {
    protected BSTNode root;
    public BST() {
    root = null;
    }
    //Visits a node
    protected void visit(BSTNode p) {
    System.out.print(p.key + " ");
    }
    //Searches for a node
    public BSTNode search(int el) {
    return search(root, el);
    }
    
    private BSTNode search(BSTNode p, int el) {
        while (p != null)
        if (el == p.key)
            return p;
        else if (el < p.key)
            p = p.left;
        else p = p.right;
            return null;
    }
    //Traverses through the tree in levels
    public void breadthFirst(){
        BSTNode p = root;
        Queue<BSTNode> queue = new LinkedList<>();
        if (p != null) {
            queue.add(p);
            while (!queue.isEmpty()) {
                p = (BSTNode) queue.remove();
                visit(p);
                if (p.left != null)
                    queue.add(p.left);
                if (p.right != null)
                    queue.add(p.right);
            }
        }
    }
    //Visits the node first before traversing from left and right
    public void preorder() {
        preorder(root);
    }
    
    protected void preorder(BSTNode p){
        if (p != null) {
            visit(p);
            preorder(p.left);
            preorder(p.right);
        }
    }
    //Traverses left, then visits, afterwards traverses right
    public void inorder() {
        inorder(root);
    }
    
    protected void inorder(BSTNode p){
        if (p != null) {
            inorder(p.left);
            visit(p);
            inorder(p.right);
        }
    }
    //Traverses left and right before visiting the node
    public void postorder() {
        postorder(root);
    }
    
    protected void postorder(BSTNode p){
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            visit(p);
        }
    }
    
    public void iterativePreorder(){ //6.15
        BSTNode p = root;
        Stack travStack = new Stack();
        if (p != null) {
            travStack.push(p);
            while (!travStack.isEmpty()) {
                p = (BSTNode) travStack.pop();
                visit(p);
                if (p.right != null)
                    travStack.push(p.right);
                if (p.left != null) // left child pushed after right
                    travStack.push(p.left);// to be on the top of the stack;
            }
        }
    }
    
    public void iterativeInorder(){ //6.17
        BSTNode p = root;
        Stack travStack = new Stack();
        while (p != null) {
            while(p != null) { // stack the right child (if any)
                if (p.right != null) // and the node itself when going
                    travStack.push(p.right); // to the left;
                travStack.push(p);
                p = p.left;
            }           
            p = (BSTNode) travStack.pop();// pop a node with no left child
            while (!travStack.isEmpty() && p.right == null) {// visit it and all
                visit(p); // nodes with no right child;
                p = (BSTNode) travStack.pop();
            }
            visit(p); // visit also the first node with
            if (!travStack.isEmpty()) // a right child (if any);
                p = (BSTNode) travStack.pop();
            else p = null;
        }
    }
    
    public void iterativePostorder(){         //6.16
        BSTNode p = root;
        BSTNode q = root;
        Stack<BSTNode> travStack = new Stack<>();
        while (p != null) {
            for ( ; p.left != null; p = p.left)
                travStack.push(p);
            while (p != null && (p.right == null || p.right == q)) {
                visit(p);
                q = p;
                if (travStack.isEmpty())
                    return;
                p = travStack.pop();
            }
            travStack.push(p);
            p = p.right;
}
    }
    
    public void MorrisInorder(){         //6.20
        BSTNode p = root;
        BSTNode tmp;
        while (p != null)
            if (p.left == null) {
                visit(p);
                p = p.right;
            }
            else {
                tmp = p.left;
                while (tmp.right != null && // go to the rightmost node of
                    tmp.right != p) // the left subtree or
                    tmp = tmp.right; // to the temporary parent of p;
                if (tmp.right == null) {// if 'true' rightmost node was
                    tmp.right = p; // reached, make it a temporary
                    p = p.left; // parent of the current root,
                }
                else { // else a temporary parent has been
                    visit(p); // found; visit node p and then cut
                    tmp.right = null; // the right pointer of the current
                    p = p.right; // parent, whereby it ceases to be
                } // a parent;
            }
    }
    //Inserting a node
    public void insert(int el){         //6.23
        BSTNode p = root;
        BSTNode prev = null;
        while (p != null) { // find a place for inserting new node;
            prev = p;
            if (p.key < el)
                p = p.right;
            else p = p.left;
        }
        if (root == null) // tree is empty;
            root = new BSTNode(el);
        else if (prev.key < el)
            prev.right = new BSTNode(el);
        else prev.left = new BSTNode(el);
    }
    //Deleting a node and merging
    public void deleteByMerging(int el){ //6.29
        BSTNode tmp;
        BSTNode node, p = root, prev = null;
        while (p != null && p.key != el) { // find the node p
            prev = p; // with element el;
            if (p.key < el)
                p = p.right;
            else p = p.left;
        }
        node = p;
        if (p != null && p.key == el) {
            if (node.right == null) // node has no right child: its left
                node = node.left; // child (if any) is attached to its 
                                   // parent;
            else if (node.left == null) // node has no left child: its right
                node = node.right; // child is attached to its parent;
            else { // be ready for merging subtrees;
                tmp = node.left; // 1. move left
                while (tmp.right != null) // 2. and then right as far as
                    tmp = tmp.right; // possible;
                tmp.right = node.right;// 3. establish the link between
                                             // the rightmost node of the left
                                            // subtree and the right subtree;
                node = node.left; // 4.
            }
            if (p == root)
                root = node;
            else if (prev.left == p)
                prev.left = node;
            else prev.right = node; // 5.
        }
        else if (root != null)
            System.out.println("key " + el + " is not in the tree");
        else System.out.println("the tree is empty");
    }
    //Deleting the node and copying
    public void deleteByCopying(int el){ //6.32
        BSTNode node;
        BSTNode p = root, prev = null;
        while (p != null && p.key != el) { // find the node p
            prev = p; // with element el;
            if (p.key < el)
                p = p.right;
            else p = p.left;
        }
        node = p;
        if (p != null && p.key == el) {
            if (node.right == null) // node has no right child;
                node = node.left;
            else if (node.left == null) // no left child for node;
                node = node.right;
            else {
                BSTNode tmp = node.left; // node has both children;
                BSTNode previous = node; // 1.
                while (tmp.right != null) { // 2. find the rightmost
                    previous = tmp; // position in the
                    tmp = tmp.right; // left subtree of node;
                }
                node.key = tmp.key; // 3. overwrite the reference 
                                    // of the key being deleted;
                if (previous == node) // if node's left child's
                    previous.left = tmp.left; // right subtree is null;
                else previous.right = tmp.left; // 4.
            }
            if (p == root)
                root = node;
            else if (prev.left == p)
                prev.left = node;
            else prev.right = node;
        }
        else if (root != null)
            System.out.println("key " + el + " is not in the tree");
        else System.out.println("the tree is empty");
    }
    //Evens out the level of the tree
    public void balance (int date[], int first, int last){ //Section 6.7
        if (first <= last) {
            int middle = (first + last)/2;
            insert(date[middle]);
            balance(date,first,middle-1);
            balance(date,middle+1,last);
        }
    }
    //Counts all leaf in a binary tree
    public void getLeafCount() {
        System.out.println(getLeafCount(root));
    }
    static int getLeafCount(BSTNode p){
        if(p == null)
            return 0;
        else if (p.left != null || p.right != null)
            return getLeafCount(p.left) + getLeafCount(p.right);
        else
            return 1;
        
    }
    //Finds the height of the tree
    public void findHeight(){
        System.out.println(findHeight(root));
    }
    static int findHeight(BSTNode p){
        if (p == null)
            return -1;
    return 1 + Math.max(findHeight(p.left), findHeight(p.right));      
    }
    //Counts the non-terminal nodes
    public void nonLeaf(){
        System.out.println(nonLeaf(root));
    }
    static int nonLeaf(BSTNode p){
        // If root is null then it is not a non-terminal node
        if (p == null || (p.left == null && p.right == null))
            return 0;
    return 1 + nonLeaf(p.left) + nonLeaf(p.right); // If root is not null & a child is not null
    }
    //Gets the internal path length of the tree
    public void IPL(){
        System.out.println(IPL(root, 0));
    }
    static int IPL(BSTNode p, int depth){
        if (p == null)
            return 0;     
    return depth + IPL(p.left, depth + 1) + IPL(p.right, depth + 1);    
    }
    //Gets the average depth of the tree
    public void getAverageDepth(){
        int[] temp = getAverageDepth(root,0,0);
        int totalDepth = temp[0];
        int nodeCnt = temp[1];
        
        if(nodeCnt == 0){
            System.out.print("0");
        }
        else{
            System.out.print(totalDepth / nodeCnt);
        }
        
    }
    static int[] getAverageDepth(BSTNode p, int depth, int cnt){
        if (p == null)
            return new int[]{0,0};
        int[] left = getAverageDepth(p.left, depth + 1, cnt);
        int[] right = getAverageDepth(p.right, depth + 1, cnt);
        int totalDepth = depth + left[0] + right[0];
        int nodeCnt = 1 + left[1] + right[1];
    
    return new int[]{totalDepth, nodeCnt};
    }
    //Counts the number of nodes
    protected static int countNumNode(BSTNode p){
        if (p == null)
            return 0;
        return(1 + countNumNode(p.left)+countNumNode(p.right));
    }
    //Checks if it is a complete binary tree
    protected static boolean isCompleteBinaryTree(BSTNode p, int index, int numNode){
        if (p.left == null && p.right == null)
            return true;
        if (index >= numNode)
            return false;
    return (isCompleteBinaryTree(p.left, 2 * index + 1, numNode) && isCompleteBinaryTree(p.right, 2 * index + 2, numNode));
    }
    //Checks if it is a decision tree
    protected static boolean isDecisionTree(BSTNode p){
        if (p.left != null && p.right != null)
            return true;
        if (p.left == null && p.right == null)
            return true;
        if (p.left == null && p.right !=null)
            return false;
        if (p.left != null && p.right ==null)
            return false;
    return (isDecisionTree(p.left)&&(isDecisionTree(p.right)));
    }
}
