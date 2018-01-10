
public class Ordenacion {
	

	public void quicksort(String a[], int primero, int ultimo) {
		String pivote, tmp;
		int i, j, central;
		char[] aI = null;
		char[] piv = null;
		char[] aJ = null;
		
		central = (primero + ultimo)/2;
		pivote = a[central];
		
		i = primero;
		j = ultimo;
		
		do {
			aI.equals(a[i]);
			aJ.equals(a[j]);
			piv.equals(pivote);
			
			
			
			
			
		}while(i<=j);
		
	}
	
	void quicksort2(String a[],int primero,int ultimo)
	{
	 int i,j, central;
	 String tmp,pivote;

	 central = (primero+ultimo)/2;
	 pivote=a[central];
	 
	 i=primero;
	 j=ultimo;
	 
	 do{
		 while((a[i].compareTo(pivote)<0) && (i<ultimo)) i++;
		 while((a[j].compareTo(pivote)>0) && (j<ultimo)) i++;
		 
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
