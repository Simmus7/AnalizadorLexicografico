package Trabajos;
import java.util.ArrayList;
public class Elemento {
    //CLASE ELEMENTO DONDE DEFINO LAS CARACTERÍSTICAS DE UN ELEMENTO DE MI LENGUAJE
	
    String cadena;
    boolean isSeparador;
    ArrayList <String> tipos = new ArrayList <String>();
    Posicion posicion;

  
    //Constructor
    public Elemento (String cadena, boolean isSeparador){
        this.cadena = cadena;
        this.isSeparador = isSeparador; 
    }
    
    
    
    
    //Definir la posicion del elemento	
    public void setPosicion (int fila, int col){
        Posicion temp = new Posicion (fila, col);
        this.posicion = temp;
    }
    
    public Posicion getPosicion (){
       return posicion;
    }
    public boolean getIsSeparador(){
        return isSeparador;
     }
    //Añadir un tipo al arraylist de tipos
    public void addTipo (String tipo){
        this.tipos.add(tipo);
    }
    
    public ArrayList <String> getTipos (){
    	return  tipos;
    }
    //Seleccionar todos los tipos de una vez
    public void setTipos (ArrayList <String> tipos){ 
        this.tipos = tipos;
    }

    public String getCadena (){
        return cadena;
    }

    //Método que retorna un String plano con los tipos (para facilidad al mostrar los tipos en consola)
    public String tiposEnCadena (){
        String toReturn = "";
        for (int i = 0; i<tipos.size(); i++){
        	if (i<tipos.size()-1)
            toReturn = toReturn + " " + tipos.get(i)+ ", ";
        	else 
        	toReturn = toReturn + " " + tipos.get(i);
        }
        return toReturn;
    }







}