FROM openjdk:8
MAINTAINER 12APP-FACTOR
ADD target/*.jar /msa-admin.jar
RUN bash -c 'touch /msa-admin.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-admin.jar"]
EXPOSE 9090