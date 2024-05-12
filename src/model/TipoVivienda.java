package model;

/**
 * Created by KCYTVOG on 31/8/2016.
 */

public class TipoVivienda {
	private int codigoVivienda;
	private String descripcion;

	public TipoVivienda() {}

	public TipoVivienda(int codigoVivienda, String descripcion) {
		this.codigoVivienda = codigoVivienda;
		this.descripcion = descripcion;
	}

	public void setCodigoVivienda(int codigoVivienda) {
		this.codigoVivienda = codigoVivienda;
	}

	public int getCodigoVivienda() {
		return codigoVivienda;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}