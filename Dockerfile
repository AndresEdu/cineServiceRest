FROM eclipse-temurin:11-jre-alpine 
RUN addgroup -S spring && adduser -S spring -G spring 
WORKDIR /app
RUN mkdir logs
RUN chown -R spring:spring .
RUN chmod 755 .
USER spring:spring 
ARG JAR_FILE=target/*.jar 
COPY ${JAR_FILE} app.jar 

ENTRYPOINT ["java","-jar","app.jar"] 