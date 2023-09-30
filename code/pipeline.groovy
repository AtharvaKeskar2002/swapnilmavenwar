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
                            cd /home/ubuntu/workspace/atharva/target
                            sudo mv studentapp-2.2-SNAPSHOT studentapp.war
                            sudo chmod -R +x /home/ubuntu/workspace/atharva/apache-tomcat-8.5.93/bin

                            sudo mv /home/ubuntu/workspace/atharva/target/studentapp.war /home/ubuntu/workspace/atharva/apache-tomcat-8.5.93/webapps/studentapp.war
                            sudo unzip /home/ubuntu/workspace/aharva/apache-tomcat-8.5.93/webapps/studentapp.war -d /home/ubuntu/workspace/aharva/apache-tomcat-8.5.93/webapps/studentapp
                            cd ..
                            cd ..
                            cd ..
                            cd ..
                            cd ..
                            cd /home/ubuntu/workspace/atharva/apache-tomcat-8.5.93/bin
                            sudo chmod 555 catalina.sh
                            sudo ./catalina.sh stop
                            sudo ./catalina.sh start
                            sudo ./startup.sh
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
// chmod 777 /home/ubuntu/workspace/atharva/apache-tomcat-8.5.93/webapps