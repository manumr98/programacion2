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
public class Shop
{
    
    private Costumer [] costumer;
    Accomodation [] accomodation;
    
    public Shop(Costumer [] c, Accomodation [] a)
    {
        costumer = c;
        accomodation = a;
    }
    
    public void printAll()
    {
        int i;
        
        for(i = 0; i< costumer.length; i++){
            System.out.println(costumer[i].toString());
        }
        for(i = 0; i< accomodation.length;i++){
            System.out.println(accomodation[i].toString());
        }
        
    }

    public Costumer[] getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer[] costumer) {
        this.costumer = costumer;
    }

    public Accomodation[] getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(Accomodation[] accomodation) {
        this.accomodation = accomodation;
    }
    
    
    
}