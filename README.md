# Quick cloth - Data Service

Servicio encargado de gestionar el acceso a la base de datos de la aplicación Quick Cloth.

## Variables de Entorno 🔒

Para ejecutar este proyecto, necesitarás agregar las siguientes variables de entorno a tu archivo .env

`POSTGRESQL_URL`

`POSTGRESQL_PORT`

`POSTGRESQL_SCHEMA`

`POSTGRESQL_USER`

`POSTGRESQL_PASSWORD`

## Ejecutar Localmente 💻

Clona el proyecto

```bash
  git clone https://github.com/quick-cloth/quick-cloth-data.git
```

Ve al directorio del proyecto

```bash
  cd quick-cloth-data
```

Instala las dependencias

```bash
  mvn install
```

Inicia el servidor

```bash
  mvn spring-boot:run
```

## Ejecutar con Docker 🐳

### Construir la imagen

Abre una terminal en el directorio raíz de tu proyecto (donde se encuentra el Dockerfile) y ejecuta el siguiente comando:

```bash
  docker build --build-arg POSTGRESQL_URL=foo-db-url \
             --build-arg POSTGRESQL_PORT=5432 \
             --build-arg POSTGRESQL_SCHEMA=foo_schema \
             --build-arg POSTGRESQL_USER=foo_user \
             --build-arg POSTGRESQL_PASSWORD=myS3cr3t_Password \
             -t quick-cloth-data .
```

### Correr el contenedor

Una vez creada la imagen, puede ejecutar el contenedor con el siguiente comando:

```bash
  docker run -d -p 8080:8080 --name my-container quick-cloth-data
```