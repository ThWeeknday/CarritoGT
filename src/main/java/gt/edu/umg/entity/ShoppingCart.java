package gt.edu.umg.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idShoppingCart")
    private Integer idShoppingCart;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @Column(name = "codUsuario")
    private String codUsuario;

    @Column(name = "cantidad")
    private Integer cantidad;

    public ShoppingCart() {}

    public Integer getIdShoppingCart() { return idShoppingCart; }
    public void setIdShoppingCart(Integer idShoppingCart) { this.idShoppingCart = idShoppingCart; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public String getCodUsuario() { return codUsuario; }
    public void setCodUsuario(String codUsuario) { this.codUsuario = codUsuario; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}