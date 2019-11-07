FROM openjdk:8
MAINTAINER 12APP-FACTOR
ADD target/*.jar /msa-laboratorist.jar
RUN bash -c 'touch /msa-laboratorist.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-laboratorist.jar"]
EXPOSE 8084