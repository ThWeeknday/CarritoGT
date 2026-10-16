package gt.edu.umg.service;

import gt.edu.umg.entity.ShoppingCart;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

@QuarkusTest
public class ShoppingCartServiceTest {

    @Inject
    ShoppingCartService shoppingCartService;

    @Test
    public void testListarCarrito() {
        List<ShoppingCart> carrito = shoppingCartService.listarCarrito();
        Assertions.assertNotNull(carrito);
    }

    @Test
    public void testAgregarYEliminarProducto() {
        ShoppingCart creado = shoppingCartService.agregarProducto(1, 2, "henry01");
        Assertions.assertNotNull(creado.getIdShoppingCart());
        Assertions.assertEquals(2, creado.getCantidad());

        boolean eliminado = shoppingCartService.eliminarProducto(creado.getIdShoppingCart());
        Assertions.assertTrue(eliminado);
    }

    @Test
    public void testAgregarProductoInexistenteLanzaExcepcion() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shoppingCartService.agregarProducto(999, 1, "henry01");
        });
    }
}