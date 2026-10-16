package gt.edu.umg;

import org.junit.Assert;
import org.junit.Test;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class CarritoApiTest {

    @Test
    public void testEndpointProductosResponde200() throws Exception {
        URL url = URI.create("http://localhost:8080/api/productos").toURL();
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        int codigoHttp = conexion.getResponseCode();
        Assert.assertEquals(200, codigoHttp);
    }

    @Test
    public void testEndpointCarritoResponde200() throws Exception {
        URL url = URI.create("http://localhost:8080/api/carrito").toURL();
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        int codigoHttp = conexion.getResponseCode();
        Assert.assertEquals(200, codigoHttp);
    }
}