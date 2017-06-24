/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package milestone2;

public class Accomodation
{
    private int id;
    private int size;
    private int age;
    private String state;
    private int cost;

    public Accomodation(int id, int size, int age, String state, int cost)
    {
        this.id = id;
        this.size = size;
        this.age = age;
        this.state = state;
        this.cost = cost;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public int getCost()
    {
        return cost;
    }

    public void setCost(int cost)
    {
        this.cost = cost;
    }

    @Override
    public String toString()
    {
        return "Accomodation:  Id:"+id+"  Size: "+size+"  Age: "+age+"  State: "
                +state+"  Cost: "+cost;
    }

}