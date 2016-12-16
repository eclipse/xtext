// Tell Jenkins how to build projects from this repository
node {
	try {
		stage 'Checkout'
		checkout scm
		
		dir('build') {
			deleteDir()
		}
			
		stage 'Maven Build'
		def mvnHome = tool 'M3'
		env.M2_HOME = "${mvnHome}"
		try {
			sh "${mvnHome}/bin/mvn --batch-mode --update-snapshots -fae -PuseJenkinsSnapshots -Dmaven.test.failure.ignore=true -Dmaven.repo.local=.m2/repository clean deploy"
		} finally {
			step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/*.xml'])
		}
		archive 'build/**'
		
		if (currentBuild.result == 'UNSTABLE') {
			slackSend color: 'warning', message: "Build Unstable - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		} else {
			slackSend color: 'good', message: "Build Succeeded - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		}
	} catch (e) {
		slackSend color: 'danger', message: "Build Failed - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		throw e
	}
}
