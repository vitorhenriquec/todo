# API To-do [1.0.1] 
A rest api for a todo list system. Delevelop to attend the Internship selection process challenge.

The challange was to build an web aplication that allows save, update and
remove a register (CRUD) , e show them as the example: http://todomvc.com/examples/angularjs/#/. 

This API follows these itens:
- A. Criar uma aplicação java web utilizando JavaServer Faces (JSF)
- B. Utilizar persistência em um banco de dados (qualquer banco desejado)
- C. Utilizar Hibernate e JPA (Use Hibernate )
- D. Utilizar Spring Framework Boot 2.0
- F. Publicar projeto no heroku

## Configuration

To run this project, you must have installed:
- Java JDK 8
- PostgresSQL Driver
- PgAdmin

### Setup locallly

#### 1 - By Eclipse IDE
To continue this step-by-step, download the lastest version of Eclipse IDE.

##### 1.1 Database
- Create a database and set a name.

##### 1.2 - IDE and Spring
- To make things easier install the Spring extension;

- WARNING! In the ``buildpath > configure build path`` set the jre system library to the JDK;

- In application.properties use the following lines:  

    ``spring.datasource.url=jdbc:postgresql://localhost:DB_PORT/DB_NAME``  
    ``spring.datasource.username=DB_USER``
    ``spring.datasource.password=DB_PASS``  
    ``spring.jpa.hibernate.ddl-auto=update``  

PS: ``DB_PORT`` is the port of your local postgres database, ``DB_NAME`` is the database name that you've created on step 1.1, ``DB_USER`` is your local database username and ``DB_PASS`` is the password for the ``DB_USER``.

- Run the project and it's done;
- Open in a browser http://localhost:8080 and you API will be running.

### Terminal

To continue this step-by-sep, download and set up the Maven to execute in your terminal and make sure java is configure as well. Open your the terminal then:

- Go to your project folder.
- Execute ``mvn clean install`` to build the ``.jar``;
- Execute ``java -jar target/Todo-0.0.1-SNAPSHOT.jar``.

## Online example

There's an example of this API deployed on Heroku and working on: https://todo-esig.herokuapp.com/api/v1/task

## Requests

All the request has the base path ``/api/v1/task``.

- ``GET`` - Return a list of task saved.
- ``POST`` - Save a task. Requires a JSON body with description(String) and active(true or false).
- ``UPDATE`` - Update the task's active properties by id. Requires a task id as a path variable. Example: ``/api/v1/taks/1``.
- ``DELETE`` - Delete a task's active by id. Requires a task id as a path variable. Example: ``/api/v1/taks/1``.


Developed by Vitor Henrique.