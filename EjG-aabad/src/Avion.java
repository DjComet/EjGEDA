
public class Avion {
	
	public int numeroVuelo;
	public int horaSalida;
	public String destino;
	public int filas;
	public int columnas;
	public Pasajero[][] matrizPasajeros;
	
	public Avion(int n, int h, String d)
	{
		filas = 10;
		columnas = 4;
		matrizPasajeros = new Pasajero[filas][columnas];
		
	}
}
