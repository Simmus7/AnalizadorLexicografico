package Trabajos;

import java.util.Arrays;

import javax.swing.table.DefaultTableModel;

import java.awt.EventQueue;
import java.io.*;
import java.util.ArrayList;





public class Compilador {

	
	
	
	//Método en el que se crea y se retorna la tabla que contiene los elementos 
	//de mi lenguaje de programación parcial
	public ArrayList <Elemento> creacionTabla () {
		
		//Tabla de símbolos a retornar
		ArrayList <Elemento> tablaDeSimbolos = new ArrayList <Elemento>();

		//Elementos no separadores
		Elemento e1 = new Elemento ("public", false);
			e1.addTipo ("Palabra Clave");
			
		Elemento e2 = new Elemento ("return", false);
			e2.addTipo ("Palabra Clave");
			
		Elemento e3 = new Elemento ("private", false);
			e3.addTipo ("Palabra Clave");
		
		Elemento e7 = new Elemento ("static", false);
			e7.addTipo ("Palabra Clave");
		
		Elemento e8 = new Elemento ("void", false);
			e8.addTipo ("Palabra Clave");
			
		Elemento e11 = new Elemento ("int", false);
			e11.addTipo ("Palabra Clave");
			e11.addTipo("Tipo de Dato");
			e11.addTipo("Identificador");
			
		
		// Elemtos separadores (entonces se les envía true como parámetro del constructor)
		Elemento e4 = new Elemento (" ", true);
		   e4.addTipo ("Separador");
		Elemento e5 = new Elemento ("(", true);
			e5.addTipo ("Separador");
		Elemento e6 = new Elemento (";", true);
			e6.addTipo ("Separador");
		Elemento e9 = new Elemento ("{", true);
			e9.addTipo ("Separador");
			e9.addTipo("Agrupador de codigo");
		Elemento e10 = new Elemento ("}", true);
			e10.addTipo ("Separador");
			e10.addTipo("Agrupador de codigo");
		//Agrego el tab, son 4 espacios al parecer
		Elemento e12 = new Elemento ("\t", true);
			e12.addTipo ("Separador");
			e12.addTipo("TAB");
 
		tablaDeSimbolos.add(e1);
		tablaDeSimbolos.add(e2);
		tablaDeSimbolos.add(e3);
		tablaDeSimbolos.add(e4);
		tablaDeSimbolos.add(e5);
		tablaDeSimbolos.add(e6);
		tablaDeSimbolos.add(e7);
		tablaDeSimbolos.add(e8);
		tablaDeSimbolos.add(e9);
		tablaDeSimbolos.add(e10);
		tablaDeSimbolos.add(e11);
		tablaDeSimbolos.add(e12);
		
		
		return tablaDeSimbolos;

	}

	//Método para leer el archivo en el que está el código fuente de mi lenguaje de programación
	//Retorna una matriz de caracteres
	public char[][] leerArchivo () throws IOException {	
		  
		File archivo = null;
		FileReader f = null;
		BufferedReader br = null;

		archivo = new File ("src/Trabajos/Fichero.txt");
		f = new FileReader (archivo);
		br = new BufferedReader (f);
		
		String linea = br.readLine();
		char toReturn [][] = new char [0][0];
		char [] temp;
		
		while (linea != null){
			temp = new char[linea.length()];
			temp = linea.toCharArray();
			
			toReturn = Arrays.copyOf(toReturn, toReturn.length+1);
			toReturn [toReturn.length-1] = new char [temp.length];
			toReturn [toReturn.length-1] = temp;
			linea = br.readLine();
		}
		
		br.close();
		return toReturn; 

	}

	//Imprime la matriz de caracteres
	public void impMatriz (char [][] matriz) {
		for (int x=0; x < matriz.length; x++) {
			for (int y=0; y < matriz[x].length; y++) {
			  System.out.print (matriz[x][y]);
			  if (y!=matriz[x].length-1) System.out.print(" ");
			}
			System.out.println("\n");
		  }
	}

	//Busca un elemento dentro de la tabla de símbolos (servirá para el analizador léxico)
	public Elemento buscarElemento (ArrayList <Elemento> tablaDeSimbolos, String toSearch){
		Elemento temp = null;
		int i = 0;
		while (i<tablaDeSimbolos.size()){
			if (tablaDeSimbolos.get(i).getCadena().equals(toSearch)) {
				temp = new Elemento (tablaDeSimbolos.get(i).getCadena(), tablaDeSimbolos.get(i).getIsSeparador());
				temp.setTipos(tablaDeSimbolos.get(i).getTipos());
				break;
			}
			i++;
		}

		return temp;

	}
		
	//Método que retorna la tabla final de Elementos dentro del fichero
	//Lo que hace es recorrer la matriz casilla por casilla, adquiriendo la cadena que se va formando
	//Y teniendo en cuenta los separadores para identificar cada elemento 
	public ArrayList <Elemento> analisisLexico (char [][] matriz, ArrayList <Elemento> tablaDeSimbolos){
		//Creo la tabla final a retornar 
		ArrayList<Elemento> tablaFinal = new ArrayList <Elemento>();
		//Y las variables necesarias
		String acumulador = "";
		String posibleSeparador = "";
		Elemento temp = null;
		Elemento aux = null;

		//Ciclos para recorrer la matriz
		for (int fila = 0; fila<matriz.length; fila++){
			for (int col = 0; col<matriz[fila].length; col++){
				//Si temp es nulo
				//significa que el elemento anterior no es un separador, 
				//entonces puedo entrar a seguir leyendo
				
				if (temp == null) {
					
					//Si estoy en la última columna de alguna fila de mi matriz
					//Debo fijarme si el elemento es un separador o no
					//si lo es, lo agrego a la tabla
					//si no lo es, agrego el caracter al acumulador y posteriormente a la tabla
					if (col==matriz[fila].length-1){
						acumulador = acumulador + matriz[fila][col];
					    aux = buscarElemento (tablaDeSimbolos, acumulador);
					    if (aux == null) {
					    	
					    	aux = new Elemento (acumulador, false);
					    	aux.setPosicion(fila+1, col-acumulador.length()+2);
					    	aux.addTipo("Identificador");
					    	acumulador ="";
					    	tablaFinal.add(aux);
					    }
					    else {
					    	tablaFinal.add(aux);
					    	aux.setPosicion(fila+1, col-acumulador.length()+2);
					    	acumulador ="";
					    }
						
					}
					
					//Si en cambio no estoy en la última columna
					//Debo seguir recorriendo la siguiente casilla, agregarla y fijarme si hay
					//un separador próximo
					else if (col!=matriz[fila].length-1) {
						
						//Tengo que considerar si en la primera columna de mi fila 
						//Hay un separador
						//Si es así lo guardo en la tabla final
						if (col == 0) {
							aux = buscarElemento (tablaDeSimbolos, ""+matriz [fila][col]);
							if (aux != null) {
								aux.setPosicion(fila+1, 1);
								tablaFinal.add(aux);
							}
							
							
						}
						//Si en mi primera columna no había un separador o no estoy en mi primera columna
						//debo seguir leyendo normalmente
						if (aux == null || col != 0 ){
						
						acumulador = acumulador + matriz[fila][col];
						posibleSeparador =""+matriz[fila][col+1];
						
						temp = buscarElemento(tablaDeSimbolos, posibleSeparador);
						
						
						//Si el caracter siguiente a mi acumulador es un separador
						//Entonces separo la cadena 
						if (temp != null && temp.isSeparador==true && col != 0){
							
							//Busco si la cadena resultante en acumulador 
							//ya partenece a la tabla de símbolos
							//y si no pertenece, agrego acumulador como identificador
							aux = buscarElemento (tablaDeSimbolos, acumulador);
							if (aux != null){
								aux.setPosicion(fila+1, col-acumulador.length()+2);
								acumulador ="";
								tablaFinal.add(aux);

							}
							else{
								aux = new Elemento (acumulador, false);
								aux.setPosicion(fila+1, col-acumulador.length()+2);
								aux.addTipo("Identificador");
								acumulador ="";
								tablaFinal.add(aux);

							}
							//Agrego el separador y su posicion a la tabla 
							temp.setPosicion(fila+1, col+2);
							tablaFinal.add(temp);
						}	
						
						//Si el caracter leído no fue un separador, no hago nada y sigo recorriendo

				
					}

				}


			 }
			 else {
				
				 temp = null;
			 }
				
				

					//Si estoy en la última columna pero no 
				    // en la última fila añado un salto de línea a la tabla de simbolos
				
					if (col == matriz[fila].length-1 && fila != matriz.length-1) {
						aux = new Elemento ("SaltoDeLinea", true);
						aux.setPosicion(fila+1, col+2);
						aux.addTipo("Separador");
						tablaFinal.add(aux);
						}
		}
			
			
			//Fuera del for que recorre las columnas, si estoy
			//en una fila cuya cantidad de columnas es 0
			//significa que hay un salto de línea
			//así que lo agrego
			
			if (matriz[fila].length == 0) {
				aux = new Elemento ("SaltoDeLinea", true);
				aux.setPosicion(fila+1, 1);
				aux.addTipo("Separador");
				tablaFinal.add(aux);
				}


		}
		return tablaFinal;

	}


	public void imprimirTablaFinal (ArrayList <Elemento> tablaFinal){
		Elemento aux;
		for (int i = 0; i<tablaFinal.size(); i++){
			aux = tablaFinal.get(i);
			System.out.print(aux.getCadena() + " -- " + aux.getPosicion().fila + ", " + aux.getPosicion().columna + " -- " + aux.tiposEnCadena());
			System.out.println();
			
		}





	}

	
	public static void main (String [] args) {
		
		System.out.println();
		Compilador c = new Compilador ();
		
		char [][] matrizPrincipal = null;
	   try {
		matrizPrincipal = c.leerArchivo();
		
	   }
	   

	   catch (IOException e)  {
		System.out.println("Excepcion, no se pudo leer el archivo");
	   }	
	 //Cramos las tablas necesarias y activamos las interfaces gráficas creadas
	   ArrayList <Elemento> tablaDeSimbolos = c.creacionTabla();   
	   ArrayList <Elemento> tablaFinal = c.analisisLexico(matrizPrincipal, tablaDeSimbolos);
	   InterfazGrafica ig = new InterfazGrafica ();
	   DefaultTableModel tabla = new DefaultTableModel();
	   DefaultTableModel tablaSimbolos = new DefaultTableModel();
	   tablaSimbolos = ig.generarModeloTablaSimbolos(tablaDeSimbolos);
	   tabla = ig.generarModeloTabla(tablaFinal);
	   Graficador2 ventanaInicial = new Graficador2 (tabla,tablaSimbolos);
	   
	   EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					ventanaInicial.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	   
	   
	   
	   
	   
	   
	  



	
		

	

	   System.out.println();
	}
}

