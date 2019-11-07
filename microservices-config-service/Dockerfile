FROM openjdk:8
MAINTAINER 12APP-FACTOR
ADD target/*.jar /msa-config.jar
RUN bash -c 'touch /msa-config.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-config.jar"]
EXPOSE 8888