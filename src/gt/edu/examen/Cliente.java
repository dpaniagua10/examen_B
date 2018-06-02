package gt.edu.examen;

public class Cliente {
	
	private String nombre;
	private String dpi;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDpi() {
		return dpi;
	}
	public void setDpi(String dpi) {
		this.dpi = dpi;
	}

	public String toString() {
		return "Cliente: "+nombre+"\nDPI: "+dpi+"\n";
	}
}
