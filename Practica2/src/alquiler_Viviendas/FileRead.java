package alquiler_Viviendas;

import java.io.*;
import java.util.*;

public class FileRead
{
	private String RutaClientes;
	private String RutaViviendas;
	
	public FileRead(String RutaClientes,String RutaViviendas){
		this.RutaClientes=RutaClientes;
		this.RutaViviendas=RutaViviendas;
	}
    
  public  Vivienda [] readVivienda () 
  {
        int i = 0;
	Vivienda [] acc = new Vivienda[12];
	File f = new File(RutaViviendas);
        Scanner sc;
		try {
			sc = new Scanner (f);
		
        
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
              acc[i] = new Chalet(id,size,cost,age,state, distance, swimmingPool);
            }
            else
            {
                String type = sc.next();
                boolean furnished = sc.nextBoolean();       
               acc[i] = new Casa(id,size,age,cost, state,furnished,type);
            }
            
            i++;
    }
        
    sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    return acc;
  }

  /**
   * Metodo para leer los clientes de un fichero 
   * @param fileName ruta del fichero
   * @return matriz de clientes leidos
   * @throws IOException
   */
  public  Cliente [] readCliente()
  {
        int i = 0;
	Cliente [] clients = new Cliente[10];
        File f = new File(RutaClientes);
        Scanner sc;
		try {
			sc = new Scanner (f);
		
        
        while (sc.hasNext())
        {
            String name = sc.next();
            String id = sc.next();
            float creditCard = sc.nextFloat();
            boolean youngCard = sc.nextBoolean();
            
            if (youngCard)
            {
              int idYoungCard = sc.nextInt();
              clients[i] = new Clientejoven(id,name,creditCard,idYoungCard);
            }
            else
            {
              clients[i] = new Cliente(id, name, creditCard);
            }
            
            i++;
        }
          sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          return clients;
      }  
  

}