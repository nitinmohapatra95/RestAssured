pipeline {
	agent any
	stages {
		stage('build') {
			steps {
				sh 'mvn clean test'
			}
			post  {
				success {
						junit 'target/surefire-reports/**/*.xml' 
						echo 'build success'
				}
			}
			
		}
	}
}