# Use the Tomcat 9.0 image based on Alpine
FROM javahamitmizrak/tomcat10_jdk11

# Copy your application WAR file to the webapps directory
COPY target/demo-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

# Set the working directory to Tomcat's bin directory
WORKDIR /usr/local/tomcat/bin

# Start Tomcat
CMD ["catalina.sh", "run"]

