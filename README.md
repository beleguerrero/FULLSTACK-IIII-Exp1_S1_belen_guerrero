# Exp1_S1_belen_guerrero
Actividad Formativa 1: Desarrollando nuestro microservicio


## Configuración
- **Puerto:** `8081`
- **URL:** `http://localhost:8081/microservicio/`
- **Base de datos:** Oracle Cloud
- **Tabla:** `libro_desnormalizado`

La conexión a la base de datos debe estar configurada en `application.properties`.

### Oracle Wallet

El proyecto tiene configurada la conexión a Oracle mediante **Oracle Wallet**, ubicado en la siguiente ruta de Windows: `C:/Wallets/Wallet_MIBD_belen_guerrero`

## Endpoints

| Método HTTP | Endpoint | Descripción | Body |
|---|---|---|---|
| GET | `/libros` | Obtener todos los libros. | No requiere |
| GET | `/libros/{id}` | Obtener un libro por su ID. | No requiere |
| POST | `/libros` | Crear un libro. | Sí |
| PUT | `/libros/{id}` | Actualizar un libro existente. | Sí |
| DELETE | `/libros/{id}` | Eliminar un libro por su ID. | No requiere |

### Body para crear y actualizar un libro (POST) / (PUT)

```json
{
  "nombre": "Libro Prueba",
  "autor": "Autor",
  "anoPublicacion": 2020,
  "genero": "Fantasía",
  "codigo": "LIB-001",
  "sinopsis": "Sinopsis de prueba"
}
```



