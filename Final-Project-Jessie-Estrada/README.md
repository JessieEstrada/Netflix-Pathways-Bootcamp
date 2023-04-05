# Netflix-Pathways-Bootcamp-Final-Project: Game Store REST API
<img src="https://i.imgur.com/Nv8uUao.png" alt="Netflix" width="100%" height="300">


Welcome to our Game Store REST API project! Our team has developed a comprehensive and fully functional API that simulates the operations of a game store. We have leveraged the power of Spring Boot JPA and Java to build the necessary components, such as models, repositories, service layers, controllers, GraphQLs, and tests for the entire API.

## Table of Contents

1. [Features](#features)
2. [Technologies Used](#technologies-used)
3. [Getting Started](#getting-started)
4. [API Endpoints](#api-endpoints)
5. [Testing](#testing)


## Features

Our Game Store REST API offers the following key features:

- Inventory management for games and accessories
- Product search and filtering
- Secure purchase and checkout process
- Customer management, including contact details and purchase history
- Reporting and analytics to optimize store performance
- Security and authentication to protect store data
- Scalability and performance to accommodate store growth
- Integration with third-party services

## Technologies Used

- Java
- Spring Boot JPA
- GraphQL
- JUnit (for testing)

## Getting Started

To set up the Game Store REST API on your local machine, follow these steps:

1. Clone the repository:

```bash
git clone git@github.com:bryanmax9/Netflix-Pathways-Bootcamp-Final-Project.git
```

2. Navigate to the project folder:

```bash
cd game-store-rest-api
```


3. Install the required dependencies:

```bash
mvn clean install
```

4. Run the application:

```bash
mvn spring-boot:run
```

5. The API will be available at `http://localhost:8080`.

## API Endpoints

The Game Store REST API provides the following endpoints:

- `GET /games`: Retrieve a list of all games
- `POST /games`: Add a new game to the inventory
- `PUT /games/{id}`: Update an existing game's information
- `DELETE /games/{id}`: Remove a game from the inventory

(Will be the same for T-Shir, Console, and Invoice)

## Testing

To run the tests for the Game Store REST API, execute the following command:

```bash
mvn test
```







