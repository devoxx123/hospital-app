FROM openjdk:8
MAINTAINER 12APP-FACTOR
ADD target/*.jar /msa-eureka.jar
RUN bash -c 'touch /msa-eureka.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-eureka.jar"]
EXPOSE 8761