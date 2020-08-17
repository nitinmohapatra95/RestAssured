pipeline {
	master
	tools {
  		maven 'apache-maven-3.6.3'
  	}
	stages {
		stage('build') {
			steps {
				sh 'mvn -v'
			}
		}
	}
}