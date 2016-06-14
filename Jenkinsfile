// tell Jenkins how to build projects from this repository
node {
	   stage 'Checkout'
	   checkout scm
	
	   stage 'Gradle Build'
	   sh "./gradlew build"
	   archive '**/build/**/*.jar'
	   
	   stage 'Maven Build'
	   def mvnHome = tool 'M3'
	   sh "${mvnHome}/bin/mvn clean install"
	   archive '**/target/**/*.jar'
}  