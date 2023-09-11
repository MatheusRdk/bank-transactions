# Mock Exam - Java Developer Junior

This repository contains a completed project for the DevDojo's mock exam designed for a Junior Java Developer position. The project involves building an API that retrieves transactions for each user. These transactions are stored in a `transactions.json` file, which I've transformed into Java objects. I've mapped these objects according to the format specified in the exam requirements and associated them with each user. The users are stored in memory, without the use of a database.

## Project Structure

The project is organized into the following components:

- `config`: Contains Spring Security configurations.
- `controller`: Includes API routes and endpoints.
- `domain`: Core domain classes are located here.
- `service`: Implements business logic.
- `util`: Contains utility classes.

## Requirements

To run this project, you need the following:

- Java 17
- Spring Boot 3.1.2 -> As we employ Maven, the pom.xml comes pre-configured with all the necessary components. Don't forget to load all Maven dependencies.

## Endpoints

The following endpoints are available:

- `GET /transactions/all`: Displays all transactions. Requires admin privileges.
- `GET /transactions/{accountId}`: Shows transactions for a specific user. Each user can only access their own transactions. For example, User6 can only access `transactions/6`, and so on. If a user attempts to access transactions associated with an accountId that does not belong to them, they will receive a HTTP 403 Forbidden status.

## Testing the API

To test the API, follow these steps:

1. Make sure you have Java 17.
2. Clone this repository to your local machine.
3. Navigate to the project directory and run the application.
4. Once the application is running, you can access the endpoints using a tool like Postman or by making HTTP requests directly from your browser.

Please note that the application doesn't require any additional configuration, and you can access the endpoints normally. However, make sure that port 8080 is available on your computer before running the project. If this port is occupied by another application, you can configure a different port by editing the application.yml file located at src/main/resources/application.yml. In the server section of the file, modify the port field to your desired port number.

Feel free to explore the code and make any modifications or improvements as needed.
