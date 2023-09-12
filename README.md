# Desplegar en Wildfly
- mvn clean package wildfly:deploy
# Arrancar Wildfly en modo debug
- ./standalone.sh --debug
# Ejecutar en Tomcat
- ./mvnw clean spring-boot:run