@echo off
call mvn clean package
call docker build -t com.mycompany/EJBLab1Maven .
call docker rm -f EJBLab1Maven
call docker run -d -p 9080:9080 -p 9443:9443 --name EJBLab1Maven com.mycompany/EJBLab1Maven