# Exchange Trading Application

Exchange is an arbitrarily trading game developed by a startup called “Super Traders”. The purpose of the application is to educate users on the terminology used in trading of shares. This project implements the backend services for managing users, portfolios, shares, and trades.

## Project Structure

- `controller`: Contains the RESTful API controllers.
- `dto`: Data Transfer Objects for API requests and responses.
- `models`: Entity classes representing the database schema.
- `repositories`: Spring Data JPA repositories for database operations.
- `service`: Service layer for business logic.
- `config`: Configuration classes, including data initialization.
- `resources`: Configuration files.

## Requirements

1. **Share Registration**:

   - Shares must be registered with a unique Symbol.
   - Symbols should be in all capital letters and exactly 3 characters long.
   - The rate of shares should have exactly 2 decimal digits.

2. **User Portfolio**:

   - Users must have a registered portfolio before they can trade shares.

3. **Trading Operations**:

   - **BUY**:

     - The purchase rate should be the latest price in the database.
     - The share must be registered; otherwise, it is a bad request.
     - The user's portfolio must be registered; otherwise, it is a bad request.

   - **SELL**:
     - The share must be in the user's portfolio.
     - The user's portfolio must be registered; otherwise, it is a bad request.
     - The selling rate should be the latest price in the database.
     - There must be a sufficient number of shares to sell.

## Setup and Running the Application

### Prerequisites

- Java 8 or higher
- Docker
- PostgreSQL

### Steps

1. **Clone the Repository**:

   ```sh
    git clone https://muratocal-admin@bitbucket.org/muratocal/exchangegame.git
   ```

2. **Build Maven Project**:

   ```sh
    ./mvnw clean package -DskipTests
   ```

3. **Run Project Using Docker**:

   ```sh
    docker-compose up --build
   ```

4. **Access the API**:
   The API will be available at http://localhost:8080/swagger-ui/index.html.

## Data Initialization

The DataInitialization class in the config package initializes the database with sample data.

## API Endpoints

### Users

- `POST` /api/v1/users: Create a new user.
- `GET` /api/v1/users/{id}: Retrieve a user by ID.
- `GET` /api/v1/users: Retrieve all users.

### Portfolios

- `POST` /api/v1/portfolios: Create a new portfolio.
- `GET` /api/v1/portfolios/{id}: Retrieve a portfolio by ID.
- `GET` /api/v1/portfolios: Retrieve all portfolios.

### Shares

- `POST` /api/v1/shares: Register a new share.
- `GET` /api/v1/shares: Retrieve all shares.
- `GET` /api/v1/shares/{id}: Retrieve a share by ID.
- `GET` /api/v1/shares/symbol/{symbol}: Retrieve a share by symbol.

### Trades

- `POST` /api/v1/trades/sell: Sell shares.
- `POST` /api/v1/trades/buy: Buy shares.
- `GET` /api/v1/trades/: Retrieve all trades.
- `GET` /api/v1/trades/{id}: Retrieve a trade by ID.

## Testing

### Using Postman

1. **Import the Collection:** Import the provided Postman collection file to test the API endpoints.

2. **Set Environment Variables:** Ensure the Postman environment is configured with the correct base URL and other necessary variables.

3. **Run Requests:** Execute the requests in the collection to test the different endpoints.
