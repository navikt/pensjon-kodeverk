FROM eclipse-temurin:21-jre

RUN apt-get update && apt-get install -y \
  dumb-init \
  && rm -rf /var/lib/apt/lists/*

WORKDIR /app

ENV LOGGING_CONFIG=classpath:logback-nais.xml
ENV TZ="Europe/Oslo"

COPY target/*.jar app.jar

ENTRYPOINT ["/usr/bin/dumb-init", "--"]
