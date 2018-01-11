

public class ColaListaEnlazada {

	protected Nodo frente;
	protected Nodo fin;
	
	public ColaListaEnlazada()
	{
		frente=null;
		fin=null;
	}
	
	public void insertar(Object elemento)
	{
		Nodo a=new Nodo(elemento);
		if(colaVacia())
		{
			frente=a;
		}
		else
		{
			fin.siguiente=a;
		}
		fin=a;
	}

	public boolean colaVacia() {
		// TODO Auto-generated method stub
		return (frente==null);
	}
	
	public void quitar() throws Exception
	{
		
		if(!colaVacia())
		{
			frente=frente.siguiente;
		}
		else throw new Exception("Eliminar de una cola vac�a");
		
		
	}
	
	public void borrarCola()
	{
		while(frente!=null)
		{
			frente=frente.siguiente;
		}
		System.gc();
	}
	
	public Object frenteCola() throws Exception
	{
		if(colaVacia())
		{
			throw new Exception("Error. Cola vac�a");
		}
		return frente.elemento;
	}

}
