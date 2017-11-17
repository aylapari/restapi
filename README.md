# restapi
Rest API for payments resource
1. Spring Boot REST API
2. TDD with Spring Test
3. Integration test with Docker


# Requirements
Java - 1.8  
Maven - 3.5    
docker - 17.04

# Installation
1. Clone the repository
2. Export docker host
3. Set docker host ip in the pom.xml
4. The assumption is docker is running in the local host

# Run commands
mvn -Dmaven.test.skip=true package
        Package the REST API

mvn docker:build
        Build docker image

mvn docker:start
        Start the container

mvn verify
        Run all the unit and integration tests



