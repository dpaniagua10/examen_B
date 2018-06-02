package gt.edu.examen;

public class Cola {

	private Nodo raiz, cima;
	
	public Cola() {
		raiz = null;
		cima = null;
	}
	
	public boolean colaVacia() {
		if (raiz == null) {
			return true;
		}else {
			return false;
		}
	}
	
	  public void insertar (Object dato)
	    {
	        Nodo nuevo = new Nodo(dato);        
	        nuevo.siguiente = null;
	        if (colaVacia ()) {
	            raiz = nuevo;
	            cima = nuevo;
	        } else {
	            cima.siguiente = nuevo;
	            cima = nuevo;
	        }
	    }
	
	public Object quitar() {
		if (colaVacia()) {
			System.out.println("Cola Vacia");
			return null;
		}
		Object aux = raiz.elemento;
		if (raiz == cima) {
			raiz = null;
			cima = null;
		}else {
			raiz = raiz.siguiente;
		}
		System.out.println("Eliminado: "+aux);
		return aux;
	}

    public void listar() {
        Nodo t = raiz;
        while (t != null) {
            System.out.println(t.elemento);
            t = t.siguiente;
        }
    }
	
	 public void vaciar() {
			while (!colaVacia()) {
				raiz = raiz.siguiente;
			}
	    }
}
