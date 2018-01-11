import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Principal {

	private static  ColaListaEnlazada cola;
	private static  Avion avionPrincipal;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		cola = new ColaListaEnlazada();
		avionPrincipal = new Avion(78541, 0524, "AprobadoLandia");
		
		llegaPasajero();
		subePasajero();
		llegaPasajero();
		subePasajero();
	}

	public static void llegaPasajero() throws IOException
	{
		cola.insertar(new Pasajero());
	}
	
	public static boolean asientoDisponible(int i, int j)
	{
		//Compara aqu� si el asiento introducido al elegirlo est� ocupado ya en el array de pasajeros del avi�n o no
		
		return (avionPrincipal.matrizPasajeros[i][j] == null);
		//Si es igual a null, el sitio est� libre, con lo cual devuelve true.
		
	}
	
	public static void imprimeEstadoAsientos()
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
	public static void subePasajero() throws Exception
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
		
	}
	
	public void verListadoPasajeros()
	{
		
	}
	
	public void salir()
	{
		
	}
}
