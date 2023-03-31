# Pokemon API

This is a REST API Client sandbox project using Kotlin, Spring Boot, and Maven.

## Prerequisites

- Java JDK 11 or higher
- Apache Maven 3.6.3 or higher
- IDE (e.g., IntelliJ IDEA, Eclipse)

## Getting Started

1. Clone the repository: `git clone https://github.com/atrastudhi/pokemon-api.git`
2. Navigate to the project directory: `cd pokemon-api`
3. Run the application: `mvn spring-boot:run`
4. Open a web browser and go to http://localhost:8080

## Features

- REST API endpoints
- Rest Client
- Logging with Kotlin Logging JVM
- Observability Configuration
- Spring Actuator

## Usage

- To run unit tests: `mvn test`
- To create a JAR file: `mvn package`
- To run the JAR file: `java -jar target/<project-name>-<version>.jar`

## Configuration

The application uses the following default configuration:

- Server port: 8080

To change the configuration, you can modify the `application.properties` file.

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
