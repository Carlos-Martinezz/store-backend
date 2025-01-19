# Getting Started

## Description
API designed for purchases with shopping cart and payment simulation

## Features
- **Cart management**: Allows you to create and manage the shopping cart.
- **Order management**: Allows you to create orders and change their status.
- **Customer and product consultation**: It allows you to obtain products from an external repository, and simulate an external client repository.

## Technologies
- **Spring Boot**: 
- **JPA / Hibernate**: 
- **H2 Database** Portable emulation of a persistent database.

## Guided testing
You can use the following guide (postman request - action) to test the functionality of the services:

### Auth
- **Post Auth Sign Up** - Create a new user
- **Post Auth Log in** - Log In with a valid user

### Features
- **Get All Products** - Get full list of products
- **Post Create Cart** - Create the shopping cart
- **Put Update Cart** - Update the shopping cart
- **Post Create Order** - Create an order from a shopping cart
- **Get Order By Customer Id** - Get orders from a customer
- **Post Payment Create** - Create and simulate a payment

**Use the Postman collection provided in the project root** ("BC Fake Store.postman_collection.json")

## Author
Carlos Martinez - Software Engineer