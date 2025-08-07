//Delivery Estimation System Based on Distance
import java.util.Scanner;

class InterfaceExample
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter item to deliver = ");
        String item=scanner.nextLine();

        System.out.println("Enter delivery distance (in km)  = ");
        double distance=scanner.nextDouble();

        DeliveryService delivery;

        if(distance<=100)
        {
            System.out.println("Delivery by Local :");
            delivery=new LocalDelivery();
        }
        else
        {
            System.out.println("Delivery by Courier :");
            delivery=new CourierDelivery();
        }
        delivery.deliver(item);
        delivery.estimateDeliveryTime(distance);
    }
}
interface DeliveryService
{
    void deliver(String item);
    void estimateDeliveryTime(double distance);
}
class CourierDelivery implements DeliveryService
{
    public void deliver(String item)
    {
        System.out.println("Delivering " + item + " via Courier Delivery.");
    }
    public void estimateDeliveryTime(double distance)
    {
        double speed = 100;
        int days = (int)Math.ceil(distance / speed);
        System.out.println("Estimated delivery time: " + days + " day(s)");
    }
}
class LocalDelivery implements DeliveryService
{
    public void deliver(String item)
    {
        System.out.println("Delivering " + item + " via Local Delivery.");
    }
    public void estimateDeliveryTime(double distance)
    {
        double speed = 150;
        int days = (int)Math.ceil(distance / speed);
        System.out.println("Estimated delivery time: " + days + " day(s)");
    }
}