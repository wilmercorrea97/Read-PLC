FROM openjdk:11-jdk-slim
COPY target/plc-0.0.1-SNAPSHOT.war /service.war
ADD lib/mssql-jdbc-12.2.0.jre11.jar /lib/mssql-jdbc-12.2.0.jre11.jar
ENTRYPOINT ["java","-jar","/service.war"]