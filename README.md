# CarritoGT API — Backend REST con Java y Quarkus

API REST monolítica desarrollada bajo una arquitectura por capas para la gestión del catálogo de productos y carrito de compras, conectada al esquema relacional `cc` en MySQL.

## Stack Tecnológico
* **Entorno Virtualizado:** Ubuntu 26.04 LTS sobre VMware Fusion
* **Lenguaje y Framework:** Java 25 + Quarkus 3.40.1 (`quarkus-rest-jackson`, `quarkus-hibernate-orm-panache`)
* **Base de Datos:** MySQL Community Server 8.4.11 (`quarkus-jdbc-mysql`)
* **Herramientas y Pruebas:** Maven, Lombok, JUnit y RestAssured (`@QuarkusTest`)

## Arquitectura por Capas (`gt.edu.umg`)
* **`entity`**: Mapeo JPA de las tablas `producto` (`Producto.java`) y `shopping_cart` (`ShoppingCart.java`).
* **`repository`**: Acceso a datos mediante `PanacheRepositoryBase` (`ProductoRepository`, `ShoppingCartRepository`).
* **`service`**: Lógica de negocio, validaciones y control transaccional (`ProductoService`, `ShoppingCartService`).
* **`controller`**: Exposición de endpoints REST en formato JSON (`ProductoController`, `ShoppingCartController`).

## Configuración e Inicio Rápido

1. **Importar el esquema de base de datos en MySQL:**
   ```bash
   mysql -u henrymndz -p < script/cc.sql