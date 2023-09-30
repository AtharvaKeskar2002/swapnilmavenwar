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
                            sudo apt update 
                            sudo apt-get install unzip
                            wget https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.13/bin/apache-tomcat-10.1.13.zip
                            cd
                            sudo unzip apache-tomcat-10.1.13.zip 
                            sudo chmod -R +x apache-tomcat-10.1.13
                            mv /home/ubuntu/workspace/atharva/target/studentapp-2.2-SNAPSHOT.war /home/ubuntu/workspace/atharva/target/student.war
                            cp /home/ubuntu/workspace/atharva/target/student.war apache-tomcat-10.1.13/webapps/
                            cd tomcat/apache-tomcat-10.1.13/bin/
                            ./catalina.sh start
                    """
                }
            }
        }
}
