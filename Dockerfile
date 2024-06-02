FROM alpine:latest

WORKDIR /root

RUN apk update && \
    apk add --no-cache openjdk21-jdk && \
    java --version && \
    apk add --no-cache maven

COPY . /root/clean-cut

WORKDIR /root/clean-cut

RUN mvn clean install -DskipTests

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "sleep 10s && mvn spring-boot:run"]
