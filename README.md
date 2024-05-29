
# Grocery Application

This is a part of my personal projects in owrder to widen my hard skill in being a developer. This simple project was created following an youtube tutorial (https://www.youtube.com/watch?v=31KTdfRH6nY) from @DanVega (https://www.youtube.com/@DanVega).




## Overview
This program is an REST-API that is being connected to Postgres-Database with Docker.

## Project Goals
    1. Enhance technical skill in Backend-Programming using Java
    2. Deepen the knowledge in creating API
## Maven Dependencies

Using Maven as the project's dependency manager, the dependencies are contained in the file pom.xml.

Here are the dependencies that are used in this project:

    1. Spring boot starter web, that includes basic components to create web application.
    2. Spring boot starter validation, used in terms of validation
    3. Spring boot starter JDBC, to simplify JDBC setup in Spring Boot
    4. Spring boot starter data JDBC, provide a simplified and alternative approach in working with JDBC
    5. H2 Database, provides in memory database that is used in development.
    6. PostgreSQL, adds support for PostgreSQL in Spring Boot
    7. Spring boot docker compose, for integration to the docker. In this case, connecting to postgreSQL.
## Technical Description

What is contained in this project:

	1. Creation of a new project using spring.io
    2. Creation of Local simulation of repository using lists, to check various functions before adding them to database.
	3. Using JDBC(Java Database Connectivity) to create Repository.
	4. Loading initial data with JSON File
	5. Creating REST-API
	6. Connecting to the database:
		a. H2
		b. Postgre with Docker
	7. Rest clients
	8. Tests
		a. Junit Test
		b. JDBC Client Test
		c. MVC Test
