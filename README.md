# 💰 Personal Finance Tracker API

A RESTful API built with Java Spring Boot that allows users to manage personal financial transactions, track income and expenses, and view a real-time balance summary.

---

## 🚀 Tech Stack

| Technology | Purpose | Why I Used It |
|---|---|---|
| Java 17 | Core language | Industry standard for backend/financial systems |
| Spring Boot 3.3 | Backend framework | Simplifies REST API development, widely used in enterprise |
| Spring Data JPA | Database layer | Eliminates boilerplate SQL, maps Java objects to database tables |
| H2 Database | In-memory database | Zero-config database, ideal for development and testing |
| Gradle | Build tool | Manages dependencies and builds the project |
| Postman | API testing | Tests endpoints without needing a frontend |

---

## 📋 Features

- ✅ Add income and expense transactions
- ✅ View all transactions
- ✅ Get a real-time financial summary (total income, total expenses, balance)
- ✅ Persistent storage using JPA and H2 database
- ✅ RESTful API design following industry standards

---

## 🏗️ Project Structure

```
src/main/java/com/financetracker/finance_api/
├── FinanceApiApplication.java    # Entry point - starts the Spring Boot app
├── Transaction.java              # Entity - defines what a transaction looks like
├── TransactionRepository.java    # Repository - handles all database operations
└── TransactionController.java    # Controller - handles all API requests
```

---

## 🔧 How to Run

### Prerequisites
- Java 17 or higher
- Git

### Steps

1. Clone the repository
```bash
git clone https://github.com/sup-devp/finance-api.git
cd finance-api
```

2. Run the application
```bash
./gradlew bootRun
```

3. The server starts at:
```
http://localhost:8080
```

---

## 📡 API Endpoints

### Add a Transaction
```
POST /api/transactions
```
Request Body:
```json
{
    "description": "Monthly Salary",
    "amount": 2500,
    "type": "INCOME"
}
```
Response:
```json
{
    "id": 1,
    "description": "Monthly Salary",
    "amount": 2500.0,
    "type": "INCOME",
    "date": "2026-05-23T19:10:00"
}
```

---

### Get All Transactions
```
GET /api/transactions
```
Response:
```json
[
    {
        "id": 1,
        "description": "Monthly Salary",
        "amount": 2500.0,
        "type": "INCOME",
        "date": "2026-05-23T19:10:00"
    },
    {
        "id": 2,
        "description": "Rent",
        "amount": 800.0,
        "type": "EXPENSE",
        "date": "2026-05-23T19:12:00"
    }
]
```

---

### Get Balance Summary
```
GET /api/transactions/summary
```
Response:
```json
{
    "totalIncome": 2500.0,
    "totalExpenses": 800.0,
    "balance": 1700.0
}
```

---

## 💡 How It Works

When a POST request is received:
1. Spring Boot routes the request to the **Controller**
2. The Controller passes the data to the **Repository**
3. JPA converts the Java object to SQL and saves it to the **H2 database**
4. The saved transaction is returned as a JSON response

---

## 🔗 Relevance to Industry

This project mirrors real-world financial backend systems. During my time at **Barclays** as a Software Developer, I worked on similar backend utilities including an Income Settlement System and a Batch Status Dashboard. This project demonstrates those same core skills:
- Building and consuming REST APIs
- Working with relational databases using JPA/SQL
- Java backend development with Spring Boot
- Structured, maintainable code architecture

---

## 👩‍💻 Author

**Supraja** — Previously Software Developer at Barclays (2023–2025)
