pipeline {
	agent any

	options {
		buildDiscarder(logRotator(numToKeepStr:'15'))
	}

	tools { 
		maven 'M3'
	}
	
	
	stages {
		stage('Checkout') {
			steps {
				checkout scm
			}
		}

		stage('Build Xtext BOM') {
			steps {
				dir('.m2/repository/org/eclipse/xtext') { deleteDir() }
				dir('.m2/repository/org/eclipse/xtend') { deleteDir() }
				sh 'sh ./1-install-bom.sh'
			}
		}

		stage('Gradle Build') {
			steps {
				sh 'sh ./2-gradle-build.sh'
				step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/test/*.xml'])
			}
		}
		
		stage('Maven Build') {
			steps {
				sh 'sh ./3-maven-build.sh'
			}
		}
	}

	post {
		success {
			archiveArtifacts artifacts: 'build/**'
		}
	}
}
