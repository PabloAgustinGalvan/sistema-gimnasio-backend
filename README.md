# Sistema de Gestión de Gimnasio

Backend desarrollado en **Java con Spring Boot** para la gestión básica de un gimnasio.

El sistema permite administrar:
- Socios
- Rutinas personalizadas
- Ejercicios
- Estado activo/inactivo de los socios (pago de cuota)

Proyecto realizado con fines educativos y como práctica de desarrollo backend.

---

## Tecnologías utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- PostgreSQL
- H2 (entorno de pruebas)
- Postman (testing de endpoints)

---

## Modelo de dominio

### Socio
- Nombre
- Apellido
- Teléfono
- Fecha de inscripción / último pago
- Estado `activo` (boolean)
- Puede tener **una o varias rutinas**

### Rutina
- Nombre
- Pertenece a un socio
- Contiene varios ejercicios

### Ejercicio
- Nombre (único)
- Representa un catálogo de ejercicios

### RutinaEjercicio
- Entidad intermedia
- Permite personalizar cada ejercicio dentro de una rutina:
    - Series
    - Repeticiones
    - Descripción

---

## Cómo ejecutar el proyecto

### Requisitos
- Java instalado
- Maven
- PostgreSQL en ejecución

---

### Clonar el repositorio
```git clone https://github.com/tu-usuario/tu-repo.git```

### Configuración de la base de datos

Editar el archivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/gym_db
spring.datasource.username=postgres
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```
### Desde la raiz del proyecto ejecutar:
```mvn spring-boot:run```

### La aplicacion quedara disponible en:
```http://localhost:8080```

## Endpoints principales
### Socios
- GET /socios
- GET /socios/{id}
- POST /socios
- PUT /socios/{id}
- DELETE /socios/{id}

### Rutinas
- GET /rutinas
- GET /rutinas/{id}
- POST /rutinas/socio/{socioId}
- DELETE /rutinas/{id}
- PUT /rutinas/{id}

### Ejercicios
- GET /ejercicios
- POST /ejercicios
- PUT /ejercicios/{id}

### Los endpoints fueron probados utilizando Postman, permitiendo validar:
- Creacion de socios
- Asignacion de rutinas
- Asociacion de ejercicios
- Actualizacion de datos
- Eliminacion de registros

## ¿Que aprendi de este proyecto?
- Diseño de una API REST con Spring Boot
 -Uso de JPA y manejo de relaciones entre entidades
- Separación de responsabilidades (Controller / Service / Repository)
- Aplicación de reglas de negocio reales
- Uso de DTOs para evitar exponer entidades
- Manejo de errores comunes (claves foráneas, estados nulos, etc.)

## Notas Adicionales
- El estado "activo" del socio del socio representa si su cuota esta al dia o no.
- La fecha de inscripción se utiliza como referencia del último pago.
- La lógica automática de vencimiento (30 días sin pago) puede implementarse en futuras versiones.
- Este proyecto corresponde únicamente al backend. No incluye frontend.
## Autor
Pablo Agustin Galvan. 
Estudiante de Licenciatura en Sistemas – UNGS