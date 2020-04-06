package excepciones;

public class NoSePuedeCambiarPrecioItemException extends Exception {

	public NoSePuedeCambiarPrecioItemException() {
		super("No se puede cambiar precio item por operacion cerrada");
	}

}
