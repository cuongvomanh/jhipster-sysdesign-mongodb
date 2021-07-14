# mymongdbapp

## Install mongodb

https://github.com/bitnami/bitnami-docker-mongodb.git

## Build and run

```
mvn clean package
java -jar target/mymongdbapp-0.0.1-SNAPSHOT.jar
```

## Call bank account api

```
curl -X PUT --header 'Content-Type: application/json' -d '{"id":"002", "number":"00002","balance":100}'  'http://localhost:8081/api/bankAccount/bank-accounts'
curl -X POST --header 'Content-Type: application/json' -d '{"accountNumber":"00002","ammount":1}'  'http://localhost:8081/api/bankAccount/withdraw'
```
## Other
https://github.com/mongodb-developer/java-quick-start

https://github.com/spring-projects/spring-data-examples.git
