# School Manager API

This is an ongoing API project of school management. Bellow are the current configurations and funcionalities. 

## Database Configuration

The project uses MySQL database. The configuration can be found in the **'application.yml'** file. The MySQL connector dependency has been added to the **'pom.xml'** file.

``` 
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/{url of your database}?useTimezone=true&serverTimezone=UTC
    username: {your username}
    password: {your password}
  jpa:
    open-in-view: false
    hibernate:
      ddl-auto: update
    show-sql: false
```
```
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
```
## Current features

1. Create Teacher
    * Endpoint: **'POST /teacher'**
    * Creates a new teacher based on the provided data.
2. Get Teacher by ID
    * Endpoint: **'GET /teacher/{id}'**
    * Returns information about the teacher with the provided ID.
3. Get all Teachers
    * Endpoint: **'GET /teacher'**
    * Returns a list of all registered teachers.
4. Update Teacher Information
    * Endpoint: **'PUT /teacher'**
    * Updates information for an existing teacher.
5. Delete Teacher
    * Endpoint: **'DELETE /teacher/{id}'**
    * Removes a teacher with the provided ID

## Upcoming Features(Coming Soon)
1. **Add More functionalities...**

**This document will be updated as new features are implemented**
