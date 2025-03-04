

# **Guessing Game - Spring Boot & Angular**

## **Project Overview**
This is a **Guessing Game** where users get random clues about a city and try to guess it correctly. The backend is built using **Spring Boot** with **MySQL**, and the frontend is developed in **Angular**.

## **Getting Started**

### **1️⃣ Clone the Repository**


### **2️⃣ Build Maven Dependencies**
Run the following command inside the project root:
```bash
mvn clean install
```

### **3️⃣ Setup MySQL Database**
- Open MySQL Workbench or terminal and run:
```sql
CREATE DATABASE guessinggame_db;
```
- Update **`application.properties`** if needed:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/guessinggame_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### **4️⃣ Run the Application**
Use the following command:
```bash
mvn spring-boot:run
```

The backend server will start at **`http://localhost:8080`**.

## **API Endpoints**

### **🔹 Authentication**
| Method | Endpoint | Description |
|--------|---------|-------------|
| POST | `/api/auth/signup` | Register a new user |
| POST | `/api/auth/login` | User login |

### **🔹 Quiz APIs**
| Method | Endpoint | Description |
|--------|---------|-------------|
| GET | `/api/quiz/random-clues` | Get a list of random clues for a city |
| POST | `/api/quiz/random-clues/checkanswer` | Validate the user's answer |
| POST | `/api/quiz/start-game` | Start the game and fetch clues & city options |

## **Request & Response Examples**

### **🎯 Start Game**
**Request:**
```json
POST /api/quiz/start-game
```
**Response:**
```json
{
  "cluelist": [
    { "id": 1, "clue": "This city is home to a famous tower that sparkles every night." }
  ],
  "cityList": [
    { "city": "Paris", "cityId": 1 },
    { "city": "London", "cityId": 2 }
  ]
}
```

### **✅ Check Answer**
**Request:**
```json
POST /api/quiz/random-clues/checkanswer
{
  "cluelist": [],
  "answer": true,
  "funFacts": []
}
```
**Response:**
```json
{
  "correct": true,
  "message": "Correct! Paris is the right answer!",
  "nextClue": "This city is known for its delicious croissants."
}
```

## **Database Schema (ER Diagram)**
This is DB Schema of the project

![Screenshot (2)](https://github.com/user-attachments/assets/79f5d847-ddef-4c42-abfd-ccea7f69a19d)

## **📌 Tech Stack**
- **Backend:** Spring Boot, Java, MySQL, JPA
- **Frontend:** Angular, TypeScript, Material UI
- **Security:** JWT Authentication
