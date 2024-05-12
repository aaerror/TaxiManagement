package model;

/**
 * Created by KCYTVOG on 30/8/2016.
 */

public class TipoDNI {
	private int codigoTipoDNI;
	private String descripcion;

	public TipoDNI() {}

	public TipoDNI(int codigoTipoDNI, String descripcion) {
		this.codigoTipoDNI = codigoTipoDNI;
		this.descripcion = descripcion;
	}

	public void setCodigoTipoDNI(int codigoTipoDNI) {
		this.codigoTipoDNI = codigoTipoDNI;
	}

	public int getCodigoTipoDNI() {
		return codigoTipoDNI;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}