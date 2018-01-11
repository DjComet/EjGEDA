
public class Ordenacion {
	
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
