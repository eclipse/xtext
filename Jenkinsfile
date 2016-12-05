node {
	try {
		stage 'Checkout'
		checkout scm
			
		stage 'Maven Build'
		dir('build') {
    		deleteDir()
		}
		def mvnHome = tool 'M3'
		wrap([$class:'Xvnc', useXauthority: true]) {
			sh "${mvnHome}/bin/mvn -f releng --batch-mode --update-snapshots -fae -Dmaven.repo.local=local-maven-repository/ clean install"
		}
		archive 'build/**/*.*'
				
		slackSend "Build Succeeded - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		
	} catch (e) {
		slackSend color: 'danger', message: "Build Failed - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		throw e
	}
}  