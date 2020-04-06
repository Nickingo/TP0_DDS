package dominio;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.NoSePuedeCalcularTotalPrecioItems;
import excepciones.NoSePuedeCambiarPrecioItemException;

public class CambioPrecioItemsTest {
	
	private Item producto1;
	private Item producto2;
	private Item producto3;
	private Item servicio1;
	private List<Item> listaItems = new ArrayList<Item>();
	private Operacion operacion;
	private DocumentoComercial remito;
	
	@BeforeEach
	public void setUp() {
		producto1 = new Producto();
		producto2 = new Producto();
		producto3 = new Producto();
		servicio1 = new Servicio();
		
		producto1.setImporte(40);
		producto2.setImporte(30);
		producto3.setImporte(20);
		servicio1.setImporte(10);
		
		listaItems.add(producto1);
		listaItems.add(producto2);
		listaItems.add(producto3);
		listaItems.add(servicio1);

		remito = new DocumentoComercial("Remito");
		
		operacion = new Operacion("Egreso",listaItems,remito);
	}
	
	@Test
	public void cambiarPrecioProductos1y2ParaCalculoTotalItems() throws NoSePuedeCambiarPrecioItemException, NoSePuedeCalcularTotalPrecioItems {
		operacion.cambiarPrecioAItem(producto1, 50);
		operacion.cambiarPrecioAItem(producto2, 60);
		
		Assertions.assertEquals(140, operacion.calcularTotalPrecioItems());
		
	}
	
	@Test
	public void cambiarPrecioProductos1y2ConPreciosNegativosParaCalculoTotalOperacion() throws NoSePuedeCambiarPrecioItemException, NoSePuedeCalcularTotalPrecioItems {
		operacion.cambiarPrecioAItem(producto1, -50);
		operacion.cambiarPrecioAItem(producto2, -60);
		
		Assertions.assertEquals(140, operacion.calcularTotalPrecioItems());
		
	}

}
