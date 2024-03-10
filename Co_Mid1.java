import java.util.*;
import java.io.*;

public class Co_Mid1 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new FileReader("C:\\Co\\src\\co\\grades.txt"));
        ArrayList<Student> list = new ArrayList<>(); 
        int cont = 0;  
        int hGrade = list.get(0).Grade();
        String hName = list.get(0).Name();
           
        //Puts name and grade in an array
        while(in.hasNext()){
            if (list.size() <= 40){ //Gets only a max of 40 students
            String Sname = in.nextLine();
            String grades = in.nextLine();
            int gr = Integer.parseInt(grades);
            list.add(new Student(Sname, gr));
            }
            else{
                System.exit(0);
            }
        }
        in.close();
        
        //putting grades in a container ()
        for (Student i: list){
            cont = cont + i.Grade();
            //Gets the highest scorer and their grade
            if (i.Grade() > hGrade){
                hName = i.Name();
                hGrade = i.Grade();
            }
        }
        //Get the average
        int average = cont/list.size();
        
        //Output
        System.out.println("Average: " + average);
        System.out.println("---------------------------");
        System.out.println("Below Average: ");
        //People below average will get a message
        for (Student i : list){
            if (i.Grade() < average){
                System.out.println(i.Name() + "Bawi next lyf.");
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
    public String Name(){
        return name;
    }
    public int Grade(){
        return grade;
    }
}
