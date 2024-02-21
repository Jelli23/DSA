import java.util.Scanner;

public class Co_Exercise4 {
   public static void main(String[] args){
       Scanner scan = new Scanner(System.in);
       
    System.out.println("Enter the center and point of a circle: ");
    double xOne = scan.nextDouble();
    double xTwo = scan.nextDouble();
    double yOne = scan.nextDouble();
    double yTwo = scan.nextDouble();
    
    double d = distance(xOne, xTwo, yOne, yTwo);
    double r = radius(xOne, xTwo, yOne, yTwo);
    double circ = circumference(r);
    double a = area(r);
    
    System.out.printf("Distance: %.2f, Radius: %.2f, Circumference: %.2f, Area: %.2f", d,r,circ,a);
    scan.close();
   }
      static double distance(double xOne, double xTwo, double yOne, double yTwo){
       double sqX;
       double sqY;
       double dist;
        sqX = Math.pow((xOne-xTwo), 2);
        sqY = Math.pow((yOne-yTwo), 2);
        dist = Math.sqrt(sqX + sqY);
        return dist;
    }
      static double radius(double xOne, double xTwo, double yOne, double yTwo){
          double rad;
          rad = distance(xOne, xTwo, yOne, yTwo);
          return rad;
      }
      static double circumference(double rad){
         final double pi = 3.1416;
         double cir;
         cir = 2*pi*rad;
         return cir;
      }
      static double area(double rad){
         final double pi = 3.1416;
         double a;
         a = pi*Math.pow(rad,2);
         return a;
      }
}
