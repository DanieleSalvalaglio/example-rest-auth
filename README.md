# Example legacy api rest Project

This project is an example of legacy api rest.
This example exposes a rest api to authenticate users and get user information.
This project use quarkus framework.

## Requirements

To compile and run this project, you will need:

- JDK 17
- GraalVM 22.3.0
- Quarkus 2.15.1.Final

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:

```
./mvnw package
```

It produces the `quarkus-run.jar` file in the `/target` directory. Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:

```
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 

```
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 

``` 
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-run`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide.

