import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        Scanner read = new Scanner(new FileReader("student.txt"));
        ArrayList<Student> list = new ArrayList<>(); 
        
        //Puts the read data in array
        while(read.hasNext()){
            String idN = read.nextLine();
            String lname = read.nextLine();
            String fname = read.nextLine();
            char gender = read.nextLine().charAt(0);
            String course = read.nextLine();
            String yrlvl = read.nextLine();
            int yLvl = Integer.parseInt(yrlvl);
            list.add(new Student(idN,lname,fname,gender,course,yLvl));
        }
        
        System.out.println("Choose the number that you want it to be sorted by: ");
        System.out.println("1: Name \n2. Course \n3. ID Number \n4. Exit");   
        
        //Gets user input and puts into the switch case
        int inp = in.nextInt();
        switch(inp){
            case 1: //Sort by (lastname, firstname)
                list.sort(new NameComparator());
                printList(list);
                break;
            case 2: //Sort by (course)
                list.sort(new CourseComparator());
                printList(list);
                break;
            case 3: //Sort by (studentID)
                list.sort(new IdComparator());
                printList(list);
                break;
            case 4: //Exit program
                System.exit(0);    
        }

    }
    //Prints the ArrayList
    public static void printList(ArrayList<Student> data){
        Student temp;
        for (int i = 0; i < data.size(); i++){
            temp = data.get(i);
            System.out.println(temp.display());
        }
    }   
}
//Sort by (lastname, firstname)
class NameComparator implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.lastname.compareTo(s2.lastname) != 0)
            return s1.lastname.compareTo(s2.lastname);
        else
            return s1.firstname.compareTo(s2.firstname);
    }
}
//Sort by (course)
class CourseComparator implements Comparator<Student>{
    @Override
    public int compare(Student c1, Student c2) {
        return c1.course.compareTo(c2.course);
    }
}
//Sort by (studentID)
class IdComparator implements Comparator<Student>{
    @Override
    public int compare(Student id1, Student id2) {
        return id1.studentid.compareTo(id2.studentid);
    }
}
