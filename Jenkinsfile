// tell Jenkins how to build projects from this repository
node {
	try {
		stage 'Checkout'
		checkout scm
		
		stage 'Gradle Build'
        try {
			sh "./gradlew -PuseJenkinsSnapshots=true cleanLocalMavenRepo cleanLocalP2Repo clean build createLocalMavenRepo --refresh-dependencies --continue"
			archive 'build/maven-repository/**/*.*'
		} finally {
			step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/test/*.xml'])
		}
		
		stage 'Maven Build'
        def mvnHome = tool 'M3'
        env.M2_HOME = "${mvnHome}"
        sh "${mvnHome}/bin/mvn -f releng/pom.xml --batch-mode --update-snapshots clean install"
        archive 'build/**/*.*'
		
		slackSend "Build Succeeded - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		
	} catch (e) {
		slackSend color: 'danger', message: "Build Failed - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		throw e
	}
}