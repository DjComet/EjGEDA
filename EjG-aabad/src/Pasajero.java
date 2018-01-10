import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pasajero {

	public int id;
	public String nombre;
	public boolean premium;
	
	public Pasajero(int id, String nombre, boolean premium) {
		this.id = id;
		this.nombre = nombre;
		this.premium = premium;
	}
	
	public Pasajero() throws IOException {
		premium = false;
		System.out.println("Escribe el nombre del pasajero: ");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		nombre = br.readLine();
		
		System.out.println("Escribe el id del pasajero: ");
		isr = new InputStreamReader(System.in);
		br = new BufferedReader (isr);
		id = Integer.parseInt(br.readLine());
		
		String cadena = "c";
		
		while(!cadena.equals("Y") && !cadena.equals("y") && !cadena.equals("N") && !cadena.equals("n")) {
			System.out.println("¿Es premium? (Y/N): ");
			isr = new InputStreamReader(System.in);
			br = new BufferedReader (isr);
			cadena =br.readLine();
		}
		
		if(cadena.equals("Y") || cadena.equals("y")) {
			premium = true;
		}
		
	}
}
