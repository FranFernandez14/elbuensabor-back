# Querys para la API

Las querys se organizan según la entidad con la que más se relacionan, por lo que la ruta para invocarlas siempre es:

`/api/v1/{entidad}/{método}`

Para todas las entidades, se provee los siguientes métodos de acceso a la base de datos:

* GET: obtener todas las filas.
* GET `/paged`: obtener todas las filas con paginación
* GET `/{id}`: obtener la fila con la id especificada
* POST: crear una nueva fila
* PUT `/{id}`: modificar la fila con la id especificada
* DELETE `/{id}`: eliminar la fila con la id especificada

## Querys Personalizadas

### Usuario

* PUT `/cambiarContrasena`: cambiar la contraseña del usuario. Argumentos:
  * id: id del usuario
  * contrasenaActual: contraseña actual del usuario, a cambiar
  * contrasenaNueva: nueva contraseña del usuario

* PUT `/cambiarDatos`: cambiar datos generales del usuario. Argumentos:
    * id
    * nombre
    * apellido
    * telefono
    * rol
    * email
    * direccion

### Producto

* GET `porRubro/{denominacion}`: devuelve todos los productos de un cierto RubroProducto.

* GET `buscar`: devuelve los productos encontrados según su nombre. Argumentos:
  * s: cadena a buscar

### Pedido

* PUT `estado`: actualiza el estado de un pedido. Argumentos:
  * id: id del pedido
  * estado: el nuevo estado que se le colocará