FROM alpine:latest as build

RUN apk update
RUN apk add openjdk17

COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-alpine
EXPOSE 8284
COPY --from=build ./build/libs/elbuensabor-0.0.1-SNAPSHOT.jar-0.0.1-SNAPSHOT.jar ./app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
