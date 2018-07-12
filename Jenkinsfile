node {
	properties([
		[$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator', numToKeepStr: '15']]
	])
	
	stage('Checkout') {
		checkout scm
	}
	
	stage('Gradle Build') {
		sh "./gradlew clean cleanGenerateXtext build createLocalMavenRepo -PcompileXtend=true -PJENKINS_URL=$JENKINS_URL -PignoreTestFailures=true --refresh-dependencies --continue"
		step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/test/*.xml'])
	}
	
	stage('Maven Build') {
		def mvnHome = tool 'M3'
		env.M2_HOME = "${mvnHome}"
		dir('.m2/repository/org/eclipse/xtext') { deleteDir() }
		dir('.m2/repository/org/eclipse/xtend') { deleteDir() }
		sh "${mvnHome}/bin/mvn -f releng --batch-mode --update-snapshots -Dmaven.repo.local=.m2/repository -DJENKINS_URL=$JENKINS_URL -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn clean install"
	}
	
	archive 'build/**'
}
