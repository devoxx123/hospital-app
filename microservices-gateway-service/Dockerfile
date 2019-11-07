FROM openjdk:8
MAINTAINER 12APP-FACTOR
ADD target/*.jar /msa-gateway.jar
RUN bash -c 'touch /msa-gateway.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-gateway.jar"]
EXPOSE 8080