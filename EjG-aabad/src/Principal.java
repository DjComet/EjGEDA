import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Principal {

	private static ColaListaEnlazada cola;
	private static Avion avionPrincipal;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		cola = new ColaListaEnlazada();
		avionPrincipal = new Avion(78541, 0524, "AprobadoLandia");
		
		
	}

	public void llegaPasajero() throws IOException
	{
		cola.insertar(new Pasajero());
	}
	
	public boolean asientoDisponible(int i, int j)
	{
		//Compara aquí si el asiento introducido al elegirlo está ocupado ya en el array de pasajeros del avión o no
		
		return (avionPrincipal.matrizPasajeros[i][j] == null);
		//Si es igual a null, el sitio está libre, con lo cual devuelve true.
		
	}
	
	public void imprimeEstadoAsientos()
	{
		for(int i = 0; i<avionPrincipal.filas; i++)
		{
			for(int j = 0; j<avionPrincipal.columnas; j++)
			{
				if(j > 1)
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
	public void subePasajero() throws NumberFormatException, IOException
	{
		int f = 0,c = 0;
		
		if(!cola.colaVacia())//Si la cola no está vacía
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
						if(f>10 || c >4 || f<0 || c<0)
						{System.out.println("El avión tiene un maximo de 10 filas y 4 columnas, por favor, no se salga de los límites.");}
						else if(f!=0)
						{f-=1;}
						else if (c!=0)//Podría usarse algebra modular como otra solución para evitar el problema del tamaño de los arrays
						{c-=1;}
					}while(f>10 || c >4 || f<0 || c<0);
					if(!asientoDisponible(f,c)) 
						System.out.println("El asiento que ha elegido ya está ocupado, por favor elija otro asiento.");
				}while(!asientoDisponible(f,c));
				
				//meter en el array de pasajeros del avión el pasajero evaluado en la posición f,c
				avionPrincipal.matrizPasajeros[f][c] = (Pasajero) cola.frente.elemento;
				
			}
			else//no es premium
			{
				Random rand = new Random();
				do{
				f = rand.nextInt(9);
				c = rand.nextInt(3);
				}while (!asientoDisponible(f,c));
				
				//meter en el array de pasajeros del avión el pasajero evaluado en la posición f,c
				avionPrincipal.matrizPasajeros[f][c] = (Pasajero) cola.frente.elemento;
				
			}
		}
		else//cola vacia
		{
			System.out.println("¡Ya no quedan pasajeros esperando en la cola!");
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
