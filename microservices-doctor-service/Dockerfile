FROM openjdk:8
MAINTAINER 12APP-FACTOR
ADD target/*.jar /msa-doctor.jar
RUN bash -c 'touch /msa-doctor.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-doctor.jar"]
EXPOSE 8082