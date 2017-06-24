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
public class Application
{
    private Accomodation acc;
    private int rentTime;
    private String state;
    
    public Application(Accomodation a, int rt, String s)
    {
        acc = a;
        rentTime = rt;
        state = s;        
    }

    public Accomodation getAcc()
    {
        return acc;
    }

    public void setAcc(Accomodation acc)
    {
        this.acc = acc;
    }

    public int getRentTime() {
        return rentTime;
    }

    public void setRentTime(int rentTime)
    {
        this.rentTime = rentTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    @Override
    public String toString()
    {
        return "Application: " + "Accomodation" + acc.toString() + 
                ", rentTime:" + rentTime + ", state:" + state;
    }
}