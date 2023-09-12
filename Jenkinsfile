pipeline {
  agent any
  tools { 
    maven 'Maven 3.3.9' 
    jdk 'jdk17' 
  }

  options {
    skipDefaultCheckout(true)
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
