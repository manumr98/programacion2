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
public class Costumer
{
    private String id;
    private String name;
    private float creditCard;
    private double discount;
    private int numberOfApps;
    private boolean youngCard;
    private Application [] app = new Application[10];
    
    public Costumer(String id, String name, float creditCard, boolean youngCard)
    {
        this.id = id;
        this.name = name;
        this.creditCard = creditCard;
        this.youngCard = youngCard;
        numberOfApps = 0;
        discount = 0.05;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public float getCreditCard()
    {
        return creditCard;
    }

    public void setCreditCard(float creditCard)
    {
        this.creditCard = creditCard;
    }

    public double getDiscount()
    {
        return discount;
    }

    public void setDiscount(double discount)
    {
        this.discount = discount;
    }

    public int getNumberOfApps()
    {
        return numberOfApps;
    }

    public void setNumberOfApps(int numberOfApps)
    {
        this.numberOfApps = numberOfApps;
    }

    public boolean isYoungCard()
    {
        return youngCard;
    }

    public void setYoungCard(boolean youngCard)
    {
        this.youngCard = youngCard;
    }

    @Override
    public String toString()
    {
        return "Costumer:  Id: "+id+"  Name: "+name+"  Credit Card Number: "+
                creditCard+"  Discount:"+discount+"  numberOfApps: "+
                numberOfApps+"  youngCard: "+youngCard;
    }
    
    public double calculateDiscount(Accomodation c)
    {
        double price;
        price = c.getCost() - c.getCost()*discount;
        return price;
    }
    
    public boolean isHabitual()
    {
        return numberOfApps > 3;
    }
    
    public void addApp(Accomodation c, int time, String s)
    {
        app[numberOfApps] = new Application(c,time,s);
        numberOfApps++;
    }

    public Application[] getApp()
    {
        return app;
    }

    public void setApp(Application[] app)
    {
        this.app = app;
    }
}