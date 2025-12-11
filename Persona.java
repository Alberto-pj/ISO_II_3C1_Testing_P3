public class Persona {
	private int id;
	boolean plenasFacultades;
	boolean tuvoSintomasInfeccion;
	
	public Persona(int id, boolean plenasFacultades, 
			boolean tuvoSintomasInfeccion) {
		this.id = id;
		this.plenasFacultades = plenasFacultades;
		this.tuvoSintomasInfeccion = tuvoSintomasInfeccion;
	}
	
	public boolean puedeRealizarActividades() {
		return plenasFacultades && !tuvoSintomasInfeccion;
	}
	
	public String toString()
	{
		return "ID:" + id + " plenasFacultades:" + plenasFacultades
				+ " tuvoSintomasInfeccion: " + tuvoSintomasInfeccion;
	}
	
}