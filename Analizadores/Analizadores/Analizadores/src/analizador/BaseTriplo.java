package analizador;

public class BaseTriplo {
    private int linea;
    private String datoObjeto;
    private String datoFuente;
    private String datoFuente2;
    private String operador;

    public BaseTriplo(int linea, String datoObjeto, String datoFuente, String datoFuente2, String operador) {
        this.linea = linea;
        this.datoObjeto = datoObjeto;
        this.datoFuente = datoFuente;
        this.datoFuente2 = datoFuente2;
        this.operador = operador;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public String getDatoObjeto() {
        return datoObjeto;
    }

    public void setDatoObjeto(String datoObjeto) {
        this.datoObjeto = datoObjeto;
    }

    public String getDatoFuente() {
        return datoFuente;
    }

    public void setDatoFuente(String datoFuente) {
        this.datoFuente = datoFuente;
    }

    public String getDatoFuente2() {
        return datoFuente2;
    }

    public void setDatoFuente2(String datoFuente2) {
        this.datoFuente2 = datoFuente2;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
}
