package gt.edu.umg.service;

import gt.edu.umg.entity.Producto;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

@QuarkusTest
public class ProductoServiceTest {

    @Inject
    ProductoService productoService;

    @Test
    public void testListarProductos() {
        List<Producto> productos = productoService.listarProductos();
        Assertions.assertNotNull(productos);
        Assertions.assertFalse(productos.isEmpty());
    }

    @Test
    public void testBuscarProductoPorIdExistente() {
        Producto producto = productoService.buscarPorId(1);
        Assertions.assertNotNull(producto);
        Assertions.assertEquals("3DcAM01", producto.getCodigo());
    }

    @Test
    public void testBuscarProductoPorIdInexistente() {
        Producto producto = productoService.buscarPorId(999);
        Assertions.assertNull(producto);
    }
}