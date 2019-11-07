FROM openjdk:8
MAINTAINER 12APP-FACTOR
ADD target/*.jar /msa-department.jar
RUN bash -c 'touch /msa-department.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-department.jar"]
EXPOSE 8081