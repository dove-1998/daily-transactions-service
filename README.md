# 🧾 Daily Transactions Service

A Spring Boot project that manages **daily product transactions** and automatically generates **daily summaries** using Spring Data JPA.  
This application demonstrates real-world transaction handling, entity relationships, and summary generation logic used in enterprise systems.

---

## 🚀 Features

- Manage products and their daily transactions  
- Generate daily summaries (total quantity, amount, number of transactions)  
- RESTful APIs for transactions and summaries  
- H2 in-memory database for testing  
- Easily configurable to MySQL or PostgreSQL  

---

## 🏗️ Tech Stack

| Technology | Description |
|-------------|-------------|
| **Spring Boot 3+** | Core framework |
| **Spring Data JPA** | ORM and persistence |
| **H2 Database** | In-memory DB for local testing |
| **Lombok** | Boilerplate code reduction |
| **Java 17+** | Programming language |
| **Maven** | Build and dependency management |

---

## 📁 Project Structure

daily-transactions-service/
├── entity/
│ ├── Product.java
│ ├── DailyTransaction.java
│ └── DailySummary.java
├── repository/
│ ├── ProductRepository.java
│ ├── DailyTransactionRepository.java
│ └── DailySummaryRepository.java
├── service/
│ ├── TransactionService.java
│ └── SummaryService.java
├── controller/
│ └── TransactionController.java
├── resources/
│ └── application.properties
└── DailyTransactionsServiceApplication.java

API EndPoints:

| Method | Endpoint                                  | Description             |
| ------ | ----------------------------------------- | ----------------------- |
| `POST` | `/api/transaction/{productId}?quantity=5` | Add new transaction     |
| `GET`  | `/api/transactions`                       | Get all transactions    |
| `POST` | `/api/summary/generate?date=2025-10-14`   | Generate daily summary  |
| `GET`  | `/api/summaries`                          | Get all daily summaries |



