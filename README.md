# Expenses Tracking Application

## Overview
This is a comprehensive expense tracking application built using Spring Boot and following Clean Architecture principles. The application allows users to manage their personal finances by tracking expenses, categorizing transactions, and managing multiple accounts.

## Architecture

The project follows Clean Architecture principles, separating the application into distinct layers:

### Domain Layer
Contains the core business entities and rules:
- User
- Account
- Transaction
- Category
- Role

### Application Layer
Contains use cases that orchestrate the flow of data and business rules:
- User management (create, update, get by ID/email)
- Account management (create, update, get)
- Transaction management (create, update, get, filter by date)
- Category management (create, update, get)
- Authentication (login, register)

### Infrastructure Layer
Provides implementations for interfaces defined in the application layer:
- Persistence adapters
- Security configuration
- Dependency injection configuration

### Presentation Layer
Handles HTTP requests and responses:
- REST controllers for all entities
- DTOs for request/response objects
- Global exception handling

## Key Features

- **User Management**: Registration, authentication, and profile management
- **Account Management**: Create and manage multiple financial accounts
- **Transaction Tracking**: Record income and expenses with detailed information
- **Categorization**: Organize transactions by custom categories
- **Secure Authentication**: JWT-based authentication and authorization

## Technologies

- **Java 21**: Latest LTS version of Java
- **Spring Boot 3.4.5**: Framework for building production-ready applications
- **Spring Security**: Authentication and authorization
- **Spring Data JPA**: Data access layer
- **PostgreSQL**: Relational database
- **Lombok**: Reduces boilerplate code
- **MapStruct**: Type-safe bean mapping
- **OAuth2 Resource Server**: For JWT token handling

## Getting Started

### Prerequisites

- Java 21 or higher
- PostgreSQL database
- Gradle

### Setup

1. Clone the repository
2. Configure your database connection in `application.properties` or `application.yml`
3. Run the application:
   ```
   ./gradlew bootRun
   ```
   or on Windows:
   ```
   gradlew.bat bootRun
   ```

### API Endpoints

The application exposes the following main API endpoints:

- **Authentication**:
  - POST `/api/auth/register` - Register a new user
  - POST `/api/auth/login` - Authenticate and get JWT token

- **Users**:
  - GET `/api/users/{id}` - Get user by ID
  - PUT `/api/users/{id}` - Update user information

- **Accounts**:
  - POST `/api/accounts` - Create a new account
  - GET `/api/accounts/{id}` - Get account by ID
  - PUT `/api/accounts/{id}` - Update account information

- **Categories**:
  - POST `/api/categories` - Create a new category
  - GET `/api/categories/{id}` - Get category by ID
  - PUT `/api/categories/{id}` - Update category information

- **Transactions**:
  - POST `/api/transactions` - Create a new transaction
  - GET `/api/transactions/{id}` - Get transaction by ID
  - PUT `/api/transactions/{id}` - Update transaction information
  - GET `/api/transactions/user/{userId}/date` - Get transactions by user and date range

## Project Structure

The project follows a modular structure based on Clean Architecture principles:

```
src/main/java/com/project/expenses/
├── application/
│   ├── exception/
│   ├── gateways/
│   └── usecases/
├── domain/
│   ├── entity/
│   └── enums/
├── infrastructure/
│   ├── config/
│   ├── mappers/
│   ├── persistence/
│   └── security/
└── presentation/
    ├── controllers/
    ├── dto/
    └── exception/
```

## License

This project is licensed under the MIT License - see the LICENSE file for details.