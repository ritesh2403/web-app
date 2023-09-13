#FROM jboss/wildfly

#COPY target/springmvc.war /opt/jboss/wildfly/standalone/deployments

#EXPOSE 8080 9990

#CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

# Use the official Tomcat image as the base image
FROM tomcat:9.0

# Copy the WAR file to the Tomcat webapps directory
COPY target/springmvc.war /usr/local/tomcat/webapps/

# Expose ports (8080 for HTTP and 9990 for management, if needed)
EXPOSE 8080 9990

# Start Tomcat with the necessary options
CMD ["catalina.sh", "run"]
