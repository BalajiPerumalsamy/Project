package FirstPackage;

public class School
{
    public String name;
    protected int age;
    private int mark;
    char section;
    public School(String name,int age,int mark,char section)
    {
        this.name=name;
        this.age=age;
        this.mark=mark;
        this.section=section;
    }
    protected void display()
    {
        System.out.println("Name = "+name);
        System.out.println("Age = "+age);
        System.out.println("Mark = "+mark);
        System.out.println("Section = "+section);
    }
//   public int getMark()
//    {
//        return mark;
//    }
//    public char getSection()
//    {
//        return section;
//    }
}