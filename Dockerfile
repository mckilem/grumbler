FROM tomcat:8.0-jre8
# Copy configurations
COPY /configs/tomcat-users.xml /usr/local/tomcat/conf/
COPY /configs/context.xml /usr/local/tomcat/webapps/manager/META-INF/
# Copy application
COPY /target/grumbler-app.war /usr/local/tomcat/webapps/grumbler-app.war
