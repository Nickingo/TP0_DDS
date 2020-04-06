package dominio;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.NoSeGeneraRemitoException;

public class CreacionRemitoOperacionTest {

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
			
			listaItems.add(producto1);
			listaItems.add(producto2);
			listaItems.add(producto3);

			remito = new DocumentoComercial("Remito");
			operacion = new Operacion("Egreso",listaItems,remito);
		}
		
		@Test
		public void sePuedeGenerarRemitoDeOperacionOK() throws NoSeGeneraRemitoException{
			Assertions.assertTrue(operacion.sePuedeGenerarRemito());
		}
		
		@Test
		public void calculoTotalPrecioItemsOperacionConPreciosNegativos() throws NoSeGeneraRemitoException{
			listaItems.add(servicio1);
			operacion.setListaItems(listaItems);
			
			Assertions.assertTrue(operacion.sePuedeGenerarRemito());
		}

}
