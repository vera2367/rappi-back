# 🚀 Proyecto Spring Boot + Gradle + CI/CD con GitHub Actions

Este repositorio contiene una API REST desarrollada con Spring Boot y Gradle, con integración continua (CI) y entrega continua (CD) automatizadas mediante **GitHub Actions**.

---

## 🧩 Tecnologías utilizadas

- **Spring Boot + Gradle**
- **MySQL** (para entorno de pruebas)
- **JUnit** (pruebas unitarias)
- **Postman + Newman** (pruebas de integración)
- **GitHub Actions** (CI/CD)
- **Heroku** (despliegue automático)

---

## 🔁 Flujo CI/CD

Cada vez que haces un `push` o `pull request` a la rama `main`, se ejecuta el siguiente flujo automático:

1. 🔍 **Se compila el proyecto** con Gradle (`./gradlew build -x test`)
2. ✅ **Se ejecutan las pruebas unitarias** (`./gradlew test`)
3. 🗃️ **Se levanta una instancia de MySQL** en GitHub Actions como servicio
4. 🚀 **Se ejecuta la aplicación Spring Boot**
5. 🧪 **Se corren pruebas Postman** con [Newman](https://www.npmjs.com/package/newman)
6. 🛑 **Se detiene la aplicación**
7. 📦 **Se empaqueta y guarda el JAR** como artefacto
8. ☁️ **Se despliega automáticamente en Heroku** si todo es exitoso

---

## ⚙️ Estructura del pipeline

El pipeline está definido en:


Este archivo usa:
- **Java 21**
- **Gradle**
- **Docker service para MySQL**
- **Newman para ejecutar tus pruebas Postman**
- **Heroku CLI** para el despliegue final

---

## 🐘 Compilación y ejecución local

Para correr el proyecto en tu entorno local:

1. Asegúrate de tener una base de datos MySQL con las credenciales definidas en `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/testdb
spring.datasource.username=springuser
spring.datasource.password=springpass

🧪 Pruebas Postman
Incluye una colección Postman (postman/mi_coleccion.postman_collection.json) y su entorno (postman/mi_entorno.postman_environment.json), que se ejecutan automáticamente con Newman dentro del pipeline.

Puedes ejecutarlas localmente con:

newman run postman/mi_coleccion.postman_collection.json \
  --environment postman/mi_entorno.postman_environment.json


🚀 Despliegue en Heroku
El despliegue se hace automáticamente usando el plugin heroku-deploy:

Debes definir los siguientes secretos en el repositorio:

Nombre del secreto	Descripción
HEROKU_API_KEY	Tu API Key de Heroku
HEROKU_APP_NAME	El nombre exacto de tu app en Heroku
HEROKU_EMAIL	Tu correo asociado a Heroku

Además, debes incluir un archivo Procfile en la raíz del proyecto:

web: java -Dserver.port=$PORT -jar build/libs/mi-app.jar

👨‍💻 Autor
Este repositorio ha sido preparado como ejemplo para presentar una implementación real de CI/CD con GitHub Actions integrando pruebas automatizadas y despliegue a producción en Heroku.

