package dominio;

public abstract class Item {

	private int importe;
		
	public abstract boolean generaRemito();

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe){
		this.importe = importe;
	}
	
	public boolean esImporteMayorACero(int importe) {
		return importe > 0;
	}
}

