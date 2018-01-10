import java.io.IOException;

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
	
	public void subePasajero()
	{
		
	}
	
	public void verListadoPasajeros()
	{
		
	}
	
	public void salir()
	{
		
	}
}
