# Desplegar en Wildfly
- mvn clean package wildfly:deploy
# Arrancar Wildfly en modo debug
- ./standalone.sh --debug
# Ejecutar en Tomcat
- ./mvnw clean spring-boot:run
# Para ejecutar en dev añadir esta linea a launch.json
- "vmArgs": "-Dspring.profiles.active=dev"