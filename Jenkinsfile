pipeline {
	agent any
	tools {
        maven 'apache-maven-3.6.3' 
    }
	stages {
		stage('build') {
			steps {
				echo 'This is a minimal pipeline yuty'
				sh 'mvn -v'
			}
		}
	}
}