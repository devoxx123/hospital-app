FROM openjdk:8
MAINTAINER 12APP-FACTOR
ADD target/*.jar /msa-zipkin.jar
RUN bash -c 'touch /msa-zipkin.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-zipkin.jar"]
EXPOSE 8888