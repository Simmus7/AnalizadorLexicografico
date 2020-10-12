package Trabajos;

public class ExpresionAritmetica {

	String cadena;
	Posicion posicion;
	
	
	public ExpresionAritmetica (String cadena){
        this.cadena = cadena; 
    }
	
	
	public void setPosicion (int fila, int col){
        Posicion temp = new Posicion (fila, col);
        this.posicion = temp;
    }
    
    public Posicion getPosicion (){
       return posicion;
    }

    public String getCadena (){
        return cadena;
    }
    
}
