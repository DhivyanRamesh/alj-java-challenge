### How to use this spring-boot project

- Install packages with `mvn package`
- Run `mvn spring-boot:run` for starting the application (or use your IDE)

Application (with the embedded H2 database) is ready to be used ! You can access the url below for testing it :

- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console

> Don't forget to set the `JDBC URL` value as `jdbc:h2:mem:testdb` for H2 UI.



### Instructions

- download the zip file of this project
- create a repository in your own github named 'java-challenge'
- clone your repository in a folder on your machine
- extract the zip file in this folder
- commit and push

- Enhance the code in any ways you can see, you are free! Some possibilities:
  - Add tests
  - Change syntax
  - Protect controller end points
  - Add caching logic for database calls
  - Improve doc and comments
  - Fix any bug you might find
- Edit readme.md and add any comments. It can be about what you did, what you would have done if you had more time, etc.
- Send us the link of your repository.

#### Restrictions
- use java 8


#### What we will look for
- Readability of your code
- Documentation
- Comments in your code 
- Appropriate usage of spring boot
- Appropriate usage of packages
- Is the application running as expected
- No performance issues

#### Your experience in Java

Please let us know more about your Java experience in a few sentences. For example:

- I have 6+ years experience in Java and I have been using Spring Boot from last 3+ years.
- I have an overall experience of 11+ years in the industry with good knowledge of various Java based frameworks.
- I am technology agnostic and have had the fruitfulness of Java while working with other programming languages as well.
- I always felt Java could be the best solution for any larger dynamic applications with my experience. 

#### Changes done to existing project
- Have tried to incorporate all the above mentioned enhancements under instructions section.
- Have added couple of additional APIs for bulk save & delete.
- Have altered the table with audit columns to track the record history.

#### Short description of the project
- Admin users only are authorized to use this Employee Application
- The user can do all the CRUD operations (Get, Save, Update, Delete employees)
- The application is ready to be used and can be executed with the API swaggers and verified in the console.
- Kindly refer Security config file for the Authentication

#### Further scope for enhancements
If I had more time, could have done following enhancements
- Would have added more role based authentication like Admin, Manager, Employee etc with access limitations
- Would have achieved more code coverage with Junits
- Would have prepared design documents such as flow diagram, API mapping sheets. Table design etc
