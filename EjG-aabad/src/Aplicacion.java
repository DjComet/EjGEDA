import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Aplicacion {
	
	public  ColaListaEnlazada cola;
	public  Avion avionPrincipal;
	
	public Aplicacion(Avion avionP){
		cola = new ColaListaEnlazada();
		avionPrincipal = avionP;
	}
	
	public void menu() throws Exception {
		System.out.println("\n********************************");
		System.out.println("Elige una opci�n:");
		System.out.println("1.- Llega pasajero");
		System.out.println("2.- Sube pasajero");
		System.out.println("3.- Ver lista de pasajeros");
		System.out.println("4.- Salir");
		System.out.println("********************************\n");
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		int selector = Integer.parseInt(br.readLine());
		
		switch(selector){
			case 1:
				llegaPasajero();
				break;
			case 2:
				subePasajero();
				break;
			case 3:
				verListadoPasajeros();
				break;
			case 4:
				salir();
				break;
			default:
				System.out.println("Valor incorrecto.");
				menu();
		}
	}
	
	public void llegaPasajero() throws Exception
	{
		cola.insertar(new Pasajero());
		menu();
	}
	
	public boolean asientoDisponible(int i, int j)
	{
		//Compara aqu� si el asiento introducido al elegirlo est� ocupado ya en el array de pasajeros del avi�n o no
		
		return (avionPrincipal.matrizPasajeros[i][j] == null);
		//Si es igual a null, el sitio est� libre, con lo cual devuelve true.
		
	}
	
	public void imprimeEstadoAsientos()
	{
		for(int i = 0; i<avionPrincipal.filas; i++)
		{
			for(int j = 0; j<avionPrincipal.columnas; j++)
			{
				if(j == 2)
				{
					System.out.print("  ");
				}
				if(avionPrincipal.matrizPasajeros[i][j] == null)
				{
					System.out.print("[-]");
				}
				else
				{
					System.out.print("[" +avionPrincipal.matrizPasajeros[i][j].id + "]" ); 
				}
			}
			System.out.print("\n");
		}
	}
	public void subePasajero() throws Exception
	{
		int f = 0,c = 0;
		
		if(!cola.colaVacia())//Si la cola no est� vac�a
		{
			Pasajero p = (Pasajero) cola.frente.elemento;
			
			if(p.premium)//Si el pasajero que va a subir es premium
			{
				do{
					do{
						System.out.println("Escoja su asiento indicando la fila y la columna del asiento deseado.");
						System.out.print("Fila: ");
						InputStreamReader isr = new InputStreamReader(System.in);
						BufferedReader br = new BufferedReader (isr);
						f = Integer.parseInt(br.readLine());
						
						System.out.print("\nColumna: ");
						c = Integer.parseInt(br.readLine());
						if(f>10 || c >4 || f<1 || c<1)
						{System.out.println("El avi�n tiene un maximo de 10 filas y 4 columnas, por favor, no se salga de los l�mites.");}
						else
						{
							f-=1; 
							c-=1;
						}
					}while(f>10 || c >4 || f<0 || c<0);
					if(!asientoDisponible(f,c)) 
						System.out.println("El asiento que ha elegido ya est� ocupado, por favor elija otro asiento.");
				}while(!asientoDisponible(f,c));
				
				//meter en el array de pasajeros del avi�n el pasajero evaluado en la posici�n f,c
				avionPrincipal.matrizPasajeros[f][c] = (Pasajero) cola.frente.elemento;
				
			}
			else//no es premium
			{
				Random rand = new Random();
				do{
				f = rand.nextInt(9);
				c = rand.nextInt(3);
				}while (!asientoDisponible(f,c));
				
				//meter en el array de pasajeros del avi�n el pasajero evaluado en la posici�n f,c
				avionPrincipal.matrizPasajeros[f][c] = (Pasajero) cola.frente.elemento;
				
			}
			cola.quitar();
		}
		else//cola vacia
		{
			System.out.println("�Ya no quedan pasajeros esperando en la cola!");
		}
			
		imprimeEstadoAsientos();
		menu();
	}
	
	public void verListadoPasajeros() throws Exception
	{
		String[] pasajeros = new String[1];
		String[] anteriorPasajeros;
		int x = 0;
		
		for(int i = 0; i<avionPrincipal.filas; i++)
		{
			for(int j = 0; j<avionPrincipal.columnas; j++)
			{
				if(avionPrincipal.matrizPasajeros[i][j] != null)
				{
					if(x == 0) {
						pasajeros[x] = avionPrincipal.matrizPasajeros[i][j].nombre;
						x++;
					}
					else {
						anteriorPasajeros = new String[x];
						anteriorPasajeros = pasajeros;
						pasajeros = new String[x+1];
						
						for(int z = 0; z < x; z++) {
							pasajeros[z] = anteriorPasajeros[z];
						}
						
						pasajeros[x] = avionPrincipal.matrizPasajeros[i][j].nombre;
						x++;
					}
				}
			}
		}
		quicksort(pasajeros, 0, x-1);
		for(int i = 0; i <x; i++) {
			System.out.println(pasajeros[i]);
		}
		
		menu();
	}
	
	public void salir()
	{
		System.out.println("La ejecuci�n ha terminado.");
	}
	
	void quicksort(String a[],int primero,int ultimo)
	{
	 int i,j, central;
	 String tmp,pivote;

	 central = (primero+ultimo)/2;
	 pivote=a[central];
	 
	 i=primero;
	 j=ultimo;
	 
	 do{
		 while((a[i].compareTo(pivote)<0) && (i<ultimo)) i++;
		 while((a[j].compareTo(pivote)>0) && (j>primero)) j--;
		 
		 if(i<=j)
		 {
			 tmp = a[i];
			 a[i] = a[j];
			 a[j] = tmp;
			 i++;
			 j--;
		 }
	 }while(i<=j);

	 if(primero<j) quicksort(a,primero,j);
	 if(i<ultimo) quicksort(a,i,ultimo);
	}
}
