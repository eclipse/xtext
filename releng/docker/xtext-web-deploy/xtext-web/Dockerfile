FROM jetty:9.4-jre11

COPY --chown=999:999 org.eclipse.xtext.web.example.jetty-*.war /var/lib/jetty/webapps/ROOT.war

COPY --chown=999:999 test-files /var/lib/jetty/test-files