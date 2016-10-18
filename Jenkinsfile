// tell Jenkins how to build projects from this repository
node {
	try {
		stage 'Checkout'
		checkout scm
		
		dir('build') {
    		deleteDir()
		}
			
		stage 'Gradle Build'
		sh "./gradlew -PuseJenkinsSnapshots=true cleanLocalMavenRepo clean build createLocalMavenRepo --refresh-dependencies --continue"
		archive 'build/maven-repository/**/*.*'
		step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/*.xml'])
		
		stage 'Maven Build'
		def mvnHome = tool 'M3'
		env.M2_HOME = "${mvnHome}"
		wrap([$class:'Xvnc', useXauthority: true]) {
			sh "${mvnHome}/bin/mvn --batch-mode --update-snapshots -fae -Dmaven.repo.local=local-maven-repository/ clean deploy"
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