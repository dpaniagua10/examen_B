package gt.edu.examen;

import java.io.File;
import java.util.Scanner;

public class Principal {

	static final String ruta = "cola.txt";
	Scanner scan = new Scanner(System.in);
	boolean alerta = false;
	Cliente cliente = new Cliente();
	Cola cola = null;
	
	public static void main(String[] args) {
		
		Principal m = new Principal();
		m.menuJeans();
		
		

	}


	public void menuJeans() {
		String n = "";
		String dpi = "";
		int op = 0;
		int contador = 1;
		if (cola == null) {
			cola = new Cola();
		}
		do {
			System.out.println("\tBienvenido");
			System.out.println("\tConfecciones L'Jeans ");
			System.out.println("\n1. Generar nuevo ticket ");
			System.out.println("2. Listar ticket's pendientes");
			System.out.println("3. Eliminar ticket (cliente atendido)");
			System.out.println("4. Guardar ticket's Pendientes");
			System.out.println("5. Salir");
			System.out.println("Ingrese opcion: ");
			alerta = false;
			do {
				try {
					op = Integer.parseInt(scan.nextLine());
					alerta = true;
				}catch(NumberFormatException e) {
					alerta = false;
				}
			}while(!alerta);
			
			switch(op) {
			case 1:
				System.out.println("Ingrese nombre cliente: ");
				n = scan.nextLine();
				System.out.println("Ingrese DPI cliente");
				dpi = scan.nextLine();
				cliente.setNombre(n);
				cliente.setDpi(dpi);
				
				
				mostrarCliente(cliente);
				System.out.println("Ingrese 1 para guardar, 0 para cancelar");
				
				alerta = false;
				do {
					try {
						op = Integer.parseInt(scan.nextLine());
						alerta = true;
					}catch(NumberFormatException e) {
						alerta = false;
					}
				}while(!alerta);
				
				if(op==1) {
					cola.insertar(cliente);
					System.out.println("Ticket No.: "+contador);
					contador++;
				}else {
					System.out.println("Se cancelo el ticket");
				}
				break;
			case 2:
				cola.listar();
				break;
			case 3:
				cola.quitar();
				break;
			case 4:
				System.out.println("Que tenga un feliz dia");
				break;
			case 5:
				
				break;
			default:
				System.out.println("Opcion no valida \n");
			
			}
			
		}while(op!=5);
		
	}
	
	public boolean verificar() {
		File f = new File(ruta);
		return f.exists();
	}
	public void mostrarCliente(Cliente cliente) {
		System.out.println("Su registro es: ");
		System.out.println("Nombre: "+cliente.getNombre());
		System.out.println("DPI: "+cliente.getDpi());
	}
}
