package excepciones;

public class NoSePuedeCerrarOperacion extends Exception {

	public NoSePuedeCerrarOperacion() {
		super("No se puede cerrar nuevamente la operacion");
	}

}
