package Trabajos;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;


public class InterfazGrafica {
	
	
	
	
	public DefaultTableModel generarModeloTabla (ArrayList <Elemento> tablaFinal) {
		
		Vector cabeceras = new Vector ();
		cabeceras.addElement ("Cadena");
		cabeceras.addElement ("Posicion");
		cabeceras.addElement ("Tipo");
		DefaultTableModel tabla = new DefaultTableModel (cabeceras, 0);
		Vector x;
		
		for (int i = 0; i<tablaFinal.size(); i++) {
			x = new Vector ();

			x.addElement(tablaFinal.get(i).getCadena());
			x.addElement(tablaFinal.get(i).getPosicion().posicionComoString());
			x.addElement(tablaFinal.get(i).tiposEnCadena());
			tabla.addRow (x);
			
		}

		
		
		return tabla;
		
	}
	
	
public DefaultTableModel generarModeloTablaSimbolos (ArrayList <Elemento> tablaSimbolos) {
		
		Vector cabeceras = new Vector ();
		cabeceras.addElement ("Cadena");
		cabeceras.addElement ("Tipo");
		DefaultTableModel tabla = new DefaultTableModel (cabeceras, 0);
		Vector x;
		
		for (int i = 0; i<tablaSimbolos.size(); i++) {
			x = new Vector ();
			x.addElement(tablaSimbolos.get(i).getCadena());
			x.addElement(tablaSimbolos.get(i).tiposEnCadena());
			tabla.addRow (x);
			
		}

		
		
		return tabla;
		
	}

}
