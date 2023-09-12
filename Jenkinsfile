pipeline {
  agent any

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

    stage('Copy') {
      steps {
        echo 'Copying files...'
        sh 'rm -rf /var/bievel/obision/*'
        sh 'cp ./* /var/bievel/obision -R'
      }
    }
  }
}
