# Microservicio de Consulta de Productos por EAN en Mercadona

## Descripción
Este microservicio permite consultar los detalles de un producto basado en el código EAN, el cual sigue un formato específico establecido por Mercadona. Además, el servicio proporciona funcionalidades CRUD para interactuar con las entidades.


🔍 Uso
Consulta de producto por EAN:

Endpoint: GET http://localhost:8080/mercadona-app/producto/8437008123454
Respuesta:

{
    "ean": "8437008459059",
    "nombre": "Producto de Prueba",
    "descripcion": "Este es un producto de prueba.",
    "id_proveedor": {
        "id": 1,
        "nombre": "Proveedor de Prueba",
        "codigo": "8437008"
    },
    "id_destino": {
        "id": 1,
        "nombre": "Destino de Prueba",
        "descripcion": "Este es un destino de prueba."
    }
}

Funcionalidades CRUD:

Agregar producto: POST http://localhost:8080/mercadona-app/crud/12345
Editar producto: PUT http://localhost:8080/mercadona-app/crud/12345
Eliminar producto: DELETE http://localhost:8080/mercadona-app/crud/12345
Obtener todos los productos: GET http://localhost:8080/mercadona-app/crud/12345

✨ Características
Persistencia: Utiliza base de datos H2 para persistencia de datos.
Seguridad: El acceso a la API está protegido mediante tokens JWT.
Cache: Incorpora caché in-memory (Caffeine) para optimizar la consulta de productos.
Gestión de migraciones: Utiliza Flyway para manejar las migraciones de la base de datos.
Validaciones: Se realizan validaciones de campos para asegurar integridad de los datos.
Testing: Implementación de pruebas unitarias y de integración siguiendo TDD.
Documentación: Colección Postman incluida para facilitar las pruebas de la API.
🛠 Tecnologías
Spring Boot
H2 Database
JWT
Caffeine
Flyway
JUnit
Mockito

📘 Buenas Prácticas
Se siguen principios de Clean Code para mantener el código limpio y legible.
Uso de Git con prácticas estándar para la gestión de versiones.
Diseño de la API siguiendo principios RESTful.

❗ Excepciones
El servicio está diseñado para manejar y responder adecuadamente a excepciones, proporcionando mensajes claros y códigos de estado HTTP pertinentes.

👨‍💻 Desarrollado por Jorge Antonio Seoane Espinoza
