package model;

/**
 * Created by KCYTVOG on 31/8/2016.
 */

public class Barrio {
	private int codigoBarrio;
	private String descripcion;

	public Barrio() {}

	public Barrio(int codigoBarrio, String descripcion) {
		this.codigoBarrio = codigoBarrio;
		this.descripcion = descripcion;
	}

	public void setCodigoBarrio(int codigoBarrio) {
		this.codigoBarrio = codigoBarrio;
	}

	public int getCodigoBarrio() {
		return codigoBarrio;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}