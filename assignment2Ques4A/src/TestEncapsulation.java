public class TestEncapsulation
{
    public static void main (String[] args)
    {
        Encapsulate obj = new Encapsulate();


        obj.setName("Monika");
        obj.setAge(24);
        obj.setRoll(05);


        System.out.println("Student's name: " + obj.getName());
        System.out.println("Student's age: " + obj.getAge());
        System.out.println("Student's roll: " + obj.getRoll());

        // Direct access of geekRoll is not possible
        // due to encapsulation
        // System.out.println("Geek's roll: " + obj.geekName);
    }
}