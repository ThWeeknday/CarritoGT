package gt.edu.umg.repository;

import gt.edu.umg.entity.Producto;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductoRepository implements PanacheRepositoryBase<Producto, Integer> {
}