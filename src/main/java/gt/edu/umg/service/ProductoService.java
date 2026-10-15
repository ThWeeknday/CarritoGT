package gt.edu.umg.service;

import gt.edu.umg.entity.Producto;
import gt.edu.umg.repository.ProductoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ProductoService {

    @Inject
    ProductoRepository productoRepository;

    public List<Producto> listarProductos() {
        return productoRepository.listAll();
    }

    public Producto buscarPorId(Integer idProducto) {
        return productoRepository.findById(idProducto);
    }
}