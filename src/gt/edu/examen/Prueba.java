package gt.edu.examen;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Prueba {

	public static void main(String[] args) {
		String ruta = "Clientes_Pendientes.txt";
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(ruta));
			do {
				System.out.println("Nombre: "+dis.readUTF());
				System.out.println(dis.readUTF());
			}while(true);
		} catch (IOException e) {
			
		}

	}

}
