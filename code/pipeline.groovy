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
              git clone pipeline {
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
               cd /home/ubuntu/workspace/atharva/studentapp-ui/
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

-----------------my ocde------------------
// pipeline {
//     agent {
//         node {
//             label 'label1'
//         }
//     }
    
//     stages {
//             stage('Pull') {
//                 steps {
//                         git 'https://github.com/AtharvaKeskar2002/studentui.git'
//                 }
//             }
            
//             stage('Build') {
//                 steps {
//                         sh """
//                             cd /home/ubuntu/workspace/atharva/
//                             sudo apt-get install maven -y
//                             mvn clean 
//                             mvn package
//                         """
//                     }
//             }

//             stage('Deploy') {
//                 steps {
//                     sh """
//                             sudo apt update 
//                             sudo apt-get install unzip
//                             wget https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.93/bin/apache-tomcat-8.5.93.tar.gz
//                             sudo tar -xzvf apache-tomcat-8.5.93.tar.gz
//                             cd /home/ubuntu/workspace/atharva/target
//                             sudo mv studentapp-2.2-SNAPSHOT studentapp.war
//                             sudo chmod -R +x /home/ubuntu/workspace/atharva/apache-tomcat-8.5.93/bin

//                             sudo mv /home/ubuntu/workspace/atharva/target/studentapp.war /home/ubuntu/workspace/atharva/apache-tomcat-8.5.93/webapps/studentapp.war
//                             sudo unzip /home/ubuntu/workspace/aharva/apache-tomcat-8.5.93/webapps/studentapp.war -d /home/ubuntu/workspace/aharva/apache-tomcat-8.5.93/webapps/studentapp
//                             cd ..
//                             cd ..
//                             cd ..
//                             cd ..
//                             cd ..
//                             cd /home/ubuntu/workspace/atharva/apache-tomcat-8.5.93/bin
//                             sudo chmod 555 catalina.sh
//                             sudo ./catalina.sh stop
//                             sudo ./catalina.sh start
//                             sudo ./startup.sh
//                     """
//                 }
//             }
//         }
// }
// // sudo apt update 
//                             sudo apt-get install unzip
//                             wget https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.93/bin/apache-tomcat-8.5.93.tar.gz
//                             sudo tar -xzvf apache-tomcat-8.5.93.tar.gz
//                             mv /home/ubuntu/workspace/atharva/target/studentapp-2.2-SNAPSHOT.war /home/ubuntu/workspace/atharva/target/student.war
//                             cp /home/ubuntu/workspace/atharva/target/student.war apache-tomcat-8.5.93/webapps/
//                             cd apache-tomcat-8.5.93/bin/
//                             ./catalina.sh start
// chmod 777 /home/ubuntu/workspace/atharva/apache-tomcat-8.5.93/webapps