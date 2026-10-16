package gt.edu.umg;

import gt.edu.umg.entity.Producto;
import gt.edu.umg.entity.ShoppingCart;
import org.junit.Assert;
import org.junit.Test;

public class ProductoServiceTest {

    @Test
    public void testCrearProductoYGetters() {
        Producto p = new Producto();
        p.setIdProducto(1);
        p.setNombre("FinePix Pro2 3D Camera");
        p.setCodigo("3DcAM01");
        p.setImagen("images/product/camera.jpg");
        p.setPrecio(671.21);

        Assert.assertEquals(Integer.valueOf(1), p.getIdProducto());
        Assert.assertEquals("3DcAM01", p.getCodigo());
        Assert.assertEquals(Double.valueOf(671.21), p.getPrecio());
    }

    @Test
    public void testAsignarProductoAShoppingCart() {
        Producto p = new Producto();
        p.setIdProducto(4);
        p.setNombre("XP 1155 Intel Core Laptop");

        ShoppingCart item = new ShoppingCart();
        item.setIdShoppingCart(10);
        item.setProducto(p);
        item.setCantidad(2);
        item.setCodUsuario("henry01");

        Assert.assertNotNull(item.getProducto());
        Assert.assertEquals("XP 1155 Intel Core Laptop", item.getProducto().getNombre());
        Assert.assertEquals(Integer.valueOf(2), item.getCantidad());
    }
}