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
                            wget https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.93/bin/apache-tomcat-8.5.93.tar.gz
                            sudo tar -xzvf apache-tomcat-8.5.93.tar.gz
                            mv target/studentapp-2.2-SNAPSHOT.war apache-tomcat-8.5.93/webapps/student.war
                            cd apache-tomcat-8.5.93/bin/
                            ./catalina.sh start
                    """
                }
            }
        }
}
// sudo apt update 
//                             sudo apt-get install unzip
//                             wget https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.93/bin/apache-tomcat-8.5.93.tar.gz
//                             sudo tar -xzvf apache-tomcat-8.5.93.tar.gz
//                             mv /home/ubuntu/workspace/atharva/target/studentapp-2.2-SNAPSHOT.war /home/ubuntu/workspace/atharva/target/student.war
//                             cp /home/ubuntu/workspace/atharva/target/student.war apache-tomcat-8.5.93/webapps/
//                             cd apache-tomcat-8.5.93/bin/
//                             ./catalina.sh start