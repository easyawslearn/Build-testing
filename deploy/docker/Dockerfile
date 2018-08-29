FROM centos:latest

RUN yum update -y && yum upgrade -y
RUN yum install java-1.8.0-openjdk.x86_64 -y
RUN yum -y install unzip
RUN yum -y install wget
COPY simple-ping-manager.jar simple-ping-manager.jar
EXPOSE 8080
CMD ["java", "-jar", "simple-ping-manager.jar"]
