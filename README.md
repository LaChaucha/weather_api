
# Weather API Wrapper

The Weather API Wrapper is a Spring Boot application that provides a simplified interface for interacting with a Openweathermap API. This application acts as a wrapper around it, abstracting away the complexities of the API and providing a user-friendly interface for retrieving weather data.

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Running the Tests](#running-the-tests)
- [Contributing](Contributing)

---

## Project Overview
This project follows the Clean Architecture pattern, which promotes separation of concerns and independence of implementation details. The core idea of Clean Architecture is to separate the high-level business logic from the lower-level implementation details such as databases, frameworks, and user interfaces.

The benefits of using Clean Architecture include increased maintainability, testability, and flexibility. By separating the high-level business logic from the lower-level implementation details, the application becomes more modular and easier to modify over time. Additionally, the clear separation of concerns makes it easier to write automated tests, and the decoupling of the application from external systems makes it more flexible and adaptable to changing requirements.

## Technologies Used

- Java 8
- Spring Boot 2.5
- JUnit 5
- Mockito 3
- Maven 3
- Jasypt 1.9

## Getting Started

### Prerequisites
- Java 8
- Maven 3

### Installation

1. Clone the repository: `git clone https://github.com/LaChaucha/weather_api`
2. Navigate to the project directory: `cd project-directory`
3. Build the application: `mvn clean install`

### Running the Application

1. Start the application: `mvn spring-boot:run -Dspring-boot.run.profiles=DEV -Djasypt.encryptor.password=xxx`. Please ask me the encript pass or I can help to generete one in `https://openweathermap.org/`
2. Open a web browser and navigate to `http://localhost:8080`


## Running the Tests

1. Navigate to the project directory: `cd project-directory`
2. Run the test suite: `mvn clean test`

## Contributing

1. Fork the repository: `git clone https://github.com/LaChaucha/weather_api`
2. Create a new branch: `git checkout -b new-feature`
3. Make changes and commit them: `git commit -m "Add new feature"`
4. Push to the branch: `git push origin new-feature`
5. Submit a pull request
