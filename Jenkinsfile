pipeline {
	agent any
	tools {
        maven 'apache-maven-3.6.3' 
    }
	stages {
		stage('build') {
			steps {
				echo 'Building the project'
				sh 'mvn clean compile'
			}
		}
		stage('test') {
			steps {
				echo 'Test'
				sh 'mvn test'
			}
		}
		stage('sonar') {
			environment {
            	scannerHome = tool 'sonarqubescanner'
    		}
    		steps {
    			echo 'sonar initialization'
        		withSonarQubeEnv('sonar') {
            		sh "${scannerHome}/bin/sonar-scanner"
            		echo 'sonar check completed'
				}
			}
		}
	}
	post {
        always {
            echo 'JENKINS PIPELINE'
        }
        success {
            echo 'JENKINS PIPELINE SUCCESSFUL'
        }
        failure {
            echo 'JENKINS PIPELINE FAILED'
        }
        unstable {
            echo 'JENKINS PIPELINE WAS MARKED AS UNSTABLE'
        }
        changed {
            echo 'JENKINS PIPELINE STATUS HAS CHANGED SINCE LAST EXECUTION'
        }
    }
}