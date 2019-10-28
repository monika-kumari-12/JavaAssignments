public class Main{
    
    
    public static void main (String[] args){
        square sq= new square();
        rectangle rg = new rectangle();
        circle cr=new circle();
     
        sq.area();
        sq.perimeter();
        rg.area();
        rg.perimeter();
        cr.area();
       cr.circumference();
    }
}
class figure {
        int length=10;
      
    }
    
    class square extends figure {
        void area()
                {
        int ar=length*length;
        System.out.println("The area of the square is: "+ar);
                }
        
        void perimeter(){
            int per=4*length;
        
        System.out.println("The perimeter of the square is: "+per);
        }
        
    }
    
    class rectangle extends figure {
       int breadth=20;
        void area(){
            
        int ar=length*breadth;
        System.out.println("The area of the reactangle is: "+ar);
        }
        
        void perimeter(){
        int per= 2*length+ 2*breadth;
        
        System.out.println("The perimeter of the rectangle is: "+per);
        }
     }
    
    class circle extends figure {
        void area(){
        double ar=3.14*length*length;
       
        System.out.println("The area of the circle is: "+ar);
        }
        void circumference(){
             double circum = 2*3.14*length;
        System.out.println("The circumference of the circle is: "+circum);
        }
    }