FROM openjdk:17
ADD build/libs/BankApp-0.0.1-SNAPSHOT.jar bankapp.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "/bankapp.jar"]
