FROM openjdk:8
MAINTAINER 12APP-FACTOR
ADD target/*.jar /msa-hospital.jar
RUN bash -c 'touch /msa-hospital.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-hospital.jar"]
EXPOSE 8083