package gt.edu.umg.controller;

import gt.edu.umg.entity.ShoppingCart;
import gt.edu.umg.service.ShoppingCartService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("/api/carrito")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ShoppingCartController {

    @Inject
    ShoppingCartService shoppingCartService;

    @GET
    public List<ShoppingCart> verCarrito() {
        return shoppingCartService.listarCarrito();
    }

    @POST
    public Response agregarAlCarrito(
            @QueryParam("idProducto") Integer idProducto,
            @QueryParam("cantidad") @DefaultValue("1") Integer cantidad,
            @QueryParam("codUsuario") @DefaultValue("henry01") String codUsuario) {

        if (idProducto == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("error", "Falta el parámetro idProducto"))
                    .build();
        }

        try {
            ShoppingCart creado = shoppingCartService.agregarProducto(idProducto, cantidad, codUsuario);
            return Response.status(Response.Status.CREATED).entity(creado).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(Map.of("error", e.getMessage()))
                    .build();
        }
    }

    @DELETE
    @Path("/{idShoppingCart}")
    public Response eliminarDelCarrito(@PathParam("idShoppingCart") Integer idShoppingCart) {
        boolean eliminado = shoppingCartService.eliminarProducto(idShoppingCart);
        if (eliminado) {
            return Response.ok(Map.of("mensaje", "Item eliminado del carrito")).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(Map.of("error", "No se encontró el item en el carrito"))
                    .build();
        }
    }
}