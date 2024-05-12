package model;

/**
 * Created by KCYTVOG on 1/9/2016.
 */

public class Marca {
	private int codigoMarca;
	private String descripcion;

	public Marca() {}

	public Marca(int codigoMarca, String descripcion) {
		this.codigoMarca = codigoMarca;
		this.descripcion = descripcion;
	}

	public void setCodigoMarca(int codigoMarca) {
		this.codigoMarca = codigoMarca;
	}

	public int getCodigoMarca() {
		return codigoMarca;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}