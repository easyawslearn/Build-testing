# SimplePingManager 

## Introduction

This is the Simple Ping Manager Service. A small project that can help to health-check of any URL.
Just enter your URL and IP address and wait for the response.

## Building

First ensure your development environment is up-to-date. You will need to
install gradle 3.3+ on macOS, Linux.

Next clone this repository and run make:

    $ make
    
    Note: This build is a java application.
    
To build the docker image run:
    
     $ make docker
    
Application jar available on below path
 
    taget/simple-ping-manager.jar
    
To run the jar file, run below command.
    
    java -jar simple-ping-manager.jar

Access application on

    http://[ip]:8080/
