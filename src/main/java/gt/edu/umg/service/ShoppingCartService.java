package gt.edu.umg.service;

import gt.edu.umg.entity.Producto;
import gt.edu.umg.entity.ShoppingCart;
import gt.edu.umg.repository.ProductoRepository;
import gt.edu.umg.repository.ShoppingCartRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ShoppingCartService {

    @Inject
    ShoppingCartRepository shoppingCartRepository;

    @Inject
    ProductoRepository productoRepository;

    public List<ShoppingCart> listarCarrito() {
        return shoppingCartRepository.listAll();
    }

    @Transactional
    public ShoppingCart agregarProducto(Integer idProducto, Integer cantidad, String codUsuario) {
        Producto producto = productoRepository.findById(idProducto);
        if (producto == null) {
            throw new IllegalArgumentException("El producto con ID " + idProducto + " no existe.");
        }

        ShoppingCart nuevoItem = new ShoppingCart();
        nuevoItem.setProducto(producto);
        nuevoItem.setCantidad((cantidad != null && cantidad > 0) ? cantidad : 1);
        nuevoItem.setCodUsuario((codUsuario != null && !codUsuario.isEmpty()) ? codUsuario : "henry01");

        shoppingCartRepository.persist(nuevoItem);
        return nuevoItem;
    }

    @Transactional
    public boolean eliminarProducto(Integer idShoppingCart) {
        return shoppingCartRepository.deleteById(idShoppingCart);
    }
}