pipeline {
    agent {
        node {
            label 'label1'
        }
    }
    
    stages {
            stage('Pull') {
                steps {
                        git 'https://github.com/AtharvaKeskar2002/studentui.git'
                }
            }
            
            stage('Build') {
                steps {
                        sh """
                            cd /home/ubuntu/workspace/atharva/
                            sudo apt-get install maven -y
                            mvn clean 
                            mvn package
                        """
                    }
            }

            stage('Deploy') {
                steps {
                    sh """
                            apt update -y
                            sudo apt-get install unzip
                            wget https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.13/bin/apache-tomcat-10.1.13.zip
                            sudo mkdir /opt/tomcat
                            sudo unzip apache-tomcat-10.1.13.zip -d /opt/tomcat
                            sudo chmod -R +x /opt/tomcat/apache-tomcat-10.1.13
                            cp /home/ubuntu/workspace/target/studentapp.war /opt/tomcat/apache-tomcat-10.1.13/webapps/
                    """
                }
            }
        }
}
