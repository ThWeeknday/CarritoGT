package gt.edu.umg.repository;

import gt.edu.umg.entity.ShoppingCart;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ShoppingCartRepository implements PanacheRepositoryBase<ShoppingCart, Integer> {
}