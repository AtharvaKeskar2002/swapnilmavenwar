pipeline {
    agent {
        node {
            label 'lable1'
        }

    }
    stages {
        stage('git commit') {
            steps {
              sh '''
              git clone https://github.com/AtharvaKeskar2002/studentui.git
        
        '''  
            }
        }
        stage('build') {
            steps {
                sh '''
               sudo apt install maven -y
               cd /home/ubuntu/workspace/project/studentapp-ui/
               mvn clean
               mvn package
                '''
            }
        }
        stage('test') {
            steps {
                echo "successfully test"
            }
        }
        stage('deploy') {
            steps {
              sh '''
              
              sudo wget -P /mnt https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.93/bin/apache-tomcat-8.5.93.zip
              
              cd /mnt
              sudo apt install unzip -y
              sudo unzip apache-tomcat-8.5.93.zip
              sudo cp  /home/ubuntu/workspace/project/studentapp-ui/target/studentapp-2.2-SNAPSHOT.war /mnt/apache-tomcat-8.5.93/webapps/
              sudo mv /mnt/apache-tomcat-8.5.93/webapps/studentapp-2.2-SNAPSHOT.war /mnt/apache-tomcat-8.5.93/webapps/studentapp.war
              sudo chmod -R +x /mnt/apache-tomcat-8.5.93/bin/
              cd /mnt/apache-tomcat-8.5.93/bin/
              sudo ./startup.sh 
              '''
            }
        }
        
    }
}