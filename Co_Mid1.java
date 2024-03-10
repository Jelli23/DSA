package Exers;

import java.util.*;
import java.io.*;

public class Co_Mid1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("grades.txt"));
        int[] grade = new int[1];
        int counter = 0;
        Student[] list = new Student[40];
        int[] bAverage = new int[40];
        int cont = 0;   
        int average = cont/list.length;

        while(in.hasNext()){
            String Sname = in.nextLine();
            String grades = in.nextLine();
            int gr = Integer.valueOf(grades);
            list[counter] = new Student(Sname, gr);
            counter++;
        }
        in.close();
        
        int hGrade = list[counter].getGrade();
        String hName = list[counter].getName();

        for (int i = 0; i < list.length; i++){
            cont = cont + list[i].getGrade();

            if (list[i].getGrade() > hGrade){
                hGrade = list[i].getGrade();
                hName = list[i].getName();
            }
            
        }
        
        for (int ind = 0; ind < list.length; ind++){
            if (list[ind].getGrade() < average){
                for (int i = 0; i < bAverage.length; i++){
                    bAverage[i] = i;
                }
                
            }
        }

        System.out.println("Average: " + average);
        System.out.println("---------------------------");
        System.out.println("Below Average: ");
        for (int i = 0; i < average; i++){
            if (average < list[i].getGrade()){
                System.out.println(list[i].getName() + "Bawi next lyf.");
            }
        }
        System.out.println("Highest Scorer:" + hName);
        System.out.println("Highest Score:" + hGrade);
    }
}

class Student {
    String name;
    int grade;

    public Student(String name, int grade){
        this.name = name;
        this.grade = grade;
    }

    public String getName(){
        return name;
    }

    public int getGrade(){
        return grade;
    }

}
