# Backend Web Service AS400
###### Version 1.0

Servicios REST para Tigo Ordenes de Trabajo AS400.

## Configuration
- Spring Boot 2.6.0-SNAPSHOT
- Java 1.8 
- Maven 3.6.3

## Dependencies
- JPA
- Web
- AOP

## Usage
#### Clone repository
```
git clone https://github.com/CGMGT/getDataAS400/src.git
```
#### Project information
```
    <groupId>gt.com.tigo</groupId>
    <artifactId>getDataAS400-api</artifactId>
    <version>1.0</version>
    <packaging>war</packaging>
    <name>getDataAS400-api</name>
    <description>Tigo Web Service Get Data AS400 API</description>
```
#### Base package
```
    gt.com.tigo.getDataAS400
```
#### Main class
```
    public class getDataAS400Application extends SpringBootServletInitializer implements WebApplicationInitializer {
        ...
    }
```
#### Main class path
```
    <project-path>/src/main/java/gt/com/tigo/getDataAS400/getDataAS400Application.java
```
#### Weblogic configuration
```
<wls:context-root>/getDataAS400-api</wls:context-root>
```
#### Build
```
mvn package
```
#### API Documentation
```
N/A
```