/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PrefiProgExer;
import java.util.*;
import java.io.*;
/**
 *
 * @author jbjco
 */
public class BSTMain {
    public static void main(String args[])throws FileNotFoundException{
        Scanner read = new Scanner(new FileReader("bst.txt")); //Reads file "bst.txt"
        BST bst = new BST();
        int temp;
        int ind = 0;
        int nodeCnt = bst.countNumNode(bst.root);
        
        //Inserts all values in bst
        while (read.hasNext()){ 
            temp = read.nextInt();
            bst.insert(temp);
        }
        //1
        System.out.println("Height of the tree:");
        bst.findHeight(); //Method that gets the height of the Binary Tree
        
        //2
        System.out.println("\n\nLeaf count:");
        bst.getLeafCount(); //Method that counts all leaf in the Binary Tree
        
        //3
        System.out.println("\n\nNon-terminal node count:");
        bst.nonLeaf(); //Method that counts all non-terminal nodes
        
        //4
        System.out.println("\n\nInternal Path Length of the tree:");
        bst.IPL(); //Method that sums up all the values of the nodes
        
        //5
        System.out.println("\n\nAverage depth or path length of the tree:");
        //bst.getAverageDepth(); //Method that gets the average depth of the tree
        
        //6
        System.out.println("\n\nChecks whether the tree is a complete binary:");
        if (bst.isCompleteBinaryTree(bst.root, ind, nodeCnt))
            System.out.println("The tree is a complete binary tree.");
        else
            System.out.println("The tree is not a complete binary tree.");

        //7
       System.out.println("\n\nChecks whether the tree is a decision tree:");
        if (bst.isDecisionTree(bst.root))
            System.out.print("The tree is a decision tree.");
        else
            System.out.print("The tree is not a decision tree.");
        //Calls postorder method & gives an output
}
