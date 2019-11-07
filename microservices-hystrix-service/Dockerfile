FROM openjdk:8
MAINTAINER 12APP-FACTOR
ADD target/*.jar /msa-hystrix.jar
RUN bash -c 'touch /msa-hystrix.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-hystrix.jar"]
EXPOSE 7979