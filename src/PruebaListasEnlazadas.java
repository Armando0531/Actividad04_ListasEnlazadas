import java.util.Scanner;
import java.util.LinkedList;

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
	
	@Override
	public String toString() {
		return "Nodo [dato=" + dato + ", nodoSiguiente=" + nodoSiguiente + "]";
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
	
	public void eliminarElementoInicial() {
		if(listaVacia()) {
			System.out.println("No se puede eliminar lista Vacia");
		}else if(nodoInicio==nodoFin) {
			nodoInicio=nodoFin=null;
		}else {
			Nodo nodoAuxiliar=nodoInicio;
			System.out.println("Se elimino el dato: "+nodoAuxiliar.getDato());
			nodoInicio=nodoInicio.getNodoSiguiente();
			nodoAuxiliar=null;
		}
	}
	
	public void eliminarElementoFinal() {
		if(listaVacia()) {
			System.out.println("No se puede eliminar lista Vacia");
		}else if(nodoInicio==nodoFin) {
			nodoInicio=nodoFin=null;
		}else {
			Nodo nodoAuxiliar=nodoInicio;
			while(nodoAuxiliar.getNodoSiguiente()!=nodoFin) {
				nodoAuxiliar=nodoAuxiliar.getNodoSiguiente();
			}
			System.out.println("El dato eliminado es: "+nodoAuxiliar.getDato());
			nodoFin=nodoAuxiliar;
			nodoFin.setNodoSiguiente(null);
		}
	}
	
	public int eliminarDatoEspecifico(int dato) {
		if(listaVacia()) {
			return -1;
		}else if (nodoInicio==nodoFin && nodoInicio.getDato()==dato){
			Nodo nodoAux=nodoInicio;
			nodoInicio=nodoFin=null;
			return nodoAux.getDato();
		}else {
			Nodo nodoAnterior,nodoSig;
			nodoAnterior=nodoInicio;
			nodoSig=nodoAnterior.getNodoSiguiente();
			while(nodoSig !=null && nodoSig.getDato()!=dato) {
				nodoAnterior = nodoAnterior.getNodoSiguiente();
				nodoSig=nodoSig.getNodoSiguiente();
			}
			if(nodoInicio==nodoSig) {
				int x=0;
				nodoInicio=nodoInicio.getNodoSiguiente();
				x=nodoInicio.getDato();
				return x;
			}
				if(nodoSig!=null && nodoSig.getDato()==dato ) {
					int n=nodoSig.getDato();
					nodoAnterior.setNodoSiguiente(nodoSig.getNodoSiguiente());
					nodoSig=nodoSig.getNodoSiguiente();
					return n;
				}else {
					return -2;
				}
		}
		
	}
	
	public void mostrarCantidadElementos() {
		Nodo nodoActual=nodoInicio;
		int cantidad=0;
		while(nodoActual!=null) {
			cantidad++;
			nodoActual=nodoActual.getNodoSiguiente();
		}
		System.out.println("La lista tiene: "+cantidad);
	}
	
	public void mostrarListaEnlazada() {
		Nodo nodoActual = nodoInicio;
		while(nodoActual!=null){
			System.out.print("["+nodoActual.getDato()+"]-->");
			nodoActual=nodoActual.getNodoSiguiente();
		}
		System.out.println();
	}
	
}


public class PruebaListasEnlazadas {

	public static void main(String[] args) {
		LinkedList<Integer> lc= new LinkedList<Integer>();
		Scanner entrada=new Scanner(System.in);
		int op=0;
		ListaEnlazada lista=new ListaEnlazada();
		do {
		System.out.println("Elige una opcion:");
		System.out.println("1- Verificar si la lista esta vacia");
		System.out.println("2- Insertar elemento");
		System.out.println("3- Eliminar elemento");
		System.out.println("4- Cantidad de elementos");
		System.out.println("5- Mostrar elementos");
		System.out.println("6- Salir ");
		op=entrada.nextInt();
		switch (op) {
		case 1:
			System.out.println(lista.listaVacia() ?"La lista esta vacia":"La lista no esta vacia");
			break;
		case 2:
			int dato=0;
			String op2="";
			do {
				entrada.nextLine();
				System.out.println("A) Insertar al inicio de la lista");
				System.out.println("B) Insertar al Final de la lista");
				System.out.println("C) Regresar al menu principal");
				op2=entrada.nextLine().toUpperCase();
				switch(op2) {
				case "A":
					System.out.print("Ingresa el dato: ");
					dato=entrada.nextInt(); System.out.println();
					lista.agregarElementoAlInicio(dato);
					break;
				case "B":
					System.out.print("Ingresa el dato: ");
					dato=entrada.nextInt(); System.out.println();
					lista.agregarElementoAlFinal(dato);
					break;
				case "C":
					System.out.println("Regresando al menu principal");
					break;
					default:
						System.out.println("Elige una opcion disponible");
						break;
				}
			}while(!(op2.equalsIgnoreCase("A") ||op2.equalsIgnoreCase("B") ||op2.equalsIgnoreCase("C") ));
			break;
		case 3:
			do {
				entrada.nextLine();
				System.out.println("A) Eliminar al inicio de la lista");
				System.out.println("B) Eliminar al Final de la lista");
				System.out.println("C) Eliminar dato especifico");
				op2=entrada.nextLine().toUpperCase();
				switch(op2) {
				case "A":
					lista.eliminarElementoInicial();
					break;
				case "B":
					lista.eliminarElementoInicial();
					break;
				case "C":
					System.out.println("Ingresa el dato");
					int datoEliminar=entrada.nextInt();
					int num=lista.eliminarDatoEspecifico(datoEliminar);
					if(num==-1) {
						System.out.println("Lista vacia");
					}else {
						System.out.println(num==-2?" Dato no encontrado" :"Se elimino el dato "+num+" correctamente");
					}
					
					break;
					default:
						System.out.println("Elige una opcion disponible");
						break;
				}
			}while(!(op2.equalsIgnoreCase("A") ||op2.equalsIgnoreCase("B")||op2.equalsIgnoreCase("C")));
			break;
		case 4:
			lista.mostrarCantidadElementos();
			break;
		case 5:
			lista.mostrarListaEnlazada();
			break;
		case 6:
			System.out.println("Programa Finalizado");
			break;
		default:
			System.out.println("Error elige una opcion disponible en el menu");
			break;
		}
		
		}while(op!=6);
	}

}
