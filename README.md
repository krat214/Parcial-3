# Proyecto Spring Boot - Parcial 3

## 📌 Descripción
Este proyecto es una API RESTful desarrollada con **Spring Boot** y **WebFlux** que permite gestionar **pedidos** con soporte para **internacionalización (i18n)**. Permite listar y crear pedidos con mensajes de respuesta traducidos dinámicamente según el idioma configurado.

## 📂 Estructura del Proyecto
```
Parcial 3/
│── src/main/java/com/parcial3/project/
│   ├── config/                  # Configuración de internacionalización
│   ├── controllers/             # Controladores REST
│   ├── models/                  # Clases modelo (Entidades)
│   ├── services/                # Lógica de negocio
│   └── ProjectApplication.java  # Clase principal de Spring Boot
│── src/main/resources/
│   ├── messages_es.properties   # Mensajes en español
│   ├── messages_en.properties   # Mensajes en inglés
│   ├── application.properties   # Configuración de la aplicación
│── build.gradle                 # Configuración de Gradle
│── settings.gradle               # Configuración del proyecto
│── README.md                     # Este documento
```

## 🚀 Instalación y Ejecución
### 📌 Prerrequisitos
- Tener instalado **Java 17+**
- Tener **Gradle** instalado
- IDE recomendado: IntelliJ IDEA o VS Code

### 📌 Instrucciones
1. **Clonar el repositorio**
   ```sh
   git clone https://github.com/krat214/Parcial-3.git
   cd Parcial3
   ```
2. **Compilar y ejecutar**
   ```sh
   ./gradlew bootRun
   ```
3. **Abrir en el navegador:**
   - API base: `http://localhost:8080`

## 📡 Endpoints Disponibles
### 📌 Pedidos
- **Listar pedidos** (traducción automática según `Accept-Language`)
  ```http
  GET /api/pedidos
  Headers: Accept-Language: es | en
  ```
- **Crear un pedido**
  ```http
  POST /api/pedidos
  Headers: Accept-Language: es | en
  Body:
  {
    "descripcion": "Pedido nuevo",
    "total": 450.0
  }
  ```

## 🌍 Internacionalización (i18n)
La API soporta traducción automática de mensajes de respuesta.
- **Español (`es`)**: `Pedido creado con éxito: {id}`
- **Inglés (`en`)**: `Order created successfully: {id}`

## 📜 Licencia
Este proyecto es de uso educativo y libre para modificaciones.

