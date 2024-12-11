# Use the Tomcat 9.0 image based on Alpine
FROM tomcat:9.0-alpine

# Copy your application WAR file to the webapps directory
COPY target/demo-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/demo.war

# Set the working directory to Tomcat's bin directory
WORKDIR /usr/local/tomcat/bin

CMD ["catalina.sh", "run"]