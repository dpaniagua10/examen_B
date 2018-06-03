package gt.edu.examen;

public class Cliente {


    private String Nombre;
    private String Dpi;

	public String getNombre() {
        return Nombre;
    }    

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

	public String getDpi() {
		return Dpi;
	}

	public void setDpi(String dpi) {
		Dpi = dpi;
	}
	
	public String toString() {
		return "Cliente: "+Nombre+" DPI: "+Dpi;
	}

      
}
