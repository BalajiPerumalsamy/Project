class UniqueNumber
{
    public static void main(String[] args)
    {
        int[] number={2,2,3,4,5,6,6,7,8,10,10,2,6,9};
        int length=number.length;
        System.out.print("Unique Number = ");
        for(int i=0;i<length;i++)
        {
            boolean unique=true;
            for(int j=1;j<length;j++)
            {
                if(i!=j && number[i]==number[j])
                {
                    unique=false;
                    break;
                }
            }
            if(unique)
            {
                System.out.print(number[i]+" ");
            }
        }
    }
}

