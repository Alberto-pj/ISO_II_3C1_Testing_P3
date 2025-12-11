# Demo Maven Project

A minimal Maven Java project targeting Java 17 with JUnit 5 tests.

## Prerequisites
- Java 17+ on PATH (`java -version`)
- Maven 3.9+ (`mvn -v`)

## Build and test
```bash
mvn clean verify
```

## Run the app
```bash
mvn -q package
java -cp target/demo-1.0.0-SNAPSHOT.jar com.example.App
```
