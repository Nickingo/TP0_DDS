package dominio;

import java.util.ArrayList;
import java.util.List;
import excepciones.NoSeGeneraRemitoException;
import excepciones.NoSePuedeCalcularTotalPrecioItems;
import excepciones.NoSePuedeCambiarPrecioItemException;
import excepciones.NoSePuedeCerrarOperacion;

public class Operacion {
	
	private List<Item> listaItems = new ArrayList<Item>();
	private DocumentoComercial docComercial;
	private boolean estaCerrado = false;
	
	public Operacion(String tipoOperacion, List<Item> unaListaItems, DocumentoComercial unDocComercial) {
		this.listaItems = unaListaItems;
		this.docComercial = unDocComercial;
	}
	
	public Integer calcularTotalPrecioItems() throws NoSePuedeCalcularTotalPrecioItems{
		
		if(!sePuedeCalcularPrecioItems()) {
			throw new NoSePuedeCalcularTotalPrecioItems();
		}

		return this.listaItems.stream().mapToInt(item->item.getImporte())
                                       .sum();
	}
	
	public boolean sePuedeCalcularPrecioItems() {
		return this.listaItems.stream().allMatch(i->i.esImporteMayorACero(i.getImporte()));
	}
	
	public boolean sePuedeGenerarRemito() throws NoSeGeneraRemitoException {
		boolean b = this.listaItems.stream().allMatch(item->item.generaRemito());	
		
		if(!b) {
			throw new NoSeGeneraRemitoException("No se puede generar el remito");
		}
		
		return b;
	}
	
	public void cerrarOperacion() throws NoSePuedeCerrarOperacion {
		if(this.estaCerrado) {
			throw new NoSePuedeCerrarOperacion();
		}
		this.estaCerrado = true;
	}
	
	public void cambiarPrecioAItem(Item item, int importe) throws NoSePuedeCambiarPrecioItemException {
		if(this.estaCerrado) {
			throw new NoSePuedeCambiarPrecioItemException();
		}
			item.setImporte(importe);
	}
	
	public List<Item> getListaItems() {
		return listaItems;
	}

	public void setListaItems(List<Item> listaItems) {
		this.listaItems = listaItems;
	}

	public DocumentoComercial getDocComercial() {
		return docComercial;
	}

	public void setDocComercial(DocumentoComercial docComercial) {
		this.docComercial = docComercial;
	}
	
	
	

}
