# Border-Post-Surveillance-Log

A simple GUI-based logging system for border security personnel. Built using Java (BlueJ) and connected to a MySQL (phpMyAdmin)  database using JDBC via XAMPP.

---

## 💻 Requirements

- BlueJ IDE
- Java JDK (version 17 or above)
- XAMPP Control Panel
- MySQL (phpMyAdmin)
- MySQL JDBC Connector

---



## 🛠️ Project Setup

Follow these steps to set up and run the project on your local machine.



## ⚙️ How to Run the Project

### 🔹 Step 1: Set up the Database

1. Open **XAMPP** and start **Apache** & **MySQL**.
2. Open your browser → go to `http://localhost/phpmyadmin`.
3. Create a new database named `border_security`.
4. Import the SQL file from the `sql/border_security_schema.sql`.

### 🔹 Step 2: Setup in BlueJ

1. Open BlueJ and open this project.
2. Go to `Project > Use Library > Add External JARs` and add the MySQL JDBC connector JAR file.


### 🔹 Step 3: Run the App

1. Compile all `.java` files.
2. Right-click on `BorderlogGUI` → click `void main(String[] args)`.
3. App GUI will open.

---

## 🗃️ Database Design

### Database: `border_security`
### Table: `logs`

Fields include:
- `LOG_ID`, `POST_NAME`, `INCIDENT_TIME`, `DESCRIPTION`
- `OFFICER_NAME`, `OFFICER_ID`, `LOCATION`
- `WEATHER_CONDITION`, `WITNESS_NAME`, `VEHICLE_NUMBER`, `VEHICLE_ID`

SQL file is in: `sql/border_security_schema.sql`

---

## ✨ Features

- Simple GUI for log entry
- Connected to MySQL using JDBC
- Form captures details like post, incident time, officer info, vehicle, etc.

---


