import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;
class SelfIntro
{
    public static void main(String[] args)
    {
        AddandRemoveThread t1=new AddandRemoveThread();
        t1.start();
    }
}
abstract class SelfIntroduction
{
    private String[] specialCharacters={"!","@","#","$","%","^","&","(",")","_","+","-","*","~","/","=","≠","≥","≤","±","≈","∑","∫","∆","∏", "∂","°","√","∞","₹","€","£","¥","¢","©","®","™","‰","π","µ","ℓ", "¶","₽","₩","₪","฿","¤","§","←","↑","→","↓","↔","↕","⇨","⇦","⇧", "⇩","⇄","⇅","╔","╗","╚","╝","═","║","&&","||","==","!=",">","<",">=","<=","|","^","~","<<",">>","{","}","[","]",";",".",",",":","\"","\'","?","::","=>","`","∧","∨","∩","∪","∈","∉","∅","∀","∃", "∴","∵"};
    abstract String addSpecialCharacter(String selfIntro,String[] specialCharacters);
    abstract String removeSpecialCharacter(String selfIntro,String[] specialCharacters);
    public String[] getSpecialCharacters()
    {
        return specialCharacters;
    }
}
class AddandRemoveCharacter extends SelfIntroduction
{
    String selfIntro="First of all thank you for giving me this opportunity. Let me tell about myself. I am Balaji. I am from Tamil Nadu. I have completed B.Com (CA) from Kaamadhenu Arts and Science College and I completed MCA from Excel Engineering College. My MCA project was Decoding and Processing Digital Video and Audio Streaming by Bit Using Programming Association Tables. My short time goal is get a job in reputed company. My long time goal is achieve a good position where I can build my carrear and help the organization too. My strength is self motivated and workaholic person. My hobbies are bike riding and listening to music. Thats all about me.";
    public String addSpecialCharacter(String selfIntro,String[] specialCharacters)
    {
        StringBuffer sb=new StringBuffer();
        Random obj=new Random();
        for(int i=0;i<selfIntro.length();i++)
        {
            char intro=selfIntro.charAt(i);
            sb.append(intro);
            if(intro==' ')
            {
                int random=obj.nextInt(specialCharacters.length);
                String randomChar=specialCharacters[random];
                sb.append(randomChar);
            }
        }
        return sb.toString();
    }
    public String removeSpecialCharacter(String result,String[] specialCharacters)
    {
        StringBuffer obj=new StringBuffer(result);
        for(int i=0;i<specialCharacters.length;i++)
        {
            int start;
            while((start=obj.indexOf(specialCharacters[i]))!=-1)
            {
                int end=start+specialCharacters[i].length();
                obj.delete(start,end);
            }
        }
        return obj.toString().replaceAll(" +"," ");
    }
}
class AddandRemoveThread extends Thread
{
    AddandRemoveCharacter obj=new AddandRemoveCharacter();
    String intro=obj.selfIntro;
    String[] characters=obj.getSpecialCharacters();
    String finalResult;
    public void run()
    {
        String result=obj.addSpecialCharacter(intro,characters);
        System.out.println("Add Special characters  = "+result);
        finalResult=obj.removeSpecialCharacter(result,characters);
        Scanner scanner=new Scanner(System.in);
        System.out.print("Set the input value = ");
        int size=scanner.nextInt();
        String[] str=finalResult.split(" ");
        LinkedHashMap<Integer,String> map=new LinkedHashMap<>();
        StringBuffer addString=new StringBuffer();
        for(int i=0;i<str.length;i++)
        {
            addString.append(str[i]);
            addString.append(" ");
            map.put(i+1,addString.toString());
        }
        if(size>=1&&size<=map.size())
        {
            System.out.print("Remove Special character and print each Element = ");
            System.out.println(map.get(size)+" ");
        }
        else
        {
            System.out.println("Invalid user input");
        }
    }
}
