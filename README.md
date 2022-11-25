# Java Quiz Application

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Running the application locally](#running-the-application-locally)
* [Live](#live)

## General info
In this app users can test their knowledge of Java basics. After giving your name, the quiz asks you 10 questions. For each only one answer is correct. After submit you'll see your score, you can also check out top scores.
Additionaly, authenticated users can add their own questions to quiz. User's question will display randomly next time the quiz is taken. 

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

Application has been deployed to AWS. To see how it works live, go to http://javaquizmysqlaws-env.eba-fudmufn7.eu-central-1.elasticbeanstalk.com .

![javaquiz](https://user-images.githubusercontent.com/84228264/177038436-778d4610-e075-4dce-b5d8-5529f0e7bab9.png)

You can register there as a new user or use existing user's credentials: 
**email@wp.pl** for username and 
**passing123** for password :shipit: .

## Credits
<a href="https://www.freepik.com/psd/3d-woman">3d woman psd created by freepik - www.freepik.com</a>
