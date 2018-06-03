package gt.edu.examen;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Cola {    
    
    private Nodo raiz;
    private Nodo cima;
    
    public Cola() {
        raiz = null;
        cima = null;
    }
    
    public boolean colaVacia (){
        if (raiz == null)
            return true;//si esta vacia
        else
            return false;//si tiene elementos
    }

    public void insertar (Cliente dato){
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

    public Cliente quitar(){
        if (colaVacia()) {
        	System.out.println("La cola esta vacia");
        	return null;
        } 
        Cliente aux = raiz.elemento;
        if (raiz == cima){
            raiz = null;
            cima = null;
        } else {
            raiz = raiz.siguiente;
        }
        System.out.println("Cliente atentido: ");
        System.out.println("Nombre: "+aux.getNombre());
        System.out.println("DPI: "+aux.getDpi()+"\n");
        return aux;
    }
    
    public Cliente guardar(String ruta){
    	RandomAccessFile raf = null;
    	if (colaVacia()) {
        	System.out.println("La cola esta vacia");
        	return null;
        } 
        Cliente aux = raiz.elemento;
        if (raiz == cima){
            raiz = null;
            cima = null;
        } else {
            raiz = raiz.siguiente;
        }
        try {
			raf = new RandomAccessFile(ruta,"rw");
			raf.seek(raf.length());
			raf.writeUTF(aux.getNombre());
			raf.writeUTF(aux.getDpi());
		} catch (IOException e) {
			//captura errores de la clase e/s
		}finally {
			try {
				raf.close();//cierra archio
			} catch (IOException e) {
				//captura errores
			}
		}
        return aux;
    }
    
    public void listarc() {
        if(colaVacia()) {
        	
        }else {
        	Nodo t = raiz;
            System.out.println("\tCliente(s) en Cola:\n");
            while (t != null) {
                System.out.println("\tNombre: "+t.elemento.getNombre());
                System.out.println("\tDPI: "+t.elemento.getDpi());
                t = t.siguiente;
            }
            System.out.println("\n");
        }
    }
    
    public void listarUno() {
    	Nodo t = raiz;
    	System.out.println("Siguiente: ");
    	System.out.println("\tNombre: "+t.elemento.getNombre());
        System.out.println("\tDPI: "+t.elemento.getDpi());
    }
    
    public void vaciar() {
		while (!colaVacia()) {
			raiz = raiz.siguiente;
		}
    }
    
}
