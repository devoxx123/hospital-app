FROM openjdk:8
MAINTAINER 12APP-FACTOR
ADD target/*.jar /msa-patient.jar
RUN bash -c 'touch /msa-patient.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-patient.jar"]
EXPOSE 8085