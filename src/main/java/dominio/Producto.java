package dominio;

public class Producto extends Item{

	@Override
	public boolean generaRemito() {
		return true;
	}
}
