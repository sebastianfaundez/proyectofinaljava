## La siguiente es la explicación de como usar los Endpoints de la API CRUD de usuarios:
### Alumno: Sebastián Faúndez
* Ambas entidades Usuario y Telefono tienen IDs de tipo Bigint(MySQL) / Long(Spring Boot), es decir, no son de tipo UUID. 
* No usa DTOs.
* No usa Swagger.


### La API tiene los siguientes Endpoints:

#### Listar  usuarios:  http://localhost:8080/user/listar/ (vía método GET). 
  
#### Guardar usuario:  http://localhost:8080/user/guardar (vía método POST).
El JSON debe tener la siguiente estructura:
```json  
  {   
  "nombre":"Sebastian Faundez",
  "correo": "sebastian.faundez@gmail.com",
  "password": "ggggggg",
  "isactive": true,
  "telefonos": [
  {
  "numero": "3333333",
  "codCiudad": "32",
  "codPais": "56"
  },
  {
  "numero": "22222222",
  "codCiudad": "32",
  "codPais": "56"
  }

  ]

}
```
#### Editar   usuario:  http://localhost:8080/user/editar/idUsuario (vía método PUT).
  (IMPORTANTE: Además de poner el idUsuario al final de la URL, se debe incluir este también en el cuerpo del JSON con la clave "id", es decir, el JSON debe tener la siguiente estructura:
```json  
{
  "id": 1,
  "correo": "sebastian.faundez@gmail.com",
  "password": "laclave",
  "isactive": true,
  "nombre": "Sebastian Faundez"
  }
  ```
#### Eliminar usuario:  http://localhost:8080/user/delete/idUsuario 
