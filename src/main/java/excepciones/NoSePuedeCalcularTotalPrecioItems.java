package excepciones;

public class NoSePuedeCalcularTotalPrecioItems extends Exception {
	
	public NoSePuedeCalcularTotalPrecioItems() {
		super("No se puede calcular total precio items porque algunos precios son menores o iguales a cero");
	}

}
