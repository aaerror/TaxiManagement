package model;

/**
 * Created by KCYTVOG on 3/9/2016.
 */

public class EstadoCoche {
	private int codigoEstadoCoche;
	private String descripcion;

	public EstadoCoche() {}

	public EstadoCoche(int codigoEstadoCoche, String descripcion) {
		this.codigoEstadoCoche = codigoEstadoCoche;
		this.descripcion = descripcion;
	}

	public void setCodigoEstadoCoche(int codigoEstadoCoche) {
		this.codigoEstadoCoche = codigoEstadoCoche;
	}

	public int getCodigoEstadoCoche() {
		return codigoEstadoCoche;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}