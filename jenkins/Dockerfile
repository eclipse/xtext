# for documentation, see
# https://hub.docker.com/r/library/jenkins/

FROM jenkins

USER root

# Xvn on ubuntu:
# http://blog.dahanne.net/2011/07/18/run-ui-tests-on-a-headless-jenkins-hudson-continuous-integration-server-running-ubuntu/

RUN apt-get update && apt-get -y install vim vnc4server fluxbox gradle


# USER jenkins # we're "using su -c 'whoami' jenkins" instead

COPY jenkins_conf/* /usr/share/jenkins/ref/
#COPY ssh/ /usr/share/jenkins/ref/.ssh/

RUN chown -R jenkins:jenkins /usr/share/jenkins/ref/
#RUN chmod 0600 /usr/share/jenkins/ref/.ssh/id_rsa

COPY plugins.txt /usr/share/jenkins/ref/
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/ref/plugins.txt

ENTRYPOINT su -c '/bin/tini -- /usr/local/bin/jenkins.sh --ajp13Port=8102 --ajp13ListenAddress=127.0.0.1' jenkins
