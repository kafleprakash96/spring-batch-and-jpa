
# Spring Batch With Spring Data Jpa

### This project demonstrates how to read a CSV file containing names, convert those names to uppercase, and save the results into a database using Spring Boot and Spring Batch.

This Spring Boot Batch project includes:

- **Reading** data from a CSV file.
- **Processing** the data (converting names to uppercase).
- **Writing** the transformed data to a database using JPA.



Before you begin, ensure you have the following installed:

- **Java 17** or higher
- **Maven** or **Gradle** for building the project
- **MySQL** database for storing results
- **IDE** (like IntelliJ IDEA or Eclipse) for development

### Setup

1. **Clone the Repository**

   ```bash
   git clone https://github.com/kafleprakash96/spring-batch-and-jpa.git
   cd spring-batch-and-jpa


2. **Update application.properties file under `src/main/resources/application.properties`**
        
    - For this project I have used spring-batch as my schema. If you are working on other schema, replace spring.datasource.url with your own schema name
    - Replace username and password with your own.


  ```bash
      spring.application.name=spring-batch-demo


      spring.datasource.url = jdbc:mysql://localhost:3306/spring-batch
      spring.datasource.username = root
      spring.datasource.password = password
        
      spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
        
      spring.datasource.driver-class-name= com.mysql.cj.jdbc.Driver
        
      spring.jpa.hibernate.ddl-auto = update
```

3. **Run schema-all.sql script under `assets` folder**
    
    This will create all the necessary tables that spring-batch use to store the information about the job

4. **Running the application**

   Open your terminal, navigate to your project directory, and run the following command:

    ```bash
    ./mvnw spring-boot:run
    ```
       
The application execute the job that takes firstname and lastname from csv file (person-data.csv) in path `src/main/resources` and converts into uppercase and save the data in `person` table.

### Following are the screenshot of application

- **Application run:**

![application-run.png](assets%2Fss%2Fapplication-run.png)

- **CSV sample:**

![person-data-csv.png](assets%2Fss%2Fperson-data-csv.png)

- **Database:**

![db.png](assets%2Fss%2Fdb.png)
