package SecondPackage;
import FirstPackage.*;
class Student extends School
{
    public Student(String name,int age,int mark,char section)
    {
        super(name, age, mark, section);
    }
    public void show()
    {
        System.out.println("Name = "+name);
        System.out.println("Age = "+age);
//        System.out.println("Mark = "+mark);
//        System.out.println("Section = "+section);
//        System.out.println("Mark = "+super.getMark());
//        System.out.println("Section = "+super.getSection());
    }
}
class main
{
    public static void main(String[] args)
    {
        Student obj=new Student("Ajay",23,412,'A');
        obj.show();
    }
}
