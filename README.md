# Backend Test

Welcome to the backend test. This project was created under [Spring Boot](https://spring.io/projects/spring-boot)
and does use of [Eureka](https://github.com/Netflix/eureka/wiki) for discovery service and Gateway.

## Local development environment

### 1. Running Database
Go to /backend-stack and run `docker-compose up --build -d mysql`.

### 2. Running Services

- Go to /gateway and run `./mvnw spring-boot:run`
- Go to /service-discovery and run `./mvnw spring-boot:run`
- Go to /authentication-service and run `./mvnw spring-boot:run`
- Go to /product-service and run `./mvnw spring-boot:run`
- Go to /review-service and run `./mvnw spring-boot:run`

### 3. Migrations

For migrations was used [Flywaydb](https://flywaydb.org). 

When you run the services initial structure will be created.

If you need to load some data. You will need to create a file following nomenclature `V{version_number}__{file_name}.sql`
and add it inside of folder `./resources/db/migration`.

User [Postman](https://www.postman.com/) for testing the requests.

### 4. Collections 

Added collections to import in the Postman.

