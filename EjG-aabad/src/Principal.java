import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {

	private static ColaListaEnlazada cola;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		cola = new ColaListaEnlazada();

		
		
	}

	public void llegaPasajero() throws IOException
	{
		cola.insertar(new Pasajero());
	}
	public boolean asientoDisponible(int i, int j)
	{
		//Compara aquí si el asiento introducido al elegirlo está ocupado ya en el array de pasajeros del avión o no
		return false;
		
	}
	public void subePasajero() throws NumberFormatException, IOException
	{
		int f = 0,c = 0;
		
		if(!cola.colaVacia())//Si la cola no está vacía
		{
			Pasajero p = (Pasajero) cola.frente.elemento;
			
			if(p.premium)//Si el pasajero que va a subir es premium
			{
				System.out.println("Escoja su asiento indicando la fila y la columna del asiento deseado.");
				System.out.print("Fila: ");
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader (isr);
				f = Integer.parseInt(br.readLine());
				
				System.out.print("\nColumna: ");
				c = Integer.parseInt(br.readLine());
				
				if(asientoDisponible(f,c))
				{
					//meter en el array de pasajeros del avión el pasajero evaluado en la posición f,c
				}
			}
		}
				
	}
	
	public void verListadoPasajeros()
	{
		
	}
	
	public void salir()
	{
		
	}
}
