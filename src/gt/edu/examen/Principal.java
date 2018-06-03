package gt.edu.examen;

import java.io.*;
import java.util.Scanner;

public class Principal {

	static final String ruta = "Clientes_Pendientes.txt";
	Scanner scan = new Scanner(System.in);
	boolean alerta = false;
	Cliente cliente = null; 
	Cola cola = new Cola();
	int contador = 0;
	public static void main(String[] args) {
		
		Principal m = new Principal();
		m.menuJeans();	

	}

	public void menuJeans() {
		int op = 0;
		
		do {
			System.out.println("\tBienvenido");
			System.out.println("\tConfecciones L'Jeans ");
			if(verificar()) {
				System.out.println("\n\tTiene clientes pendientes\n\tSeleccione 5. Gargar Archivo\n");
			}
			System.out.println("\t\tTicket´s Generados: "+contador);
			System.out.println("\n1. Generar nuevo ticket ");
			System.out.println("2. Listar ticket's pendientes");
			System.out.println("3. Atender ticket (Cliente)");
			System.out.println("4. Guardar ticket's Pendientes");
			System.out.println("5. Gargar Archivo (Clientes Pendientes)");
			System.out.println("6. Salir");
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
				cliente = new Cliente();
				System.out.println("Ingrese nombre cliente: ");
				cliente.setNombre(scan.nextLine());
				System.out.println("Ingrese DPI cliente");
				cliente.setDpi(scan.nextLine());
				mostrarC(cliente);
				System.out.println("Ingrese 1 para generar Ticket, 0 para cancelar");
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
					if(contador<=100) {
						contador++;
						System.out.println("Ticket No.: "+contador+"\n");
						cola.insertar(cliente);
					}else {
						contador++;
						System.out.println("Ticket No.: "+contador);
						System.out.println("Cliente sera atendido el siguiente dia\n");
						cola.insertar(cliente);
					}
				}else {
					System.out.println("Ticket´s cancelado\n");
				}
				break;
			case 2:
				cola.listarc();
				break;
			case 3:
				cola.listarUno();
				System.out.println("\nIngrese 1 para atender, 0 para cancelar");
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
					cola.quitar();
				}else {
					System.out.println("Se cancelo");
				}
				break;
			case 4:
				alerta = false;
				do {
					if(cola.colaVacia()) {
						alerta = true;
					}else {
						cola.guardar(ruta);
					}
				}while(!alerta);
				if(cola.colaVacia()) {
					System.out.println("Cliente(s) pendiente(s) Guardado(s) ");
				}
				break;
			case 5:
				DataInputStream dis = null;
				try {
					dis = new DataInputStream(new FileInputStream(ruta));
					do {
						cliente = new Cliente();
						cliente.setNombre(dis.readUTF());
						cliente.setDpi(dis.readUTF());
						cola.insertar(cliente);
						contador++;
					}while(true);
				} catch (IOException e) {
					//captura errores
				}finally {
					try {
						dis.close();
					} catch (IOException e) {
					
					}
				}
				if(!cola.colaVacia()) {
					File f = new File(ruta);
					f.delete();
					
				}
				
				break;
			case 6:
				if(cola.colaVacia()) {
					System.out.println("\nPresione 0 para salir, 1 para regresar");
					alerta = false;
					do {
						try {
							op = Integer.parseInt(scan.nextLine());
							alerta = true;
						}catch(NumberFormatException e) {
							alerta = false;
						}
					}while(!alerta);
				}else {
					System.out.println("Tiene pendientes clientes ");
					System.out.println("Desea guardarlos");
					System.out.println("\nPresione 1 para Guardar y Salir, 0 Salir sin guardar");
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
						alerta = false;
						do {
							if(cola.colaVacia()) {
								alerta = true;
							}else {
								cola.guardar(ruta);
							}
						}while(!alerta);
						if(cola.colaVacia()) {
							System.out.println("Cliente(s) pendiente(s) Guardado(s) ");
						}
						op=0;
					}else {
						
					}
				}
				break;
			case 0:
				System.out.println("Que tenga un feliz dia");
				break;
			default:
				System.out.println("Opcion no valida \n");
				
			}
			
		}while(op!=0);
		
	}
	
	public boolean verificar() {
		File f = new File(ruta);
		return f.exists();
	}
	
	public void mostrarC(Cliente n) {
		System.out.println("\nCliente a registrar: ");
		System.out.println("Nombre: "+n.getNombre());
		System.out.println("DPI: "+n.getDpi()+"\n");
	}

}
