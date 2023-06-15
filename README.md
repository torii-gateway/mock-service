# Mock Server

## Introduction
This project serves as a basic content management system. It provides RESTful APIs that allow you to create, read, update, and delete (CRUD) content data. The APIs are developed using Spring Boot and the data is persisted with Hibernate with the main goal to 
demonstrate how a service could be configured by the Gateway unit

## Prerequisites
Before running this project, ensure you have the following software installed on your machine:

- Make
- Docker
- Docker Compose
- Maven
- Java 17

## Building the Project
To build the project, open a terminal in the project's root directory and run:

```bash
make build
```

## Running the Project
To run the project, use the command:

```bash
make run
```

## API Usage

Here is a brief introduction to each of the endpoints provided by the `ContentController`: 
be aware that the application is also configured to run on port 8082 on a new instance (see docker-compose.yaml)

- **GET /content:** Retrieves all content. Note that there is a hardcoded delay of 3 seconds for each request to this endpoint.

```bash
curl -X GET http://localhost:8081/content
```

- **POST /content:** Creates new content based on the JSON payload provided in the request body. The content is in the form of `{ "data" : "your content here" }`.

```bash
curl -X POST -H "Content-Type: application/json" -d '{ "data": "your content here" }' http://localhost:8081/content
```

- **PUT /content/{id}:** Updates existing content identified by `{id}` based on the JSON payload provided in the request body.

```bash
curl -X PUT -H "Content-Type: application/json" -d '{ "id": 1, "data": "updated content here" }' http://localhost:8081/content/1
```

- **GET /content/{id}:** Retrieves the content identified by `{id}`.

```bash
curl -X GET http://localhost:8081/content/1
```

- **DELETE /content/{id}:** Deletes the content identified by `{id}`.

```bash
curl -X DELETE http://localhost:8081/content/1
```

## Cleaning Up
If you need to clean up Docker (remove containers, networks, and images), use the following command:

```bash
make clean
```

## Stopping the Project
If you wish to stop the running project, you can use the following command:

```bash
make stop
```

## Refreshing the Project
If you want to fully refresh your project (clean, build, and run), use the following command:

```bash
make refresh
```

## Swagger
The project is configured to use Swagger to document the RESTful APIs. To view the Swagger UI, run the project and navigate to:

```bash
http://localhost:8081/swagger-ui.html
```
