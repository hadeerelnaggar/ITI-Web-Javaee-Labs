#!/bin/sh
mvn clean package && docker build -t com.mycompany/EJBTimer .
docker rm -f EJBTimer || true && docker run -d -p 9080:9080 -p 9443:9443 --name EJBTimer com.mycompany/EJBTimer