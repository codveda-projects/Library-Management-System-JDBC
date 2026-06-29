# Library Management System (JDBC)

A simple Java-based Library Management System built with JDBC and MySQL.  
This project demonstrates database connectivity, CRUD operations, and basic library workflows such as viewing, borrowing, and returning books.

---

## Features
- View available books
- Borrow books (updates availability)
- Return books
- Tracks transactions with foreign key constraints
- Uses environment variables for secure DB credentials

---

## Requirements
- Java JDK 23+
- MySQL server
- MySQL Connector/J (tested with 9.7.0)

---

## Setup

1. Clone the repository
   ```bash
   git clone https://github.com/your-username/Library-Management-System-JDBC.git
   cd Library-Management-System-JDBC

## Compile and Run
javac -cp ".;mysql-connector-j-9.7.0.jar" *.java

java -cp ".;mysql-connector-j-9.7.0.jar" Main

## File structure
Library-Management-System-JDBC/
│
├── Main.java              # Entry point with menu
├── DBConnection.java      # Handles DB connection using .env
├── LibraryDAO.java        # Data access object for library operations
├── EnvLoader.java         # Minimal custom .env reader
├── .env.example           # Safe template for environment variables
├── .gitignore             # Ensures .env and build files stay private
└── README.md              # Project documentation
