pipeline {
  agent any
  tools { 
    maven 'Maven 3.9.4' 
    jdk 'jdk17' 
  }

  options {
    skipDefaultCheckout(true)
  }

  environment {
    // JAVA_HOME = '/var/jenkins_home/tools/hudson.model.JDK/jdk17/jdk-17'
  }

  stages{
    stage ('Checkout'){
      steps{
        echo 'Checkout master branch'
        checkout scm
      }
    }

    stage ('Build'){
      steps{
        echo 'Build project'
        sh 'echo $JAVA_HOME'
        sh 'mvn clean package -DskipTests'
      }
    }

    stage('Copy') {
      steps {
        echo 'Copying files...'
        sh 'rm -rf /var/bievel/obision/*'
        sh 'cp ./target/web-0.1.war /var/bievel/obision'
      }
    }
  }
}
