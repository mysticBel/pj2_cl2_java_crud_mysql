package entidad;

public class Equipo {
	//Atributos privados
	private int idequipo;
	private String nombre;
	
	// Constructores
	public Equipo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Equipo(int idequipo, String nombre) {
		super();
		this.idequipo = idequipo;
		this.nombre = nombre;
	}
	
	//Getters y Setters
	public int getIdequipo() {
		return idequipo;
	}
	public void setIdequipo(int idequipo) {
		this.idequipo = idequipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
