
package analizador;

public class Analizador {

    private String Lexema = "";
    private String Tipo="";
    private String Linea="";
    private String TokErr="";
    private String ErrorDesc="";
    private String TokEsp="";
    private String Asignacion="";
    private String Tokenes="";
    private String num="";
    private String objeto="";
    private String fuente="";
    private String operador="";
            
    public Analizador(){
        
    }
    public Analizador(String Asignacion){
        this.Asignacion=Asignacion;
    }
    public Analizador(String lex,String tip,String linea_Error,String tok, String desc, String TK ,  String token){
        this.Lexema = lex;
        this.Tipo = tip;
        this.Linea=linea_Error;
        this.TokErr = tok;
        this.ErrorDesc = desc;
        this.TokEsp = TK;
        this.Tokenes = token;
    }
    public Analizador(String num,String objeto, String fuente, String operador){
         this.num=num;
         this.objeto=objeto;
         this.fuente=fuente;
         this.operador=operador;
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
    public String getTokenes() {
        return Tokenes;
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
    public String getNum() {
        return num;
    }
    public String getObj() {
        return objeto;
    }
    public String getFuente() {
        return fuente;
    }
    public String getOper() {
        return operador;
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
    public void setTokenes(String tok) {
        this.Tokenes = tok;
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
    public void setNum(String num) {
        this.num = num;
    }
    public void setObj(String obj) {
        this.objeto = obj;
    }
    public void setFuente(String fu) {
        this.fuente = fu;
    }
    public void setOper(String op) {
        this.operador = op;
    }
}
