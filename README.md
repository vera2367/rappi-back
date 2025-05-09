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

