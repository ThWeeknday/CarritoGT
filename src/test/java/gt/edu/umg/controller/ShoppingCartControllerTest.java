package gt.edu.umg.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ShoppingCartControllerTest {

    @Test
    public void testEndpointVerCarrito() {
        given()
                .when().get("/api/carrito")
                .then()
                .statusCode(200);
    }

    @Test
    public void testEndpointAgregarYEliminarDelCarrito() {
        // 1. Agrega un producto (201 Created) y extrae el idShoppingCart generado
        Integer idGenerado = given()
                .queryParam("idProducto", 1)
                .queryParam("cantidad", 2)
                .queryParam("codUsuario", "henry01")
                .when().post("/api/carrito")
                .then()
                .statusCode(201)
                .extract().path("idShoppingCart");

        // 2. Elimina ese mismo registro (200 OK)
        given()
                .when().delete("/api/carrito/" + idGenerado)
                .then()
                .statusCode(200);
    }

    @Test
    public void testEndpointAgregarSinIdProductoDevuelve400() {
        given()
                .when().post("/api/carrito")
                .then()
                .statusCode(400);
    }

    @Test
    public void testEndpointAgregarProductoInexistenteDevuelve404() {
        given()
                .queryParam("idProducto", 999)
                .queryParam("cantidad", 1)
                .when().post("/api/carrito")
                .then()
                .statusCode(404);
    }
}