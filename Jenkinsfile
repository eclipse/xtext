// tell Jenkins how to build projects from this repository
node {
	try {
		stage 'Checkout'
		checkout scm
			
		stage 'Gradle Build'
		sh "./gradlew cleanLocalMavenRepo clean build createLocalMavenRepo --refresh-dependencies --continue"
		archive 'build/maven-repository/**/*.*'
		
		stage 'Maven Build'
		def mvnHome = tool 'M3'
		wrap([$class:'Xvnc', useXauthority: true]) {
			sh "${mvnHome}/bin/mvn --batch-mode --update-snapshots -fae -Dmaven.test.failure.ignore=true -Dmaven.repo.local=build/maven-repository/ clean install"
		}
		archive 'build/**/*.*'
				
		slackSend "Build Succeeded - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		
	} catch (e) {
		slackSend color: 'danger', message: "Build Failed - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		throw e
	} finally {
		step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/*.xml'])
	}
}  