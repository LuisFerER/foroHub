# ForoHub 💬

ForoHub es una aplicación web tipo foro en la que los usuarios pueden crear preguntas, responder y ayudar a otros a resolver problemas. Su objetivo es servir como una plataforma colaborativa de aprendizaje y discusión técnica.

---

## 🚀 Tecnologías utilizadas

- ☕ **Java 17**
- 🌱 **Spring Boot**
- 🗄️ **MySQL**
- 🛠 **Maven**
- 🔐 **Auth0** (verificación de usuarios y contraseñas)
- 🛡 **Spring Security**
- 🗃 **Flyway** (migración de base de datos)
- ✨ **Lombok**

---

## ✨ Funcionalidades

- 📝 Crear, editar y eliminar tópicos.
- 💬 Responder preguntas de otros usuarios.
- ✅ Marcar respuestas como solución.
- 🔒 Sistema de autenticación y seguridad con Auth0 y Spring Security.
- 🛠 Migraciones de base de datos con Flyway.

---

## 🗂 Estructura del Proyecto

```
foroHub
├── .idea/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/com/blacklotuzz/forohub/
│   │   │   ├── controller/
│   │   │   │   ├── AutenticacionController.java
│   │   │   │   ├── HelloController.java
│   │   │   │   └── TopicoController.java
│   │   │   ├── domain/
│   │   │   │   ├── curso/
│   │   │   │   ├── respuesta/
│   │   │   │   ├── topico/
│   │   │   │   ├── usuario/
│   │   │   │   └── ValidacionException.java
│   │   │   ├── infra/
│   │   │   │   ├── exceptions/
│   │   │   │   └── security/
│   │   │   └── ForohubApplication.java
│   │   └── resources/
│   │       ├── db.migration/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
│   └── test/
├── target/
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
└── pom.xml
```

---

## ⚙️ Instalación y ejecución

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/LuisFerER/foroHub.git
   ```

2. **Entrar al directorio del proyecto**
   ```bash
   cd foroHub
   ```

3. **Configurar el archivo `application.properties`**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/forohub
   spring.datasource.username=TU_USUARIO
   spring.datasource.password=TU_CONTRASEÑA
   spring.jpa.hibernate.ddl-auto=validate
   spring.flyway.enabled=true

   # Configuración Auth0
   auth0.audience=TU_AUDIENCE
   spring.security.oauth2.resourceserver.jwt.issuer-uri=TU_ISSUER_URI
   ```

4. **Ejecutar la aplicación**
   ```bash
   mvn spring-boot:run
   ```

---

## 🔑 Autenticación
El proyecto utiliza **Auth0** y **Spring Security** para la verificación de usuarios y contraseñas.  
Debes configurar tus credenciales de Auth0 en el archivo `application.properties`.

---

## 🤝 Contribuciones
Las contribuciones son bienvenidas. Si deseas mejorar ForoHub:
1. Haz un fork del repositorio.
2. Crea una nueva rama:  
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Haz commit de tus cambios:
   ```bash
   git commit -m "Agrega nueva funcionalidad"
   ```
4. Haz push a tu rama:
   ```bash
   git push origin feature/nueva-funcionalidad
   ```
5. Abre un Pull Request.

---

## 📜 Licencia
Este proyecto está desarrollado con fines educativos. Actualmente no posee una licencia definida.

---

## 👨‍💻 Autor
Desarrollado por [LuisFerER](https://github.com/LuisFerER)
