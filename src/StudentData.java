import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class StudentData
{
    public static void main(String[] args)
    {
        String location ="Coimbatore";
        System.out.println("Name = "+location);
        String value="student name is abcd and his mark is English is 56 and his mark in Tamil is 66 and his mark in maths is 77 and his mark in science is 58 and his marks in social is 50 and the next student name is efgh and his mark is English is 58 and his mark in Tamil is 45 and his mark in maths is 90 and his mark in science is 70 and his marks in social is 67 and the next student name is ijkl and his mark is English is 56 and his mark in Tamil is 66 and his mark in maths is 77 and his mark in science is 58 and his marks in social is 94 and the next student name is lmno and his mark is English is 44 and his mark in Tamil is 66 and his mark in maths is 77 and his mark in science is 72 and his marks in social is 62 and the next student name is pqrs and his mark is English is 56 and his mark in Tamil is 74 and his mark in maths is 90 and his mark in science is 58 and his marks in social is 50 and the next student name is tuv and his mark is English is 84 and his mark in Tamil is 66 and his mark in maths is 78 and his mark in science is 98 and his marks in social is 50 and the next student name is wxyz and his mark is English is 71 and his mark in Tamil is 66 and his mark in maths is 81 and his mark in science is 63 and his marks in social is 59 and the next student name is ijkl and his mark is English is 56 and his mark in Tamil is 66 and his mark in maths is 77 and his mark in science is 58 and his marks in social is 50";
        String[] studentData=value.split("and the next");
        Students obj=new Students();
        ArrayList<StudentDetails>result=obj.extractNameandRank(studentData);

        NameSort name=new NameSort();
        RankSort rank=new RankSort();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sorting option:");
        System.out.println("Sort by Name");
        System.out.println("Sort by Rank");
        String choice = scanner.nextLine();

        if(choice.equals("Name"))
        {
            System.out.println("Sorted by Name:");
            result.sort(name);
        }
        else if(choice.equals("Rank"))
        {
            System.out.println("Sorted by Rank:");
            result.sort(rank);
        }
        else
        {
            System.out.println("Invalid choice!");
            return;
        }
        for(int i=0;i<result.size();i++)
        {
            System.out.println(result.get(i));
        }
    }
}
class StudentDetails
{
    String StudentName;
    int totalMark;
    int rank=0;
    public StudentDetails(String StudentName,int totalMark)
    {
        this.StudentName=StudentName;
        this.totalMark=totalMark;
    }
    public String getName()
    {
        return StudentName;
    }
    public int getTotalMark()
    {
        return totalMark;
    }
    public void setRank(int rank)
    {
        this.rank = rank;
    }
    public int getRank()
    {
        return rank;
    }

    public String toString()
    {
        if(rank!=0)
        {
            return "Name ="+StudentName+"\tTotalMark ="+totalMark+"\tRank ="+rank;
        }
        else
        {
            return "Name ="+StudentName+"\tTotalMark ="+totalMark+"\tRank ="+"Fail";
        }

    }
}
class Students
{
    ArrayList<StudentDetails> nameandmark=new ArrayList<>();
    ArrayList<StudentDetails> passStudents=new ArrayList<>();
    public ArrayList<StudentDetails> extractNameandRank(String[] studentData)
    {
        for (int i=0;i<studentData.length;i++)
        {
            String student=studentData[i];
            int start=student.indexOf("name is")+7;
            int end=student.indexOf("and his");
            String name=student.substring(start, end).trim();

            int english=extractMark(student, "English");
            int tamil=extractMark(student, "Tamil");
            int maths=extractMark(student, "maths");
            int science=extractMark(student, "science");
            int social=extractMark(student, "social");

            if(isPass(english,tamil,maths,science,social))
            {
                int passTotalMarks=english+tamil+maths+science+social;
                StudentDetails obj=new StudentDetails(name,passTotalMarks);
                nameandmark.add(obj);
                passStudents.add(obj);
            }
            else
            {
                int failTotalMarks=english+tamil+maths+science+social;
                StudentDetails obj1=new StudentDetails(name,failTotalMarks);
                nameandmark.add(obj1);
            }
        }
        for(int i=0;i<passStudents.size()-1;i++)
        {
            for(int j=i+1;j<passStudents.size();j++)
            {
                if(passStudents.get(i).getTotalMark()<passStudents.get(j).getTotalMark())
                {
                    StudentDetails temp=passStudents.get(i);
                    passStudents.set(i,passStudents.get(j));
                    passStudents.set(j,temp);
                }
            }
        }
        passStudents.get(0).setRank(1);
        for(int k=1;k<passStudents.size();k++)
        {
            if(passStudents.get(k).getTotalMark()==passStudents.get(k-1).getTotalMark())
            {
                passStudents.get(k).rank=passStudents.get(k-1).rank;
            }
            else
            {
                passStudents.get(k).setRank(k+1);
            }
        }
        return nameandmark;
    }
    public int extractMark(String student, String subject)
    {
        int startIndex=student.indexOf(subject)+subject.length()+3;
        int endIndex=student.indexOf("and",startIndex);
        if (endIndex==-1)
        {
            endIndex=student.length();
        }
        String markStr=student.substring(startIndex,endIndex).trim();
        try
        {
            return Integer.parseInt(markStr);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Invalid marks for "+subject+": "+markStr);
            return 0;
        }
    }
    public boolean isPass(int english,int tamil,int maths,int science,int social)
    {
        return (english>=35&&tamil>=35&&maths>=35&&science>=35&&social>=35);
    }
}
class NameSort implements Comparator<StudentDetails>
{
    public int compare(StudentDetails obj1,StudentDetails obj2)
    {
        return obj1.getName().compareTo(obj2.getName());
    }
}
class RankSort implements Comparator<StudentDetails>
{
    public int compare(StudentDetails obj1,StudentDetails obj2)
    {
        return obj1.getRank()-obj2.getRank();
    }
}