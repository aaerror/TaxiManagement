package model;

/**
 * Created by KCYTVOG on 30/8/2016.
 */

public class Localidad {
	private int codigoLocalidad;
	private String descripcion;

	public Localidad() {}

	public Localidad(int codigoLocalidad, String descripcion) {
		this.codigoLocalidad = codigoLocalidad;
		this.descripcion = descripcion;
	}

	public void setCodigoLocalidad(int codigoLocalidad) {
		this.codigoLocalidad = codigoLocalidad;
	}

	public int getCodigoLocalidad() {
		return codigoLocalidad;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}