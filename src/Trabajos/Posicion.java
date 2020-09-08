package Trabajos;

public class Posicion {
	
	//Clase muy sencillita, en realidad podría guardar tanto la fila como la columna 
	//separadas en la clase elemento, pero así es más organizado
    public Posicion (int fila, int columna){

        this.fila = fila;
        this.columna  = columna;
    }
    
    


    int fila, columna;
    
    
    
    public String posicionComoString () {
    	
    	String k = fila + "," +columna;
    	return k;
    }
}