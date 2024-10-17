# ProductService

ProductService is a Spring Boot web application and Java library that provides RESTful APIs for managing products. It supports CRUD operations and integrates with Redis for caching. The application also ensures that the category exists when creating a product, and if not, it creates the category.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

These instructions will help you set up and run the ProductService application on your local machine.

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- Redis server

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/your-username/productService.git
    cd productService
    ```

2. Install the dependencies:
    ```sh
    mvn clean install
    ```

## Running the Application

1. Start the Redis server:
    ```sh
    redis-server
    ```

2. Run the Spring Boot application:
    ```sh
    mvn spring-boot:run
    ```

## API Endpoints

### Create a Product

- **URL:** `/products`
- **Method:** `POST`
- **Headers:** `Authorization: Bearer <token>`
- **Request Body:**
    ```json
    {
        "title": "Product Title",
        "description": "Product Description",
        "price": 100.0,
        "imageUrl": "http://example.com/image.jpg",
        "category": {
            "name": "Category Name"
        }
    }
    ```
- **Response:**
    ```json
    {
        "id": 1,
        "title": "Product Title",
        "description": "Product Description",
        "price": 100.0,
        "imageUrl": "http://example.com/image.jpg",
        "category": {
            "id": 1,
            "name": "Category Name"
        }
    }
    ```

### Get All Products

- **URL:** `/products`
- **Method:** `GET`
- **Response:**
    ```json
    {
        "products": [
            {
                "id": 1,
                "title": "Product Title",
                "description": "Product Description",
                "price": 100.0,
                "imageUrl": "http://example.com/image.jpg",
                "category": {
                    "id": 1,
                    "name": "Category Name"
                }
            }
        ]
    }
    ```

### Get a Single Product

- **URL:** `/products/{id}`
- **Method:** `GET`
- **Response:**
    ```json
    {
        "id": 1,
        "title": "Product Title",
        "description": "Product Description",
        "price": 100.0,
        "imageUrl": "http://example.com/image.jpg",
        "category": {
            "id": 1,
            "name": "Category Name"
        }
    }
    ```

### Update a Product

- **URL:** `/products/{id}`
- **Method:** `PATCH`
- **Request Body:**
    ```json
    {
        "title": "Updated Product Title"
    }
    ```
- **Response:**
    ```json
    {
        "product": {
            "id": 1,
            "title": "Updated Product Title",
            "description": "Product Description",
            "price": 100.0,
            "imageUrl": "http://example.com/image.jpg",
            "category": {
                "id": 1,
                "name": "Category Name"
            }
        }
    }
    ```

### Delete a Product

- **URL:** `/products/{id}`
- **Method:** `DELETE`

## Testing

To run the tests, use the following command:
```sh
mvn test
