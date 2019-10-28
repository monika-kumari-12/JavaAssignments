class GFG {


    public static int sum(int a, int b)
    {
        return a + b;
    }


    public int sum1(int a, int b)
    {
        return a + b;
    }
}

class Main {
    public static void main(String[] args)
    {
        int n = 3, m = 6;

        // call the static method
        int s = GFG.sum(n, m);

        System.out.println("(Static)sum is = " + s);


        //call the non static method
        GFG g = new GFG();
        int s1 = g.sum1(n, m);
        // call the non-static method

        System.out.print("(Non static)sum is = " + s1);
    }
}