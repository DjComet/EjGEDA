
public class Principal {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Avion avionPrincipal = new Avion(78541, 0524, "AprobadoLandia");
		Aplicacion app = new Aplicacion(avionPrincipal);
		
		app.menu();
	}

	
}
