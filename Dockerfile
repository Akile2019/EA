FROM openjdk:11
ADD target/Akkis-Mini-Project.jar Akkis-Mini-Project.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar", "Akkis-Mini-Project.jar"]