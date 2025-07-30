FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/*.jar app.jar

ENV LOGGING_CONFIG=classpath:logback-nais.xml
ENV TZ="Europe/Oslo"

CMD ["java", "-jar", "app.jar"]
