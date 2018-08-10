FROM tomcat:9-jre10
ADD target/MongoTomcat-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
EXPOSE 8088
CMD chmod +x /usr/local/tomcat/bin/catalina.sh
CMD ["catalina.sh", "run"]