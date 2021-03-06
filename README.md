# bake-api project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

> **_NOTE:_** Go to src/main/resources on the terminal and run the below to generate the keys.
#Create a Private key
```shell script
openssl req -newkey rsa:2048 -new -nodes -keyout privatekey.pem -out csr.pem
```
#Create a Public key
```shell script
openssl rsa -in privatekey.pem -pubout > publickey.pem
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```
> **_NOTE:_** Creating a Jwt Token.
> 
```
POST http://localhost:8080/api/auth/login

{
    "username": "user",
    "password": "user"
}
```
> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/bake-api-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Related guides

- RESTEasy JSON-B ([guide](https://quarkus.io/guides/rest-json)): JSON-B serialization support for RESTEasy
- SmallRye JWT ([guide](https://quarkus.io/guides/security-jwt)): Secure your applications with JSON Web Token

## Provided examples

### RESTEasy JAX-RS example

REST is easy peasy with this Hello World RESTEasy resource.

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
