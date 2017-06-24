package milestone2;

import java.io.*;
import java.util.*;

public class FileRead
{

  /**
   * Metodo para leer las viviendas de un fichero
   * @param fileName ruta del fichero
   * @return matriz de viviendas leidas
   * @throws IOException
   */
    
  public static Accomodation [] readAccomodation (String fileName) throws IOException
  {
        int i = 0;
	Accomodation [] acc = new Accomodation[12];
	File f = new File(fileName);
        Scanner sc = new Scanner (f); 
        
        while (sc.hasNext())
        {
            char accType = sc.next().charAt(0);
            int id = sc.nextInt();
            int size = sc.nextInt();
            int cost = sc.nextInt();
            int age = sc.nextInt();
            String state = sc.next();
            
            if (accType=='c')
            {
              int distance = sc.nextInt();
              boolean swimmingPool = sc.nextBoolean();
              acc[i] = new CountryAccomodation(id,size,age,state,cost,distance,
                                                swimmingPool);
            }
            else
            {
                String type = sc.next();
                boolean furnished = sc.nextBoolean();       
                acc[i] = new CityAccomodation(id,size,age, state,cost,type,
                                                furnished);
            }
            
            i++;
    }
        
    sc.close();
    return acc;
  }

  /**
   * Metodo para leer los clientes de un fichero 
   * @param fileName ruta del fichero
   * @return matriz de clientes leidos
   * @throws IOException
   */
  public static Costumer [] readCostumer (String fileName)throws IOException
  {
        int i = 0;
	Costumer [] clients = new Costumer[10];
        File f = new File(fileName);
        Scanner sc = new Scanner (f);
        
        while (sc.hasNext())
        {
            String name = sc.next();
            String id = sc.next();
            float creditCard = sc.nextFloat();
            boolean youngCard = sc.nextBoolean();
            
            if (youngCard)
            {
              int idYoungCard = sc.nextInt();
              clients[i] = new YoungClient(id,name,creditCard,youngCard,idYoungCard);
            }
            else
            {
              clients[i] = new Costumer(id, name, creditCard, youngCard);
            }
            
            i++;
        }
          sc.close();
          
          return clients;
      }  

}