@echo off
call mvn clean package
call docker build -t com.mycompany/EJBTimer .
call docker rm -f EJBTimer
call docker run -d -p 9080:9080 -p 9443:9443 --name EJBTimer com.mycompany/EJBTimer