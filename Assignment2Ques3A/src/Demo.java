class Hello
{
    private int a=20;
    public int b=20;
    private void show()
    {
        System.out.println("this is a private method");
    }

    public void showPublic()
    {
        System.out.println("this is a public method");
    }
}

public class Demo
{
    public static void main(String args[])
    {
        Hello obj=new Hello();
      //  System.out.println(obj.a); //Compile Time Error, you can't access private data
     //   obj.show();   //Compile Time Error, you can't access private methods
        System.out.println(obj.b);
        obj.showPublic();
    }
}