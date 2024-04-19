/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PrefiProgExer;

/**
 *
 * @author jbjco
 */
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
