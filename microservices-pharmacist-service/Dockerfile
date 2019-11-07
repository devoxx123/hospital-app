FROM openjdk:8
MAINTAINER 12APP-FACTOR
ADD target/*.jar /msa-pharmacist.jar
RUN bash -c 'touch /msa-pharmacist.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-pharmacist.jar"]
EXPOSE 8086