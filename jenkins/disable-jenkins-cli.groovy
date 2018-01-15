#!groovy
import jenkins.CLI

// https://support.cloudbees.com/hc/en-us/articles/234709648-Disable-Jenkins-CLI
def enableCli = CLI.get()
enableCli.setEnabled(false)
