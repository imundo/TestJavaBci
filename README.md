# TestJavaBci


##Actuator - Endpoint

https://drive.google.com/file/d/1CDp3Qa4josx3TwwGIUKm41RJD9D2m1cG/view?usp=sharing
<img align="center" width="100" height="100" src="[https://picsum.photos/100/100](https://drive.google.com/file/d/1CDp3Qa4josx3TwwGIUKm41RJD9D2m1cG/view?usp=sharing)">
## Registro de usuario

Enviar el siguiente json para los registros:

```json
 {
        "name": "Pedro Perez",
        "email": "pedroPerez@gmail.org",
        "password": "Clave12345",
        "phones": [
            {
                "number": "97777875",
                "citycode": "3",			
                "contrycode": "56"
            }
        ]
}
```
Endpoint: {path}/app/register

## login de usuario

Enviar username y password por ejemplo:
```json
{
    "username": "pedroPerez@gmail.org",
    "password" : "Clave12345"
}

```
Endpoint: {path}/app/login

## Perfil de usuario

Enviar id generado en por el registro Ejemplo:
```json

{
    "id": "045c5f42-2f1d-44e7-b902-406571217a79",
    "created": "2023-11-24 01:48",
    "modified": "2023-11-24 01:48",
    "last-login": "2023-11-24 01:48",
    "isactive": "activo",
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqdWFuQHJvZHJpZ3Vlei5vcmciLCJzdWIiOiJodW50ZXIyIiwiZXhwIjoxNzAwNzkyMzMwfQ.C8Axodoi6X7pbVoGDJaOCssQKBW7TFvxpvKkXjPx590"
}
```
EndPoint:

{path}/app/pruebaBci/profile/045c5f42-2f1d-44e7-b902-406571217a79

Se tiene que agregar el Header
X-auth-token : {token que se ha generado}

Para la documentación con Swagger el Endpoint es el siguiente:
/swagger-ui/index.html

