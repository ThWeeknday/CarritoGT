package gt.edu.umg.controller;

import gt.edu.umg.entity.Producto;
import gt.edu.umg.service.ProductoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoController {

    @Inject
    ProductoService productoService;

    @GET
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @GET
    @Path("/{id}")
    public Producto buscarPorId(@PathParam("id") Integer id) {
        return productoService.buscarPorId(id);
    }
}