# Task-Tracker
Task tracker is a project used to track and manage your tasks. In this task, you will build a simple command line interface (CLI) to track what you need to do, what you have done, and what you are currently working on.


## 🗂 Setting Up the Database

This project uses **MySQL**. If you're setting it up for the first time:

1. Make sure MySQL is installed and running.
2. Create the database:
3. Import the schema and data:
4. Keep Your application.properties as Is
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

Others just need to set their local MySQL username/password correctly.

You can Run this through command line interface or Postman Tool.

How to RUN:

mvnw.cmd spring-boot:run


CREATE Task - POST: 
curl -X POST http://localhost:8080/tasks/add \
     -H "Content-Type: application/json" \
     -d "{\"description\":\"Add Task\"}"
UPDATE Task - PUT :
curl -X POST http://localhost:8080/tasks/add \
     -H "Content-Type: application/json" \
     -d "{\"description\":\"Add Task\"}"
