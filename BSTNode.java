public class BSTNode {
    protected int key;
    protected BSTNode left, right;
    public BSTNode() {
        left = right = null;
    }
    
    public BSTNode(int el) {
        this(el,null,null);
    }
    
    public BSTNode(int el, BSTNode lt, BSTNode rt) {
        key = el; left = lt; right = rt;
    }
}
