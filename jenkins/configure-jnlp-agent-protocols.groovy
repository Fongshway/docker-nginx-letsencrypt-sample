/*
   Copyright (c) 2015-2017 Sam Gleske - https://github.com/samrocketman/jenkins-bootstrap-shared

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   */
/*
   Disable all JNLP protocols except for JNLP4.  JNLP4 is the most secure agent
   protocol because it is using standard TLS.
 */
import jenkins.model.Jenkins

Jenkins instance = Jenkins.getInstance()

if(!instance.isQuietingDown()) {
    Set<String> agentProtocolsList = ['JNLP4-connect']
    if(!instance.getAgentProtocols().equals(agentProtocolsList)) {
        instance.setAgentProtocols(agentProtocolsList)
        println "Agent Protocols have changed.  Setting: ${agentProtocolsList}"
        instance.save()
    }
    else {
        println "Nothing changed.  Agent Protocols already configured: ${instance.getAgentProtocols()}"
    }
}
else {
    println 'Shutdown mode enabled.  Configure Agent Protocols SKIPPED.'
}
