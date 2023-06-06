FROM openjdk:17
COPY "/target/QR-Code-Generator-0.0.1-SNAPSHOT.jar" .
ENTRYPOINT ["java", "-jar", "QR-Code-Generator-0.0.1-SNAPSHOT.jar"]