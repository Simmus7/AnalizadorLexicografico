package Trabajos;

public class AnalizadorSintacticoDeExpresionesAritmeticas {
	String cadena;
	int posicion = 0;
	boolean isAccepted = false;
	char cActual;

	public AnalizadorSintacticoDeExpresionesAritmeticas (String cadena) {
		this.cadena = cadena;
		cActual = cadena.charAt(posicion);
		
	}
	
	
	public void Analizar() throws ErrorEnLaSintaxis {
		EXPR();
	}
	

    public void EXPR() throws ErrorEnLaSintaxis{
		TERM ();
		EXPR_PRIMA();
		
	}
	public void EXPR_PRIMA () throws ErrorEnLaSintaxis {
		if (cActual == '+' || cActual == '-') {
			HacerMatch(cActual);
		    TERM ();
		    EXPR_PRIMA();
		}
		
		else {
			
			
			;
		}
		
		
	}
	public void TERM() throws ErrorEnLaSintaxis {
		
	    FACT();
	    TERM_PRIMA();

}

	public void TERM_PRIMA() throws ErrorEnLaSintaxis {
	    if(cActual == '*' || cActual == '/') {
	    	HacerMatch(cActual);
	        FACT();
	        TERM_PRIMA();
	    }
	    else {
	    	;
	    }
	}
	
	public void FACT() throws ErrorEnLaSintaxis {
	    if(cActual== '(') {
	    	HacerMatch(cActual);
	        EXPR();
	        if(cActual == ')') {
		        HacerMatch(cActual);
		    }
	        else {
	        	//ERROR POR SI NO CIERRA PARENTESIS
	        	isAccepted  = false;
	        	throw (new ErrorEnLaSintaxis(posicion+1));
	        	
	        }
	        
	    }
	    
	    else {
	       NUMS();
	    }

	}
	
	
	public void NUMS () throws ErrorEnLaSintaxis {
		
		if (isN(cActual)) {
			HacerMatch(cActual);
		}
		else {
			isAccepted = false;
			throw (new ErrorEnLaSintaxis(posicion+1));
		}
		NUMS_PRIMA ();
	}
	public void NUMS_PRIMA () throws ErrorEnLaSintaxis {
		if (isN(cActual)) {
			HacerMatch(cActual);
			NUMS_PRIMA();
		}
		else {
			;
		}
		
	}
	
	 public void HacerMatch(char t) {
		cActual = ObtenerToken();
	}
	

    public char ObtenerToken () {
    	if (posicion < cadena.length()-1) {
    		posicion = posicion+1;
        	return cadena.charAt(posicion);
    	}
    	else {
    		//Devuelvo caracter que NUNCA VA A ESTAR EN UNA ARITMÉTICA PARA FINES LOGICOS (para que el algoritmo se pueda devolver en 
    		//las diferentes recursividades devolviendo vacío)
    		isAccepted = true;
    		return '$';
    	}
    	
    }

    //Es posible que exista un error en la cadena pero que no entre a las validaciones de error
    //Para saberlo, SE VERIFICA SIEMPRE si toda la cadena fue leida
    //En caso de que TODA la cadena haya sido leída, significa que ésta es aceptada
    public boolean seLeyoTodaLaCadena () throws ErrorEnLaSintaxis {
	if (posicion!=cadena.length()-1) {
		isAccepted = false;
		throw (new ErrorEnLaSintaxis(posicion+1));
	}
	else {
	
		if (!isAccepted) {
			throw (new ErrorEnLaSintaxis(posicion+1));
		}
		return isAccepted;
	}
	
  }

  





//Método que retorna true si el caracter ingresado es un dígito 
public boolean isN(char a) {
    boolean res = false;
    	if(a=='1' || a=='2' || a=='3' || a=='4' || a=='5' || a=='6' || a=='7'||  a=='8'||  a=='9' || a=='0') {
    		res = true;
    	}
    return res;
}





/*public static void main (String [] args) {
	AnalizadorSintacticoDeExpresionesAritmeticas a = new AnalizadorSintacticoDeExpresionesAritmeticas("21341234*+(23452345)");
	try {
		a.Analizar();
	    a.seLeyoTodaLaCadena();
	}
	catch (Exception e) {
		
	}
	
}*/

	
	
	
	

}
