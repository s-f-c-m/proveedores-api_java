FROM openjdk:16
LABEL maintainer="s-f-c-m"
ADD target/proveedores-0.0.1-SNAPSHOT.jar proveedores-api.jar
ENTRYPOINT ["java", "-jar", "/proveedores-api.jar"]
