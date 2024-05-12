package model;

/**
 * Created by KCYTVOG on 30/8/2016.
 */

public class Nacionalidad {
	private int codigoNacionalidad;
	private String descripcion;

	public Nacionalidad() {}

	public Nacionalidad(int codigoNacionalidad, String descripcion) {
		this.codigoNacionalidad = codigoNacionalidad;
		this.descripcion = descripcion;
	}

	public void setCodigoNacionalidad(int codigoNacionalidad) {
		this.codigoNacionalidad = codigoNacionalidad;
	}

	public int getCodigoNacionalidad() {
		return codigoNacionalidad;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}