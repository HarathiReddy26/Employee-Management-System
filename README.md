
# Employee Management System (Java + Swing + MySQL)



**The **Employee Management System** is a Java-based desktop application developed using **Swing** for the GUI and **MySQL** for the database. It helps organizations manage employee records efficiently by providing essential features such as adding, editing, viewing, and deleting employees.

This project demonstrates **Java GUI development, JDBC connectivity, and CRUD operations** with proper modular** design.

---

##  Features

* **Admin Login** – Secure login with username & password.
* **View Employees** – Displays all employees in a scrollable list with card-style panels.
* **Add Employee** – Insert new employee details into the database.
* **Edit Employee** – Update existing employee records by searching with ID.
* **Delete Employee** – Remove employee records using ID.
* **Exit** – Close the system safely.

---

🛠️ Tech Stack

* **Language:** Java (JDK 18)
* **GUI Framework:** Swing
* **Database:** MySQL
* **Connectivity:** JDBC (MySQL Connector/J)
* **IDE:** IntelliJ IDEA / Eclipse



## 📂 Project Structure

EmployeeManagementSystem/
│── src/
│   │── db/
│   │   └── DBConnection.java
│   │── model/
│   │   └── Employee.java
│   │── ui/
│   │   ├── LoginFrame.java
│   │   ├── MainMenuFrame.java
│   │   ├── ViewEmployeesFrame.java
│   │   ├── AddEmployeeFrame.java
│   │   ├── EditEmployeeFrame.java
│   │   └── DeleteEmployeeFrame.java
│   └── Main.java
│
└── lib/
    └── mysql-connector-java-x.x.x.jar

## ⚙️ Setup Instructions

1. Install **Java JDK 18** (or compatible version).
2. Install **MySQL** and create a database `ems`.
3. Run the following SQL script:

   ```sql
   create database ems;
   use ems;

   create table employee (
       id int primary key,
       name varchar(25),
       gender varchar(10),
       phoneNum varchar(13),
       email varchar(25),
       designation varchar(20),
       salary double
   );

   create table admin (
       username varchar(25) primary key,
       password varchar(25)
   );

   insert into admin values ("admin","admin123"), ("admin2","0000");
   ```
4. Add the **MySQL Connector/J JAR** file to your project (`lib/`).
5. Open the project in IntelliJ/Eclipse and run `Main.java`.


## Learning Outcomes

* Java Swing GUI development.
* JDBC connection with MySQL.
* CRUD (Create, Read, Update, Delete) operations.
* Modular programming with MVC structure.




