package alquiler_Viviendas;
import java.io.*;
import java.util.*;
public class alquiler_Viviendas {
	/* Representa la Clase Principal de la App
	 */
	
		private static Cliente[] cli = new Cliente[30];
		private static Casa[] casa = new Casa[40];
		private static Solicitud[] sol = new Solicitud[50];
		
		/**
		 * 
		 * @param args
		 * @throws FileNotFoundException
		 */
		public static void main (String [] args) throws FileNotFoundException {
			int menu_opciones;
			
			readArchivo_Clientes();
			readArchivo_Viviendas(); 

			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			scan.useLocale(Locale.US);

			do {
				System.out.println("---------------------------------\nBienvenido a nuestra app de alquiler de viviendas!");
				System.out.println("Elige una opción: \n1.Muestra las casas disponibles \n2.Hacer una solicitud de alquiler \n3.Muestra las solicitudes del cliente \n4.Busca clientes habituales \n5.Comprobar descuentos \n6.Muestra solicitudes de casas especificas \n7.Salida\n---------------------------------");
				menu_opciones = scan.nextInt();
				// Menu
				switch (menu_opciones) {
				case 1:
					Casas_disponibles();
					break;
				case 2:
					hacer_Solicitud();
					break;
				case 3:
					Solicitudes_clientes();
					break;
				case 4:
					if(Cliente_habitual(ask_DNI())) {
						System.out.println("---------------------------------"); 
						System.out.println("El cliente es habitual.");
					} else {
						System.out.println("---------------------------------");
						System.out.println("El cliente no es habitual.");
					}
					break;
				case 5:
					calcular_Descuento();
					break;
				case 6:
					Solicitudes_casas();
					break;
				case 7:
					System.out.println("Gracias por usar nuestra app de alquiler de viviendas. Deseamos volver a verte pronto!");
					break;
				} // Fin Menu switch
			} while (menu_opciones!=7);
		} // Fin Main
		
		/**
		 * @throws FileNotFoundException
		 */
		public static void readArchivo_Clientes() throws FileNotFoundException {
			String linea, nombre, dni;
			long tarjeta_credito;
			int numero_carnet_joven, i;
			boolean carnet_joven;
			
			try {
				Scanner scan = new Scanner(new FileReader("Clientes.txt"));
				while(scan.hasNextLine()) {
					linea = scan.nextLine();
				    nombre =linea.split(" ")[0];
					dni = linea.split(" ")[1];
					tarjeta_credito = Long.parseLong(linea.split(" ")[2]);
					carnet_joven = Boolean.parseBoolean(linea.split(" ")[3]);

					try {
						numero_carnet_joven = Integer.parseInt(linea.split(" ")[4]);
					} catch(ArrayIndexOutOfBoundsException e) {
						numero_carnet_joven = 0;
					}
					
					i = ultimo_Cliente();
					if(i == -1) {
						System.out.println("No hay mas espacio para más clientes nuevos. Lo sentimos!");
						System.out.println("El cliente "+nombre+" no ha sido añadido a la lista de clientes.");
					} else {
						cli[i] = new Cliente(nombre, dni, tarjeta_credito, carnet_joven, numero_carnet_joven);
					}
				}
				scan.close();
			} catch (FileNotFoundException e) {
				System.out.println("Ha ocurrido un error mientras se intentaba abrir el fichero de los clientes.");
				e.printStackTrace();
			}
		}

		/**
		 * @throws FileNotFoundException
		 */
		public static void readArchivo_Viviendas() throws FileNotFoundException {
			int casa_ID, m2, ant, precio, i;
			double distancia;
			String tipo, alquiler, linea, tipo_vivienda;
			boolean amueblado, piscina;
			
			try {
				Scanner scan = new Scanner(new FileReader("Viviendas.txt"));
				while(scan.hasNextLine()) {
					linea = scan.nextLine();
					tipo = linea.split(" ")[0];
					casa_ID=0;
					try{
					casa_ID = Integer.parseInt(linea.split(" ")[1]);}
					catch(Exception e){
					System.out.println("error!");}
					
					m2 = Integer.parseInt(linea.split(" ")[2]);
					precio = Integer.parseInt(linea.split(" ")[3]);
					ant = Integer.parseInt(linea.split(" ")[4]);
					alquiler = linea.split(" ")[5];
					tipo_vivienda = linea.split(" ")[6];
				    amueblado = Boolean.parseBoolean(linea.split(" ")[7]);
					
					i = ultima_Casa();
					if(i == -1) { 
						System.out.println("No hay más espacio para nuevas casas. Lo sentimios!");
						System.out.println("La casa "+casa_ID+" no ha sido añadida a la lista de casas.");
					} else {
						if(tipo_vivienda.equalsIgnoreCase("c")) {
							distancia = Double.parseDouble(linea.split(" ")[6]);
							piscina = Boolean.parseBoolean(linea.split(" ")[7]);
							casa[i] = new Chalet(casa_ID, m2, ant, precio, alquiler, tipo, piscina, distancia);
						} else if(tipo_vivienda.equalsIgnoreCase("p")) {
							tipo_vivienda = linea.split(" ")[6];
							amueblado = Boolean.parseBoolean(linea.split(" ")[7]);
							casa[i] = new Vivienda(casa_ID, m2, ant, precio, alquiler, tipo, amueblado, tipo_vivienda);
						}
							
					}
				}
				scan.close();
			} catch (FileNotFoundException e) {
				System.out.println("Ha ocurrido un error mientras se intentaba abrir el fichero de las viviendas.");
				e.printStackTrace();
			}
		}

		public static void  casas_Alquiler(String state) {
			System.out.println("---------------------------------");
			for(int i = 0; i<ultima_Casa(); i++)
				if(casa[i].getalquiler().equalsIgnoreCase(state))
					System.out.println(casa[i].toString()); // 
			System.out.println("---------------------------------");
		}
		
		/**
		 * @throws FileNotFoundException
		 */
		public static void Casas_disponibles () throws FileNotFoundException {
			int opcion;

			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			scan.useLocale(Locale.US);

			do {
				System.out.println("¿Qué casas quieres buscar? \n1.Casas disponibles en venta \n2.Casas disponibles en alquiler \n3.Volver al menú principal");
				opcion = scan.nextInt();

				switch (opcion) {
				case 1:
					casas_Alquiler("venta"); 
					break;
				case 2:
					casas_Alquiler("alquiler");
					break;
				}
			} while (opcion!=3);
		}

		public static void hacer_Solicitud() {
			String dni;
			Cliente auxCli;
			int iCli = ultimo_Cliente(), iSol = ultima_Solicitud();

			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			scan.useLocale(Locale.US);

			System.out.println("- Inserta tu DNI porfavor -");
			dni = scan.nextLine();

			if((auxCli = buscar_Cliente(dni))!=null) {
				if(iSol == -1)
					System.out.println("No hay más espacio para nuevas solicitudes. Lo sentimos!");
				else
					sol[iSol] = ask_DatosSolicitudes(auxCli);
			} else { 
				if(iCli == -1) {
					System.out.println("No hay más espacio para nuevos clientes. Lo sentimos!");
				} else {
					cli[iCli] = ask_DatosClientes(dni); 
					
					if(iSol == -1)
						System.out.println("No hay más espacio para nuevas solicitudes. Lo sentimos!");
					else
						sol[iSol] = ask_DatosSolicitudes(cli[iCli]); 
				}
			}
		}
		
		public static void Solicitudes_clientes() {
			String dni;

			dni = ask_DNI();
			
			System.out.println("---------------------------------");
			for(int i = 0; i<ultima_Solicitud(); i++)
				if(sol[i].getcliente().getDNI().equalsIgnoreCase(dni))
					System.out.println(sol[i].toString());
		}
		
		public static void Solicitudes_casas() {
			int numero_casa, i;
			
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			scan.useLocale(Locale.US);
			
			System.out.println("---------------------------------");
			for(i = 0; i<ultima_Casa(); i++)
				System.out.println("Numero de casa "+i+": "+casa[i].toString());
			System.out.println("---------------------------------");
			
			System.out.println("¿Qué casa quiere seleccionar?");
			numero_casa = scan.nextInt();
			
			while(numero_casa<0 || numero_casa>=i) {
				System.out.println("Porfavor inserte un número válido de casa: ");
				numero_casa = scan.nextInt();
			}
			
			System.out.println("---------------------------------");
			for(i = 0; i<ultima_Solicitud(); i++)
				if(sol[i].getcasa().getcasa_ID()==casa[numero_casa].getcasa_ID())
					System.out.println(sol[i].toString());
		}
		
		/**
		 * @return
		 */
		public static int ultimo_Cliente() {
			for(int i = 0; i<cli.length; i++)
				if(cli[i]==null) return i;
			
			return -1;
		}
		
		/**
		 * @return
		 */
		public static int ultima_Solicitud() {

			for(int i = 0; i<sol.length; i++)
				if(sol[i]==null) return i;
			
			return -1;
		}
		
		/**
		 * @return
		 */
		public static int ultima_Casa() {
			for(int i = 0; i<casa.length; i++)
				if(casa[i]==null) return i;
			
			return -1;
		}

		/**
		 * @param dni
		 * @return
		 */
		public static Cliente ask_DatosClientes(String dni) {

			String nombre, tiene_carnet_joven;
			long tarjeta_credito;
			int numero_carnet_joven = 0;
			boolean carnet_joven = false;

			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			scan.useLocale(Locale.US);

			System.out.println("No eres un usuario registrado. Completa la información de abajo. Gracias!");
			System.out.println("- Inserta tu Nombre -");
			nombre = scan.nextLine();

			System.out.println("- Inserta tu número de tarjeta de crédito -");
			tarjeta_credito = Integer.parseInt(scan.nextLine());

			System.out.println("Tienes carnet joven? (Si/No)");
			tiene_carnet_joven = scan.nextLine();
			while(!tiene_carnet_joven.equalsIgnoreCase("Si") && !tiene_carnet_joven.equalsIgnoreCase("no")) {
				System.out.println("Error. Porfavor inserte una opción correcta.");
				tiene_carnet_joven = scan.nextLine();
			}

			if(tiene_carnet_joven.equalsIgnoreCase("Si")) {
				carnet_joven = true;
				System.out.println("- Inserta tu número de carnet joven -");
				numero_carnet_joven = Integer.parseInt(scan.nextLine());
			}

			return new Cliente(dni, nombre, tarjeta_credito, carnet_joven, numero_carnet_joven);
		}
		
		/**
		 * @param cli
		 * @return
		 */
		public static Solicitud ask_DatosSolicitudes(Cliente cli) {
			String solicitud;
			int tiempo_alquiler=0, i, numero_casa;
			Casa casa2;
			
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			scan.useLocale(Locale.US);

			System.out.println("- Inserta tu nombre de solicitud -");
			solicitud = scan.nextLine();
			
			System.out.println("---------------------------------");
						for(i = 0; i<ultima_Casa(); i++)
			System.out.println("Número casa "+i+":"+casa[i].toString());
			System.out.println("---------------------------------");
			
			System.out.println("¿Qué casa quieres seleccionar?");
			numero_casa = scan.nextInt();
			
			while(numero_casa<0 || numero_casa>=i) {
				System.out.println("Porfavor, inserte un número de casa válido. Gracias!");
				numero_casa = scan.nextInt();
			}
			while(casa[numero_casa].getalquiler().equalsIgnoreCase("venta")) {
				System.out.println("Esta casa no está disponible para alquilar. Porfavor, inserte un número de casa válido. Gracias!");
				numero_casa = scan.nextInt();
			}
			
			casa2=casa[numero_casa];
			
			System.out.println("¿Cuántos meses quieres alquilar la casa?");
			tiempo_alquiler = scan.nextInt();
			
			while(tiempo_alquiler<=0) {
				System.out.println("Porfavor inserte un tiempo válido de alquiler. Gracias!");
				tiempo_alquiler = scan.nextInt();
			}
			
			return new Solicitud(solicitud, tiempo_alquiler, casa2, cli);
		}
		
		/**
		 * @return
		 */
		public static String ask_DNI() {
			String dni;

			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			scan.useLocale(Locale.US);

			System.out.println("- Inserta tu DNI please -");
			dni = scan.nextLine();

			while(buscar_Cliente(dni)==null) {
				System.out.println("Este cliente no existe. Inserte uno correcto porfavor.");
				dni = scan.nextLine();
			}
			
			return dni;
		}
		
		/**
		 * @param dni
		 * @return
		 */
		public static boolean Cliente_habitual(String dni) {

			int numero_habitual = 0;
			
			for(int i = 0; i<ultima_Solicitud(); i++)
				if(sol[i].getcliente().getDNI().equalsIgnoreCase(dni))
					numero_habitual++;
			
			if(numero_habitual>=3)
				return true;
				
			return false;
		}
		
		 /**
		  * @param dni
		  * @return
		  */
		public static Cliente buscar_Cliente(String dni) {
			for(int i = 0; i<ultimo_Cliente(); i++)
				if(cli[i].getDNI().equalsIgnoreCase(dni)) return cli[i];

			return null;
		}
		
		private void calcular_Descuento() {
			String dni;
			int descuento = 0;
			
			dni = ask_DNI();
			
			if(Cliente_habitual(dni)) {
				descuento = 10;
				if(buscar_Cliente(dni).getcarnet_joven())
					descuento = 25;
			} else if(buscar_Cliente(dni).getcarnet_joven())
				descuento = 20;
			System.out.println("---------------------------------");
			System.out.println("El descuento del cliente es: "+descuento+"%");
		}
	} // Fin Clase	