node {
	properties([
		[$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator', numToKeepStr: '15']]
	])
	
	stage('Checkout') {
		checkout scm
	}
	
	stage('Build') {
		sh "./gradlew clean build createLocalMavenRepo -PuseJenkinsSnapshots=true -PignoreTestFailures=true -PupstreamBranch=develop_2.15.0 --refresh-dependencies --continue"
		step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/test/*.xml'])
	}
	
	archive 'build/maven-repository/**'
}
