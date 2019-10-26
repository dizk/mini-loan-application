# Mini-lånesøknad

REST-api for å sende inn lånesøknader og sjekke status.

## Bygge og kjøre applikasjonen

For å bygge applikasjonen trenger man følgende:
1. JDK 8
1. Maven

Man kan bygge og kjøre applikasjoenen slik:
```shell script
mvn package && java -jar target/mini-loan-application-1.0-SNAPSHOT.jar
```

## Swagger dokumentasjon

Applikasjonen bundler swagger-ui

* swagger-ui http://localhost:8080
* openapi-json http://localhost:8080/openapi.json
* openapi-yaml http://localhost:8080/openapi.yaml

Eventuelt: `src/main/resources/openapi.yaml`

# TODO
1. Konsistent språkbruk, APIet sine objekter er norsk og engelsk om hverandre. 
