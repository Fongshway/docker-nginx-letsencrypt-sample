#!groovy

import hudson.security.csrf.DefaultCrumbIssuer
import jenkins.model.Jenkins

// https://gist.github.com/ivan-pinatti/7d8a877aff42350f16fcb1eb094818d9
// https://wiki.jenkins.io/display/JENKINS/CSRF+Protection
Jenkins instance = Jenkins.getInstance()

instance.setCrumbIssuer(new DefaultCrumbIssuer(true))

instance.save()
