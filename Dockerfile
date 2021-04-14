FROM openjdk

RUN mkdir -p /app/convert/

ENV APP_NAME=convert-0.0.1-SNAPSHOT.jar

COPY ${APP_NAME} /app/convert/

EXPOSE 8089

ENTRYPOINT ["java", "-jar", "/app/convert/convert-0.0.1-SNAPSHOT.jar"]