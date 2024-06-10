package analizador;

public class Ensamble {

	private String etiqueta;
	private String instruccion;
	private String regUno;
	private String regDos;

	public Ensamble(String etiqueta, String instruccion, String regUno, String regDos) {
		this.etiqueta = etiqueta;
		this.instruccion = instruccion;
		this.regUno = regUno;
		this.regDos = regDos;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getInstruccion() {
		return instruccion;
	}

	public void setInstruccion(String instruccion) {
		this.instruccion = instruccion;
	}

	public String getRegUno() {
		return regUno;
	}

	public void setRegUno(String regUno) {
		this.regUno = regUno;
	}

	public String getRegDos() {
		return regDos;
	}

	public void setRegDos(String regDos) {
		this.regDos = regDos;
	}
}
