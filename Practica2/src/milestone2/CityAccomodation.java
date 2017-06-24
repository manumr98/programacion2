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
public class CityAccomodation extends Accomodation
{
    private String type;
    private boolean furnished;
    
    public CityAccomodation(int id, int size, int age, String state,
                            int cost, String type, boolean furnished)
    {
        super(id, size, age, state, cost);
        this.type = type;
        this.furnished = furnished;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public boolean isFurnished() {
        return furnished;
    }

    public void setFurnished(boolean furnished)
    {
        this.furnished = furnished;
    }

    @Override
    public String toString()
    {
        return "City "+super.toString()+"  Type: "+type
                                + "  Furnished: "+furnished;
    }

}