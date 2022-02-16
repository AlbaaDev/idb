1. Requirements : Java 11 and mysql 8+
2. Create mysql database named idb
3. Change the database credentials with yours in application.properties file located in src/main/resources :
              spring.datasource.username=your_database_username
              spring.datasource.password=your_database_password
4. Add a value for the variable jwt.secret in application.properties :
              jwt.secret=your_jwt_secret
5. In root project idb/src/ run the maven command to install the package : 
              mvn clean install 
6. run the generated jar inside idb/target/  with : 
              java -jar bank-0.0.1-SNAPSHOT.jar
7. Access the app in your web browser by typing : 
              http://localhost:8080
