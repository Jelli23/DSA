import java.util.*;
import java.io.*;

public class BSTMain {
    public static void main(String args[])throws FileNotFoundException{
        Scanner read = new Scanner(new FileReader("bst.txt")); //Reads file "bst.txt"
        BST bst = new BST();
        int temp;
        
        //Inserts all values in bst
        while (read.hasNext()){ 
            temp = read.nextInt();
            bst.insert(temp);
        }
        
        System.out.println("Breadth-first traversal:");
        bst.breadthFirst(); // Calls Breadth-first method & gives an output
        
        System.out.println("\n\nPre-order depth-first traversal:");
        bst.preorder(); //Calls preorder method & gives an output
        
        System.out.println("\n\nIn-order depth-first traversal:");
        bst.inorder(); //Calls inorder method & gives an output
        
        System.out.println("\n\nPost-order depth-first traversal:");
        bst.postorder(); //Calls postorder method & gives an output

    }
}
