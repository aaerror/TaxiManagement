package model;

/**
 * Created by KCYTVOG on 30/8/2016.
 */

public class Sexo {
	private int codigoSexo;
	private String descripcion;

	public Sexo() {}

	public Sexo(int codigoSexo, String descripcion) {
		this.codigoSexo = codigoSexo;
		this.descripcion = descripcion;
	}

	public void setCodigoSexo(int codigoSexo) {
		this.codigoSexo = codigoSexo;
	}

	public int getCodigoSexo() {
		return codigoSexo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}