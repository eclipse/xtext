// tell Jenkins how to build projects from this repository
node {
	try {
		stage 'Checkout'
		checkout scm
			
		stage 'Maven Build'
		def mvnHome = tool 'M3'
		env.M2_HOME = "${mvnHome}"
		sh "rm -r target/maven-repository/"
		sh "${mvnHome}/bin/mvn clean install --update-snapshots -PuseJenkinsSnapshots -Dmaven.repo.local=target/maven-repository/"
		archive '**/target/**/*.jar'
				
		slackSend "Build Succeeded - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		
	} catch (e) {
		slackSend color: 'danger', message: "Build Failed - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		throw e
	} finally {
		step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/*.xml'])
	}
}  