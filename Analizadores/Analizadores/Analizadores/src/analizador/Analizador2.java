
package analizador;

public class Analizador2 {

    private String Lexema = "";
    private String Tipo="";
    private String Linea="";
    private String TokErr="";
    private String ErrorDesc="";
    private String TokEsp="";
    private String Asignacion="";
    
    public Analizador2(){
        
    }
    public Analizador2(String Asignacion){
        this.Asignacion=Asignacion;
    }
    public Analizador2(String lex,String tip,String linea_Error,String tok, String desc, String TK){
        this.Lexema = lex;
        this.Tipo = tip;
        this.Linea=linea_Error;
        this.TokErr = tok;
        this.ErrorDesc = desc;
        this.TokEsp = TK;
    }
    public String getLexema() {
        return Lexema;
    }
    
     public String getTipo() {
        return Tipo;
    }
    public String getLinea() {
        return Linea;
    }
    
    public String getToken() {
        return TokErr;
    }
    public String getErrorD() {
        return ErrorDesc;
    }
     public String getTokenEs() {
        return TokEsp;
    }
    public String getAsig() {
        return Asignacion;
    }
    public void setLinea(String linea_Error) {
        this.Linea = linea_Error;
    }

    public void setLexema(String lex) {
        this.Lexema = lex;
    }
 
    public void setTipo(String tip) {
        this.Tipo = tip;
    }
    public void setToken(String tok) {
        this.TokErr = tok;
    }
    public void seteErrorD(String desc) {
        this.ErrorDesc = desc;
    }
    public void setTokenEs(String toki) {
        this.TokEsp = toki;
    }
    public void setAsig(String tokie) {
        this.Asignacion = tokie;
    }
}
