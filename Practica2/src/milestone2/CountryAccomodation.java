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
public class CountryAccomodation extends Accomodation
{    
    private int distance;
    private boolean swimmingPool;

    public CountryAccomodation(int id, int size, int age, String state, 
                                int cost, int distance, boolean swimmingPool)
    {
        super(id, size, age, state, cost);
        this.distance = distance;
        this.swimmingPool = swimmingPool;
    }

    public int getDistance()
    {
        return distance;
    }

    public void setDistance(int distance)
    {
        this.distance = distance;
    }

    public boolean isSwimmingPool() {
        return swimmingPool;
    }

    public void setSwimmingPool(boolean swimmingPool)
    {
        this.swimmingPool = swimmingPool;
    }

    @Override
    public String toString()
    {
        return "Country "+super.toString()+"  Distance: "+
                distance+"  SwimmingPool: "+swimmingPool;
    }
}