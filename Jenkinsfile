// Tell Jenkins how to build projects from this repository
node {
	try {
		stage 'Checkout'
		checkout scm
		
		stage 'Gradle Build'
		try {
			sh "./gradlew clean build createLocalMavenRepo --refresh-dependencies --continue"
		} finally {
			step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/test/*.xml'])
		}
		
		stage 'Maven Build'
		def mvnHome = tool 'M3'
		env.M2_HOME = "${mvnHome}"
		dir('.m2/repository/org/eclipse/xtext') { deleteDir() }
		dir('.m2/repository/org/eclipse/xtend') { deleteDir() }
		sh "${mvnHome}/bin/mvn -f releng --batch-mode --update-snapshots -Dmaven.repo.local=.m2/repository clean install"
		
		archive 'build/**'
		slackSend "Build Succeeded - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		
	} catch (e) {
		slackSend color: 'danger', message: "Build Failed - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		throw e
	}
}