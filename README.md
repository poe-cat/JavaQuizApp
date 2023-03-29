# Java Quiz Application

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Running the application locally](#running-the-application-locally)
* [Live](#live)

## General info
This application allows users to test their knowledge of Java basics. Users are required to enter their name, and then answer 10 questions, each with only one correct answer. After submitting their answers, users can view their score and access a leaderboard of top performers.

In addition, authenticated users have the ability to contribute their own questions to the quiz. These user-generated questions will be displayed randomly to other quiz takers.

## Technologies
Project is created with:
* Java version: 17
* Spring Boot version: 2.6.7
* Bootstrap version: 5
* Thymeleaf version: 3.0
* MySQL version: 8.0

## Setup
The project includes the Maven wrapper, so there is no need to install Maven to run the app. Run MySQL server. You need to import App data from **data.sql** file (directory: /resources/ ). 

### Command line MySQL import
Type: 
```mysql -u username -p database_name < data.sql```
The username refers to your MySQL username.
database_name refers to the database you want to import.
If you've assigned a password, type it and press Enter.

### application.properties
In application.properties (/resources/) enter your database url, your MySQL password and username.

Example:
```
spring.datasource.url = jdbc:mysql://localhost:3306/your_database?createDatabaseIfNotExist=true
spring.datasource.username = root
spring.datasource.password = password
```

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.poecat.JavaQuizApp.JavaQuizAppApplication class from your IDE.

Alternatively, you can use the Spring Boot Maven plugin:

```mvn spring-boot:run```


## Live 

Currently unavailable, but app will come back to AWS soon.

![javaquiz](https://user-images.githubusercontent.com/84228264/177038436-778d4610-e075-4dce-b5d8-5529f0e7bab9.png)

## Credits
<a href="https://www.freepik.com/psd/3d-woman">3d woman psd created by freepik - www.freepik.com</a>
