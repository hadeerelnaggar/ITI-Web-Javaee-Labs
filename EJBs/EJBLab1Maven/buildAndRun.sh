#!/bin/sh
mvn clean package && docker build -t com.mycompany/EJBLab1Maven .
docker rm -f EJBLab1Maven || true && docker run -d -p 9080:9080 -p 9443:9443 --name EJBLab1Maven com.mycompany/EJBLab1Maven