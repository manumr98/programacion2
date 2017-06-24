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
public class YoungClient extends Costumer{
    
    private int idCard;

    public YoungClient(String id, String name, float creditCard, 
                        boolean youngCard, int idCard)
    {
        super(id, name, creditCard, youngCard);
        this.idCard = idCard;
        super.setDiscount(0.20);
    }

    public int getIdCard()
    {
        return idCard;
    }

    public void setIdCard(int idCard)
    {
        this.idCard = idCard;
    }

    @Override
    public String toString()
    {
        return "Young "+super.toString()+" idCard: "+this.idCard;
    }
    
    
}