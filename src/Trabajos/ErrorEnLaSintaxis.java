package Trabajos;

public class ErrorEnLaSintaxis extends Exception  {
    public ErrorEnLaSintaxis(int posicion) {
	super ("Error en la posici�n "+posicion);
 }
}
