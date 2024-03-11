package GradedExer;

/**
 *
 * @author jbjco
 */

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner read = new Scanner(System.in);
        Scanner in = new Scanner(new FileReader("student.txt"));
        ArrayList<Student> list = new ArrayList<>(); 
        
        while(in.hasNext()){
             //Gets only a max of 40 student
            String lname = in.nextLine();
            String fname = in.nextLine();
            String id = in.nextLine();
            String course = in.nextLine();
            String gender = in.nextLine();
            char g = gender.charAt(0);
            String yrlvl = in.nextLine();
            int yLvl = Integer.parseInt(yrlvl);
            list.add(new Student(lname, fname, id, course, g, yLvl));
        }
        
        System.out.println("Choose the number from 1 to 4 that you want it to be sorted by: ");
        System.out.println("1: Name \n2. Course \n3. ID Number \n4. Exit: ");   
        
        list.sort(new NameComparator());
        printList(list); 
    }
    public static void printList(ArrayList<Student> data){
        Student temp;
        for (int i = 0; i < data.size(); i++){
            temp = data.get(i);
            System.out.println(temp.toString());
        }
    }   
}
class NameComparator implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getLastname().compareTo(s2.getLastname()) != 0)
            return s1.getLastname().compareTo(s2.getLastname());
        else
            return s1.getLastname().compareTo(s2.getLastname());
    }
}
