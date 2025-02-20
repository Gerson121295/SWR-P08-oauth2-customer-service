
# Proyecto 08: Seguridad con Oauth2 y openId Connect y Servicio que consume la API 

Este proyecto tiene como objetivo desarrollar una API que consuma la api seguridad basada en OAuth2 y OpenID Connect creada. Para ello, se implementará un servidor de autorización OAuth2 con Spring Security.
Se encargará de validar usando la clave publica para acceso a los recursos protegidos. Para acceder a los recursos definidos en el controlador se requiere que se realice login en el servidor de autorización (aplicacion: security-aouth-jwt) y se obtenga un token de acceso. Para luego agregarlo en el header de la petición. para acceder a los recursos:

<div align="center">
   <h1>Challenge | Java | Back End - SpringBoot | Spring Security Oauth2 - Service-Consumer</h1>
</div>


<p align="center">
  <img src="https://img.shields.io/badge/Status-finalizado-blue"><br>
  <img src="https://img.shields.io/badge/Java-17-red">
<img src="https://img.shields.io/badge/Spring-Security-Oauth2-Orange">
  <img src="https://img.shields.io/badge/Versión-1.0-green">
</p>

👨🏻‍💻 <strong>Gerson Escobedo Pérez </strong></br>
<a href="https://www.linkedin.com/in/gerson-escobedo/" target="_blank">
<img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>

## Funcionamiento
- Requiere levantar el proyecto `security-oauth-jwt` ejecutar la clase main, para obtener el token de acceso.
- Luego Proceder a levantar el proyecto `customer-service` ejecutar la clase main, para consumir la api de seguridad basada en OAuth2 y OpenID Connect.

Para mas informacion del funcionamiento de los enpoints revisar el readme de cada proyecto.

# 💙 Personas Contribuyentes
## Autores
[<img src="https://avatars.githubusercontent.com/u/79103450?v=4" width=115><br><sub>Gerson Escobedo</sub>](https://github.com/gerson121295)

# Licencia
![GitHub](https://img.shields.io/github/license/dropbox/dropbox-sdk-java)

License: [MIT](License.txt)


