
class Nodo{
	private int dato;
	private Nodo nodoSiguiente;
	
	public Nodo(int dato) {
		this.dato = dato;
		nodoSiguiente = null;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public Nodo getNodoSiguiente() {
		return nodoSiguiente;
	}

	public void setNodoSiguiente(Nodo nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}

}

class ListaEnlazada{
	Nodo nodoInicio;
	Nodo nodoFin;
	
	public ListaEnlazada(){
		nodoInicio = nodoFin = null;
	}	
	
	public boolean listaVacia() {
		return (nodoInicio == null)&&(nodoFin == null);
	}
	
	public void agregarElementoAlInicio(int dato){
		Nodo nuevoNodo=new Nodo(dato);
		if (this.listaVacia()) {
			this.nodoInicio=this.nodoFin=nuevoNodo;
		}else {
			nuevoNodo.setNodoSiguiente(nodoInicio);
			this.nodoInicio = nuevoNodo;
		}
	}
	
	public void agregarElementoAlFinal(int dato){
		Nodo nuevoNodo=new Nodo(dato);
		if (this.listaVacia()) {
			this.agregarElementoAlInicio(dato);
		}else {
			Nodo nodoActual;
			nodoActual = nodoInicio;
			while(nodoActual.getNodoSiguiente()!=null){
				nodoActual=nodoActual.getNodoSiguiente();
			}
			nodoActual.setNodoSiguiente(nuevoNodo);
		}
	}
	
	public void mostrarListaEnlazada() {
		Nodo nodoActual = nodoInicio;
		while(nodoActual!=null){
			System.out.print("["+nodoActual.getDato()+"]-->");
			nodoActual=nodoActual.getNodoSiguiente();
		}
	}
	
}


public class PruebaListasEnlazadas {

	public static void main(String[] args) {
		ListaEnlazada le1 = new ListaEnlazada();
		le1.agregarElementoAlInicio(7);
		le1.agregarElementoAlInicio(1);
		le1.agregarElementoAlInicio(2);
		
		System.out.println(le1);
		
		le1.mostrarListaEnlazada();
		
		System.out.println("\n----------------------------------");
		
		ListaEnlazada le2 = new ListaEnlazada();
		le2.agregarElementoAlFinal(5);
		le2.agregarElementoAlFinal(1);
		le2.agregarElementoAlFinal(6);

		le2.mostrarListaEnlazada();
	}

}
