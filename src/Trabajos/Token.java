package Trabajos;

public class Token {
	String nombreToken;
	int idToken;
	String lexema;
	public Token () {
	
	}
	public Token (String nombreToken, int idToken, String lexemaAceptado) {
		this.nombreToken=nombreToken;
		this.idToken = idToken;
		this.lexema = lexemaAceptado;
	}
	public String getNombreToken() {
		return nombreToken;
	}
	public void setNombreToken(String nombreToken) {
		this.nombreToken = nombreToken;
	}
	public int getIdToken() {
		return idToken;
	}
	public void setIdToken(int idToken) {
		this.idToken = idToken;
	}
	public String getLexema() {
		return lexema;
	}
	public void setLexema(String lexema) {
		this.lexema = lexema;
	}


}
