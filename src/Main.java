import java.util.concurrent.atomic.AtomicInteger;
class Main
{
    public static void main(String[] args)
    {
        int totalNumber=1000000;
        int totalThread=10;
        int printNumber=totalNumber/totalThread;
        PrintNumbers[] arr=new PrintNumbers[totalThread];
        AtomicInteger obj=new AtomicInteger();
        for(int i=0;i<totalThread;i++)
        {
            int start=i*printNumber+1;
            int end=(i+1)*printNumber;
            PrintNumbers t1=new PrintNumbers(start,end,obj,"Thread - "+(i+1));
            arr[i]=t1;
            arr[i].start();
        }
    }
}
class PrintNumbers extends Thread
{
    int start;
    int end;
    AtomicInteger rank;
    public PrintNumbers(int start,int end,AtomicInteger rank,String name)
    {
        super(name);
        this.start=start;
        this.end=end;
        this.rank=rank;
    }
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+" Started");
        for(int i=start;i<=end;i++)
        {
            System.out.println(Thread.currentThread().getName()+" Print Number = "+i);
        }
        System.out.println(Thread.currentThread().getName()+" completed");
        int currentRank=rank.incrementAndGet();
        System.out.println(Thread.currentThread().getName()+" Completed Thread Rank = "+currentRank);
    }
}








