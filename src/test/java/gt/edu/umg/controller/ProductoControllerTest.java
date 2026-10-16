package gt.edu.umg.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class ProductoControllerTest {

    @Test
    public void testEndpointListarProductos() {
        given()
                .when().get("/api/productos")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    public void testEndpointBuscarProductoPorId() {
        given()
                .when().get("/api/productos/1")
                .then()
                .statusCode(200)
                .body("codigo", is("3DcAM01"));
    }
}