/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milestone2;
/**
 *
 * @author Samuel
 */
import java.io.IOException;
import java.util.*;

public class Main
{
    
    private static final String CPATH = "C:\\Users\\Samuel\\Documents"
          + "\\NetBeansProjects\\Rental System\\src\\milestone2\\Costumers.txt";
    private static final String APATH = "C:\\Users\\Samuel\\Documents"
      + "\\NetBeansProjects\\Rental System\\src\\milestone2\\Accomodations.txt";
    
    private static FileRead read = new FileRead();
    private static Shop shop;
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String [] args) throws IOException
    {
        shop = new Shop(read.readCostumer(CPATH),
                        read.readAccomodation(APATH));
        
        //shop.printAll();
        menuA();
    }
    
    public static void menuA()
    {
        int c;
        boolean goOut = false;
        
        
        do
        {
            System.out.print("1. State of the properties\n2. Rent a property\n"
                            + "3. See applications from a costumer\n"
                            + "4. Consult costumer\n5. Consult discount\n"
                            + "6. Consult applications for a property\n"
                            + "7. Exit\n");
        
            c = menuController();
            
            switch(c)
            {
                case 1:
                    showRent();
                break;
                
                case 2:
                    System.out.println(rentProperties());
                break;
                
                case 3:
                    System.out.println(seeApplications());
                break;
                
                case 4:
                    System.out.println(consultCostumer());
                break;
                
                case 5:
                    System.out.println(consultDiscount());
                break;
                
                case 6:
                    System.out.println(consultPropertyApp());
                break;
                
                case 7:
                    goOut = true;
                break;
                
                default:
                    System.out.println("Please choose a correct option.");
                break;
            }
        }
        while(!goOut);
            System.out.println("Bye");
    }
    
    
    public static int menuController()
    {
        while(!sc.hasNextInt())
        {
            System.out.println("The options can only be integers.");
            System.out.println("Try again:");
            sc.next();
        }
        int n = sc.nextInt();
        return n;
    }
    
    public static boolean controlBoolean()
    {
        boolean young = false;
        boolean exit = false;
        do
        {
            System.out.println("Do you have young card? (Y/N)");
            char n = sc.next().charAt(0);
            
            switch(n)
            {
                case 'y':
                case 'Y':
                    young = true;
                    exit = true;
                break;
                
                case 'n':
                case 'N':
                    young = false;
                    exit = true;
                break;
                
                default:
                    System.out.println("Wrong option. Please put Y or N.");
                break;
            }
        }
        while(!exit);
        
        return young;
    }
    
    public static void showRent()
    {
        int i;
        System.out.print("\nFor sale: ");
        
        for(i=0; i<shop.getAccomodation().length;i++)
        {
            if(shop.getAccomodation()[i].getState().equals("venta")) 
                System.out.printf("%d ",shop.getAccomodation()[i].getId());
        }
        System.out.println("");
        
        System.out.print("For rent: ");
        
        for(i=0; i<shop.getAccomodation().length;i++)
        {
            if(shop.getAccomodation()[i].getState().equals("alquiler")) 
                System.out.printf("%d ",shop.getAccomodation()[i].getId());
            
        }
        System.out.println("\n");
    }
    
    public static String rentProperties()
    {
        String s;
        String data = "";
        
        System.out.println("Please, introduce your name in order to see"
                            + " if you are client or not:");
        s = sc.next();
        
        if(isClient(s))
        {
            System.out.println("You are client");
        }
        else
        {
            System.out.println("You are not client");
            System.out.println("To rent a property we need your data:");
            
            System.out.print("Id: ");
            String id = sc.next();
            
            System.out.print("creditCard: ");
            float creditCard = sc.nextFloat();
            boolean youngCard = controlBoolean();
            
            Costumer new1 = new Costumer(id,s,creditCard,youngCard);
            
        }
        return data;
    }
    
    public static String seeApplications()
    {
      int c,i;
        String data = "";
        
        costumerArray();
        
        c = menuController();
        c--;
        if(c < 0 || c > shop.getCostumer().length)
        {
            data += "Incorrect option.";
        }
        else
        {
            data += shop.getCostumer()[c].getName()+"has "+
                    shop.getCostumer()[c].getNumberOfApps()+"\n";
            for(i=0;i<shop.getCostumer()[c].getApp().length;i++)
            {
                data += Integer.toString(i)+" - "+
                        shop.getCostumer()[c].getApp()[i].toString()+"\n";
            }
            
        }
        
        return data;  
    }
    
    public static String consultCostumer()
    {
        int c;
        String data = "";
       
        costumerArray();
        
        c = menuController();
        c--;
        if(c < 0 || c > shop.getCostumer().length)
        {
            data += "Incorrect option.";
        }
        else
        {
            data += shop.getCostumer()[c].getName()+" ";
            
            if(shop.getCostumer()[c].isHabitual())
            {
                data += "is habitual.\n";
            }
            else
            {
                data += "is not habitual.\n";
            }
        }
        
        return data;
    }
    
    public static String consultDiscount()
    {
        int c;
        String data = "";
        
        costumerArray();
        
        c = menuController();
        c--;
        if(c < 0 || c > shop.getCostumer().length)
        {
            data += "Incorrect option.";
        }
        else
        {
            data += shop.getCostumer()[c].getName()+" has a discount of: "+
                    Double.toString(shop.getCostumer()[c].getDiscount()*100)
                    +"%\n";
            
        }
        
        return data;
    }
    
    public static String consultPropertyApp()
    {
        int c, i, j;
        String data = "";
        
        propertiesArray();
        
        c = menuController();
        System.out.printf("Applications made for Accomodarion with id %d:\n",c);
        c--;
       
        for(i=0;i<shop.getCostumer().length;i++)
        {
            for(j=0;j<shop.getCostumer()[i].getApp().length;i++){
                if(shop.getCostumer()[i].getApp()[j].getAcc().getId() == c)
                {
                    data += shop.getCostumer()[i].getName()
                            +" - Time for rent: "+
                            shop.getCostumer()[i].getApp()[j].getRentTime();
                }
                }
            }
        return data;
    }
    
    public static void costumerArray()
    {
        int i;
        System.out.println("\nSelect which costumer do you want to consult:");
        
        for(i=0;i<shop.getCostumer().length;i++)
        {
            System.out.printf("%d - %s\n", i+1, 
                                shop.getCostumer()[i].getName());
        }
        System.out.println("");
    }
    
    public static boolean isClient(String s)
    {
        int i;
        boolean a = false;
        
        for(i = 0; i<shop.getCostumer().length;i++)
        {
            if(shop.getCostumer()[i].getName().equals(s))
            {
                a = true;
            }
        }
        return a;
    }
    
    public static void propertiesArray()
    {
        int i;
        System.out.println("\nSelect which costumer do you want to consult:");
        
        for(i=0;i<shop.getAccomodation().length;i++)
        {
            System.out.printf("%s\n", 
                                shop.getAccomodation()[i].getId());
        }
        System.out.println("(Each number correspond to the Id of "
                                + "the property. Choose one)");
    }
    
    
}