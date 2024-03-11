package GradedExer;

public class Student {
    String lastname, firstname, studentid, course;
    char gender;
    int yearlevel;    
    
    public Student(String id, String ln, String fn, char g, String cors, int yl) {
    	studentid = id;
        lastname = ln;
    	firstname = fn;
        gender = g;
    	course = cors;
    	yearlevel = yl;
    }
    
    public String display() {    	
        return String.format("ID: %-8s  Name: %-20s  Sex: %c  Course: %-8s  Year: %d\n", studentid, (lastname + ", " + firstname), gender, course, yearlevel );
    }
    
    public void setGender(char gender){
        this.gender = gender;
    }
    
    public char getGender(){
        return gender;
    }
    
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    
    public String getLastname(){
        return lastname;
    }
    
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    
    public String getFirstname() {
        return firstname;
    }
    
    public void setStudentId(String studentid){
        this.studentid = studentid;
    }
    
    public String getStudentId(){
        return studentid;
    }
    
    public void setCourse(String course){
        this.course = course;
    }
    
    public String getCourse(){
        return course;
    }
    
    public void setYearLevel(int yearlevel){
        this.yearlevel = yearlevel;
    }
    
    public int getYearLevel(){
        return yearlevel;
    }
}