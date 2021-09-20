# Students Enrollment Service

### Prerequisuite
    - Java 11 or above
    - gradle 7

### Test
    - Run `gradle check` 

### Steps to build
    Execute below command
    - `gradle build`
    - `java -jar build/libs/students-enrollment-0.0.1-SNAPSHOT.jar`

Endpoints
* Get students
    ```
        curl --location --request GET 'localhost:8080/students' \
        --header 'Content-Type: application/json'
    ```

* Post Student
    ```
        curl --location --request POST 'localhost:8080/students' \
        --header 'Content-Type: application/json' \
        --data-raw '{
            "id": "9999",
            "firstName": "first",
            "lastName": "last",
            "class": "10 A",
            "nationality": "ind"
        }'
    ```
    Please use the Postman requests json file 'Assignment.postman_collection.json' to import and fire the requests
