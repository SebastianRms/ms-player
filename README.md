🧬 MicroHumans - Player API

Microservicio backend responsable de gestionar el ciclo de vida, la creación y las estadísticas vitales (energía, hambre y deseo) de los jugadores. Construido bajo una arquitectura completamente reactiva y no bloqueante.

🚀 Stack Tecnológico

Lenguaje: Java 21
Framework: Quarkus
Persistencia: Hibernate Reactive con Panache
Base de Datos: PostgreSQL 15
Infraestructura: Docker Compose

🛠️ Configuración y Despliegue Local

Requisitos Previos

Docker instalado y en ejecución.

JDK 21 configurado en tu entorno.

Levantar la Base de Datos
El proyecto incluye un archivo docker-compose.yml preconfigurado. Para iniciar el contenedor, ejecuta en la raíz del proyecto:

docker compose up -d

Nota: Esto levantará una instancia de PostgreSQL en el puerto 5432, creando automáticamente la base de datos microhumans con el usuario postgres.

Arrancar el Servidor
Ejecuta la aplicación en modo desarrollo (live coding activado):

./mvnw compile quarkus:dev

Nota: Hibernate ORM está configurado en modo update. Al arrancar el servidor, verificará el esquema y generará las tablas correspondientes automáticamente si no existen.

📖 Documentación de la API (Swagger UI)

El microservicio cuenta con documentación interactiva autogenerada mediante OpenAPI 3.1. Una vez que la aplicación esté corriendo, accede a través de tu navegador a:
http://localhost:8080/q/swagger-ui/

Resumen de Endpoints (/api/v1/players)

POST /
Da nacimiento a un nuevo jugador.
Body: { "name": "string", "sex": "string" }

GET /{id}
Consulta el estado actual de las barras del jugador.

PUT /{id}/energy
Incrementa o decrementa la energía.
Body: { "levels": -2 }

PUT /{id}/hunger
Incrementa o decrementa el hambre.
Body: { "levels": 3 }

PUT /{id}/desire
Incrementa o decrementa el deseo.
Body: { "levels": 1 }

📦 Compilación para Producción

Empaquetado Estándar (JVM)
Para compilar la aplicación y prepararla para producción en la Máquina Virtual de Java:

./mvnw package

Esto genera el archivo quarkus-run.jar en la carpeta target/quarkus-app/.
Puedes ejecutarlo con: java -jar target/quarkus-app/quarkus-run.jar

Ejecutable Nativo (GraalVM)
Para compilar un binario nativo que consume una fracción de la memoria RAM y arranca en milisegundos:

./mvnw package -Dnative