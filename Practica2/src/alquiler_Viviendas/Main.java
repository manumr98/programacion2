package alquiler_Viviendas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
private final static String RutaClientes="Clientes.txt";
private final static String RutaViviendas= "Viviendas.txt";
private static FileRead f;
private static Inmobiliaria inmob;
private static Scanner sc= new Scanner(System.in);
public static void main (String []args){
	
	f=new FileRead(RutaClientes,RutaViviendas);
	inmob= new Inmobiliaria(f.readCliente(),f.readVivienda());
	menuA();
}
public static void menuA()
{
    int c;
    boolean goOut = false;
    
    
    do
    {
        System.out.print("Elige una opción: \n1.Muestra las casas disponibles \n2.Hacer una solicitud de alquiler \n3.Muestra las solicitudes del cliente \n4.Busca clientes habituales \n5.Comprobar descuentos \n6.Muestra solicitudes de casas especificas \n7.Salida\n---------------------------------");
    
        c = menuController();
        
        switch(c)
        {
            case 1:
               // showRent();
            break;
            
            case 2:
            	//System.out.println(rentProperties());
            break;
            
            case 3:
            	//System.out.println(seeApplications());
            break;
            
            case 4:
            	//System.out.println(consultCostumer());
            break;
            
            case 5:
            	// System.out.println(consultDiscount());
            break;
            
            case 6:
            	// System.out.println(consultPropertyApp());
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

}