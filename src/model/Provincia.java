package model;

/**
 * Created by KCYTVOG on 2/9/2016.
 */

public class Provincia {
	private int codigoProvincia;
	private String descripcion;

	public Provincia() {}

	public Provincia(int codigoProvincia, String descripcion) {
		this.codigoProvincia = codigoProvincia;
		this.descripcion = descripcion;
	}

	public void setCodigoProvincia(int codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public int getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}