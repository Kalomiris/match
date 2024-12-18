# REST API Technical Assessment

This project provides a RESTful Web API for managing matches and their associated odds. It is built using **Java**, **Spring Boot**, **PostgreSQL**, and includes integration with **Swagger** for API documentation.

## Prerequisites

Before running the application, ensure you have the following tools installed:

- **Docker**: For running PostgreSQL and the application in containers.
- **Docker Compose**: To manage multi-container Docker applications.

## Getting Started

### Step 1: Clone the Repository
Clone this repository to your local machine:

```bash
git clone https://github.com/Kalomiris/match.git
cd match
```

### Step 2: Run the Application Using Docker Compose
Navigate to the `match` directory (where the `docker-compose.yml` file is located), and run the following command to start the containers:

```bash
docker-compose up
```

This will launch two containers:

1. **PostgreSQL Database** – For storing match and odds data.
2. **Spring Boot Application** – The REST API service itself.

### Step 3: Accessing the API

Once the containers are running, the API will be exposed at the following URL:

- **Swagger UI** (for API documentation): [Swagger](http://localhost:8080/swagger-ui/index.html)

You can interact with the API through the Swagger interface or by making direct HTTP requests to the endpoints.

## API Endpoints

The Swagger UI will display a list of available endpoints, their methods (GET, POST, PUT, DELETE), and request/response details.

## Database Configuration

The PostgreSQL container will be initialized with a default database and schema to store match and odds information. You can modify the configuration (such as database credentials) in the `application.yml` file if needed.

## Stopping the Application

To stop the containers, run:

```bash
docker-compose down
```

This will stop and remove the containers, but the data will remain intact in the PostgreSQL database until you explicitly remove it.

## Conclusion

This application provides a simple and efficient way to manage matches and their odds via a RESTful API.