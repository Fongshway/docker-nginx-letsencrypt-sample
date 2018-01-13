FROM jenkins/jenkins:lts-alpine

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

COPY create-admin-account.groovy /usr/share/jenkins/ref/init.groovy.d/create-admin-account.groovy
COPY set-default-crumb-issuer.groovy /usr/share/jenkins/ref/init.groovy.d/set-default-crumb-issuer.groovy
COPY disable-jenkins-cli.groovy /usr/share/jenkins/ref/init.groovy.d/disable-jenkins-cli.groovy
COPY configure-jnlp-agent-protocols.groovy /usr/share/jenkins/ref/init.groovy.d/configure-jnlp-agent-protocols.groovy

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt
